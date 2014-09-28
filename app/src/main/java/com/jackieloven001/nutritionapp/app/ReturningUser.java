package com.jackieloven001.nutritionapp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ReturningUser extends Activity {

    View mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.returning_user_choices);

        mainView = (View) findViewById(R.id.choiceLayout);
        mainView.setBackgroundColor(getResources().getColor(R.color.slightGreen));

        ImageButton btnMyCalendar = (ImageButton) findViewById(R.id.btnMyCalendar);
        ImageButton btnNewPlan = (ImageButton) findViewById(R.id.btnNewPlan);

        btnMyCalendar.setBackgroundResource(R.drawable.my_calendar);
        btnNewPlan.setBackgroundResource(R.drawable.new_plan);

        btnMyCalendar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // introduce the SharedPreferences object as an object called
                // settings
                Intent intent = new Intent(getApplicationContext(),NewUserSettings.class);
                startActivity(intent);

            }
        });

        btnNewPlan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // introduce the SharedPreferences object as an object called
                // settings
                Intent intent = new Intent(getApplicationContext(),PickFoods.class);
                startActivity(intent);

            }
        });

    }

}