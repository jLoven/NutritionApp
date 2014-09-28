package com.jackieloven001.nutritionapp.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

/**
 * Created by Jackie Loven on 9/26/14.
 */
public class DisplaySettings extends Activity{

    public static final String PREFS_NAME = "MyPreferencesFile";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_settings);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        TextView userGender = (TextView) findViewById(R.id.textViewUserGender);
        TextView userHeight = (TextView) findViewById(R.id.textViewUserHeight);
        TextView userWeight = (TextView) findViewById(R.id.textViewUserWeight);
        TextView userAge = (TextView) findViewById(R.id.textViewUserAge);
        TextView userFood1 = (TextView) findViewById(R.id.textViewUserFood1);
        TextView userFood2 = (TextView) findViewById(R.id.textViewUserFood2);
        TextView userFood3 = (TextView) findViewById(R.id.textViewUserFood3);

        userGender.setText(settings.getString("userGender", "Male"));
        userHeight.setText(settings.getString("userHeight", "57"));
        userWeight.setText(settings.getString("userWeight", "150"));
        userAge.setText(settings.getString("userAge", "18"));
        userFood1.setText(settings.getString("userFood1", "Pineapple"));
        userFood2.setText(settings.getString("userFood2", "Cake"));
        userFood3.setText(settings.getString("userFood3", "Hamburger"));
    }

}
