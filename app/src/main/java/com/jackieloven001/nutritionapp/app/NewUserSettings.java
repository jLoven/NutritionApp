package com.jackieloven001.nutritionapp.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Jackie Loven on 9/26/14.
 */
public class NewUserSettings extends Activity {

    View saveView;

    public static final String PREFS_NAME = "MyPreferencesFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_user_settings);

        final AutoCompleteTextView userHeight = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        final AutoCompleteTextView userWeight = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        final AutoCompleteTextView userAge = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView3);
        final AutoCompleteTextView userGender = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView4);

        ImageButton btnSaving = (ImageButton) findViewById(R.id.btnSave);
        btnSaving.setBackgroundResource(R.drawable.save);

        saveView = (View) findViewById(R.id.saveLayout);
        saveView.setBackgroundColor(getResources().getColor(R.color.slightGreen));

        btnSaving.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // introduce the SharedPreferences object as an object called
                // settings
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();

                editor.putString("userGender", userGender.getText().toString());
                editor.putString("userHeight", userHeight.getText().toString());
                editor.putString("userWeight", userWeight.getText().toString());
                editor.putString("userAge", userAge.getText().toString());

                editor.commit();

                Intent intent = new Intent(getApplicationContext(),DisplaySettings.class);
                startActivity(intent);

            }
        });


    }
}
