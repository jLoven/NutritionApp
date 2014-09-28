package com.jackieloven001.nutritionapp.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class SwipeFoods extends Activity implements OnTouchListener {

    public static final String PREFS_NAME = "MyPreferencesFile";


    public static final String PREFS_NAME2 = "MyPreferencesFile2";

    SharedPreferences settings;
    SharedPreferences settings2;

    String gender;
    String agestr;
    String weightstr;
    String heightstr;

    String food1;
    String food2;
    String food3;

    Integer age;
    Integer weight;
    Integer height;
    private Context m_context;
    RelativeLayout parentView;
    int windowwidth;
    int windowheight;
    int screenCenter;
    int imageHeight;
    float first_x;

    Nutrition n;
    private String placeholder="";

    public String getURLForImage() {
        try {
            placeholder = placeholder.replace(" " , "&");
            URL url = new URL("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" + placeholder);
            URLConnection connection = url.openConnection();

            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONObject json = new JSONObject(builder.toString());
            return json.getJSONObject("responseData").getJSONArray("results").getJSONObject(0).getString("url");
        }catch(Exception e)
        {
            Log.e("Failed to obtain URL for image", e.getMessage());
            return null;
        }
    }

    public Bitmap getImageForURL(String url) {
        try {
            Log.i("Images", url);
            Bitmap image = BitmapFactory.decodeStream(new URL(url).openStream());
            return image;
        } catch (Exception e) {
            return null;
        }
    }

    public void addSwipeableImage(Bitmap image) {

        m_context = SwipeFoods.this;

        parentView = (RelativeLayout) findViewById(R.id.layoutview1);
        windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        windowheight = getWindowManager().getDefaultDisplay().getHeight();
        screenCenter = windowwidth / 2;


        for (int i = 0; i < 1; i++) {

            LayoutInflater inflate = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View m_view = inflate.inflate(R.layout.swipe, null);
            ImageView m_image = (ImageView) m_view.findViewById(R.id.sp_image); // oh I think you set parameters on this later
            LinearLayout m_topLayout = (LinearLayout) m_view.findViewById(R.id.sp_color);

            m_view.setLayoutParams(new LayoutParams((windowwidth - 80), 1200));
            m_view.setX(40);
            m_view.setY(40);
            m_view.setTag(i);
            m_image.setImageBitmap(image);

            imageHeight = m_view.getHeight();

            parentView.post(new Runnable() {
                public void run() {
                    parentView.addView(m_view);
                }
            });

            m_topLayout.setOnTouchListener(this);

        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event){


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                first_x = event.getRawX();
                break;

            case MotionEvent.ACTION_MOVE:

                v.setX(50 + event.getRawX() - first_x);
                v.setY(175 / 2 - (event.getRawX() - first_x));
                v.setRotation((float) ((event.getRawX() - first_x) * (Math.PI / 32)));

                if (event.getRawX() - first_x > 0) {
                    //n.pushFood("name",True);
                    try{
                    n.pushFood(placeholder,true);placeholder = "xyz";}catch(Exception e){}
                } else {
                    //n.pushFood("name",False);

                    try{
                        n.pushFood(placeholder,false);placeholder = "xyz";}catch(Exception e){}
                }
                break;

            case MotionEvent.ACTION_UP:
                v.setRotation(0);
                ((ViewGroup) v.getParent()).removeView(v);
                break;
        }

        return true;
    }

    public void createDisplay() {

        settings = getSharedPreferences(PREFS_NAME, 0);
        settings2 = getSharedPreferences(PREFS_NAME2, 0);

        gender = (settings.getString("userGender", "M"));
        agestr = (settings.getString("userAge", "18"));
        weightstr = (settings.getString("userWeight", "90"));
        heightstr = (settings.getString("userHeight", "170"));

        food1 = (settings2.getString("userFood1", "Pineapple"));
        food2 = (settings2.getString("userFood2", "Cake"));
        food3 = (settings2.getString("userFood3", "Hamburger"));

        age = new Integer(agestr);
        weight = new Integer(weightstr);
        height = new Integer(heightstr);

        n = new Nutrition(gender, age.intValue(), weight.intValue(), height.intValue());

        n.addReq(food1);
        n.addReq(food2);
        n.addReq(food3);
        while(n.results().size()==0)
        imgrun();
//            while(!placeholder.equals("xyz"))
//            {
//            }





    }
    public void imgrun()
    {
        placeholder=n.pullFood();
        String url = getURLForImage();
        //Log.i("URL STRING", url);
        Bitmap image = getImageForURL(url);
        addSwipeableImage(image);
    }

    class myThread extends Thread
    {
        private SwipeFoods food;

        public myThread(SwipeFoods food)
        {
            this.food = food;
        }
        public void run()
        {
            this.food.createDisplay();
        }
    }

    private myThread createViewThread;

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //dunno what this does
        setContentView(R.layout.main_layout);

        createViewThread = new myThread(this);
        createViewThread.start();
    }
}