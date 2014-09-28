package com.jackieloven001.nutritionapp.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

/**
 * Created by Jackie Loven on 9/26/14.
 */
public class DisplaySettings2 extends Activity{

    public static final String PREFS_NAME2 = "MyPreferencesFile2";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_settings2);
        SharedPreferences settings2 = getSharedPreferences(PREFS_NAME2, 0);

        TextView userFood1 = (TextView) findViewById(R.id.textViewUserFood1);
        TextView userFood2 = (TextView) findViewById(R.id.textViewUserFood2);
        TextView userFood3 = (TextView) findViewById(R.id.textViewUserFood3);

        userFood1.setText(settings2.getString("userFood1", "Pineapple"));
        userFood2.setText(settings2.getString("userFood2", "Cake"));
        userFood3.setText(settings2.getString("userFood3", "Hamburger"));
    }

}
