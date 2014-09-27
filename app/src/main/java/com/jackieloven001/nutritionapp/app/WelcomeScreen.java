package com.jackieloven001.nutritionapp.app;

/**
 * Created by Jackie Loven on 9/26/14.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;

public class WelcomeScreen extends Activity{

    View mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_of_user);

        mainView = (View) findViewById(R.id.mainLayout);
        mainView.setBackgroundColor(getResources().getColor(R.color.slightGreen));

        ImageButton btnNew = (ImageButton) findViewById(R.id.btnNewUser);
        ImageButton btnReturning = (ImageButton) findViewById(R.id.btnReturningUser);

        btnNew.setBackgroundResource(R.drawable.first_time_user);
        btnReturning.setBackgroundResource(R.drawable.returning_user);

        btnNew.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // introduce the SharedPreferences object as an object called
                // settings
                Intent intent = new Intent(getApplicationContext(),NewUserSettings.class);
                startActivity(intent);

            }
        });

        btnReturning.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // introduce the SharedPreferences object as an object called
                // settings
                Intent intent = new Intent(getApplicationContext(),ReturningUser.class);
                startActivity(intent);

            }
        });

    }

}
