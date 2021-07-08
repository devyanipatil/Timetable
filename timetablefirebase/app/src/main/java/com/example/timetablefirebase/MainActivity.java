package com.example.timetablefirebase;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    Button msignUp, gotologin;
    EditText mEmail, mPassword;
    FirebaseAuth fAuth, auth;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        msignUp = findViewById(R.id.signup);


        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.Password);

        msignUp = findViewById(R.id.signup);


        fAuth = FirebaseAuth.getInstance();



//        FirebaseUser user = auth.getCurrentUser();


        msignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                if (email.isEmpty()) {
                    mEmail.setError("Email is required");
                    return;
                }
                if (password.length() < 6) {
                    mPassword.setError("Password should be more than 6 letters");
                }

                //getting this stuff on firebase
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Hurray!You are registered.", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(MainActivity.this, "Error! ", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }

        });
    }
}
//        if(!auth.getCurrentUser().isEmailVerified()){       // checking if the email is already verified or not
//
//        }
//        progressbar = findViewById(R.id.progressBar);


//        if(fAuth.getCurrentUser() != null){   // this code was getting me to the login page
//            startActivity(new Intent(getApplicationContext(),Login.class));
//            finish();
//        }
//        verifyEmailbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //send verification email
//                auth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        Toast.makeText(MainActivity.this, "Verification Email is Sent", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });





//
//    public void openNewActivity() {
//        Intent i = new Intent(MainActivity.this, Login.class);
//        startActivity(i);
//    }



//if(task.isSuccessful()){
//        Toast.makeText(MainActivity.this, "Hurray!You are registered.Check your email for verification of your account", Toast.LENGTH_LONG).show();
//        Intent i = new Intent(MainActivity.this, Login.class);
//        startActivity(i);
//        }
//        else {
//        Toast.makeText(MainActivity.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();