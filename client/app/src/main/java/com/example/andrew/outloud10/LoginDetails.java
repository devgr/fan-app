package com.example.andrew.outloud10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


public class LoginDetails extends AppCompatActivity {

    // * VARIABLES *

    EditText userEmail;
    EditText userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_login_details);




        // * LOGIN BUTTON *
        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                // * Prepare Variables *

                Intent myIntent = new Intent(v.getContext(), Login.class);
                userEmail = (EditText) findViewById(R.id.editTextUserEmail);    // REFERENCE TO EditText Email
                userPass = (EditText) findViewById(R.id.editTextUserPass);      // REFERENCE TO EditText Password

                String testEmail = "mail";                                      // REPLACE WHEN NECESSARY
                String testPass = "1234";                                       // REPLACE WHEN NECESSARY

                String email = userEmail.getText().toString();                  // HOLDS USER EMAIL STRING
                String password = userPass.getText().toString();                // HOLDS USER PASSWORD STRING
                int errorType = 0;                                              // Switch-Case Error Value

                // If user password does not match, AND user email is not empty, INCORRECT PASSWORD
                if (!password.equals(testPass) && !email.isEmpty())
                {
                    errorType = 2;
                }

                // If user email does not match, INVALID EMAIL
                if(!email.equals(testEmail))
                {
                    errorType = 1;
                }

                // If neither Email nor Password are entered, INVALID INFO
                if (password.isEmpty() && email.isEmpty())
                {
                    errorType = 3;
                }

                switch (errorType)
                {    // 0 = no errors, 1 = email error, 2 = pass error, 3 = both errors
                    case 0:
                        Toast.makeText(v.getContext(), "Welcome!", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        userEmail.setError("Invalid Email Address");
                        break;
                    case 2:
                        userPass.setError("Incorrect Password");
                        break;
                    case 3:
                        userEmail.setError("Please enter your Email");
                        break;
                }

                // *** JUMP TO NEXT ACTIVITY ***
                //startActivity(myIntent);

            }   // END ONCLICK

        }); // END BUTTON'S ONCLICK LISTENER
    }   // END ONCREATE
}   // END LOGINDETAILS CLASS