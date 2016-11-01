package com.example.andrew.outloud10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Login extends AppCompatActivity {

    Boolean googleOrFB; // * False for Google (DEFAULT), True for FB *

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // * Reset Login Flag *
        googleOrFB = false;

        // * FACEBOOK BUTTON *
        Button button1 = (Button) findViewById(R.id.buttonFacebookLogin);

        button1.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                // *** JUMP TO NEXT ACTIVITY ***
                Intent facebookIntent = new Intent(v.getContext(), LoginDetails.class);
                startActivity(facebookIntent);

                // Set Login flag HERE
                //googleOrFB = true;

            }

        }); // * END FACEBOOK BUTTON *

        // * GOOGLE BUTTON *
        Button button2 = (Button) findViewById(R.id.buttonGoogleLogin);

        button2.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                // *** JUMP TO NEXT ACTIVITY ***
                Intent googleIntent = new Intent(v.getContext(), LoginDetails.class);
                startActivity(googleIntent);

                // Set Login flag HERE
                //googleOrFB = false;

            }

        }); // * END GOOGLE BUTTON *
    }
}