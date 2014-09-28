package com.jackieloven001.nutritionapp.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;

/**
 * Created by Jackie Loven on 9/27/14.
 */
public class PickFoods extends Activity{

    public static final String PREFS_NAME2 = "MyPreferencesFile2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_foods);

        View mainViewPick;

        final AutoCompleteTextView inputFood1view = (AutoCompleteTextView) findViewById(R.id.inputFood1);
        final AutoCompleteTextView inputFood2view= (AutoCompleteTextView) findViewById(R.id.inputFood2);
        final AutoCompleteTextView inputFood3view = (AutoCompleteTextView) findViewById(R.id.inputFood3);

        mainViewPick = (View) findViewById(R.id.addLayout);
        mainViewPick.setBackgroundColor(getResources().getColor(R.color.slightGreen));

        ImageButton btnSaveFoods = (ImageButton) findViewById(R.id.btnSaveFoods);
        btnSaveFoods.setBackgroundResource(R.drawable.find_my_food);

        btnSaveFoods.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // introduce the SharedPreferences object as an object called
                // settings
                SharedPreferences settings2 = getSharedPreferences(PREFS_NAME2, 0);
                SharedPreferences.Editor editor2 = settings2.edit();
                editor2.putString("userFood1", inputFood1view.getText().toString());
                editor2.putString("userFood2", inputFood2view.getText().toString());
                editor2.putString("userFood3", inputFood3view.getText().toString());

                editor2.commit();

                Intent intent = new Intent(getApplicationContext(), SwipeFoods.class);
                startActivity(intent);

            }
        });

    }
}
