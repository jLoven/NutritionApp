package com.jackieloven001.nutritionapp.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class SwipeFoods extends Activity {

    private Context m_context;
    RelativeLayout parentView;
    int windowwidth;
    int windowheight;
    int screenCenter;
    int x_cord, y_cord;
    int imageHeight;
    float y_cord_edited;
    float first_x;

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //dunno what this does
        setContentView(R.layout.main_layout);
        m_context = SwipeFoods.this;

        /*try{
            URL url = new URL("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" + "Hamburger");
            URLConnection connection = url.openConnection();

            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONObject json = new JSONObject(builder.toString());
            String imageUrl = json.getJSONObject("responseData").getJSONArray("results").getJSONObject(0).getString("url");

            Bitmap image = BitmapFactory.decodeStream(new URL(imageUrl).openStream());


            FileOutputStream out = null;
            try {
                out = new FileOutputStream("drawable/tinder_swipe_image.jpg");
                image.compress(Bitmap.CompressFormat.JPEG, 90, out);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/

            parentView = (RelativeLayout) findViewById(R.id.layoutview1);
            windowwidth = getWindowManager().getDefaultDisplay().getWidth();
            windowheight = getWindowManager().getDefaultDisplay().getHeight();
            screenCenter = windowwidth / 2;

            //ArrayList<Bitmap> listOfImages = new ArrayList<Bitmap>();

            //int[] myImageList = new int[]{R.drawable.cats, R.drawable.baby1, R.drawable.sachin,
            //R.drawable.cats, R.drawable.puppy};

            for (int i = 0; i < 5; i++) {
                LayoutInflater inflate = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //listOfImages.add(image);

                final View m_view = inflate.inflate(R.layout.swipe, null); // dunno what this does yet
                ImageView m_image = (ImageView) m_view.findViewById(R.id.sp_image); // oh I think you set parameters on this later
                LinearLayout m_topLayout = (LinearLayout) m_view.findViewById(R.id.sp_color);

                m_view.setLayoutParams(new LayoutParams((windowwidth - 80), 450));
                m_view.setX(40);
                m_view.setY(40);
                m_view.setTag(i);
                m_image.setBackgroundResource(R.drawable.tinder_swipe_image);

                imageHeight = m_view.getHeight();

                parentView.addView(m_view);

                if (i == 0) {
                    m_view.setRotation(-1);
                } else if (i == 1) {
                    m_view.setRotation(-5);

                } else if (i == 2) {
                    m_view.setRotation(3);

                } else if (i == 3) {
                    m_view.setRotation(7);

                } else if (i == 4) {
                    m_view.setRotation(-2);

                } else if (i == 5) {
                    m_view.setRotation(5);

                }

                m_topLayout.setOnTouchListener(new OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                first_x = event.getRawX();
                                break;

                            case MotionEvent.ACTION_MOVE:

                                m_view.setX(50 + event.getRawX() - first_x);
                                m_view.setY(175/2 - (event.getRawX() - first_x));
                                m_view.setRotation((float) ((event.getRawX() - first_x)* (Math.PI / 32)));


                                if (event.getRawX() - first_x > 0) {
                                    //n.pushFood("name",True);
                                } else {
                                    //n.pushFood("name",False);
                                }
                                break;

                            case MotionEvent.ACTION_UP:
                                m_view.setRotation(0);
                                parentView.removeView(m_view);
                                break;
                        }
                        return true;
                    }
                });
            }

        /*} catch(Exception e){

            e.printStackTrace();
        }*/



    }
}
