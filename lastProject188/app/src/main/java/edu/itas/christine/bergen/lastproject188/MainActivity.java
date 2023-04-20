package edu.itas.christine.bergen.lastproject188;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

// ITAS 188 Android Mobile App Development
// Final Project
// @author cbergen
// This app was created to be able to access, watch, and share old home movies that are stored in cloud storage.
// In the future, I hope to be able to develop this app into something useful without the hard-coded
// URLs and other information, with the information being obtained from the database.
// Videos are currently hosted on Google cloud with public URL access. Google Authentication was added for extra
// security. At the moment the videos can be accessed without the google authentication, but future
// plans would make google authentication essential and only approved users would be able to access the videos.

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    ImageView google_img;

    GoogleSignInClient gsc;
    GoogleSignInOptions gso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This tutorial helped with the google sign in and authentication:
        // https://www.geeksforgeeks.org/google-signing-using-firebase-authentication-in-android-using-java/
        // With ChatGPT to help implement google auth

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        google_img = findViewById(R.id.google);

        //set on click listener for google log in
        google_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Google sign-in button clicked.");
                SignIn();
            }
        });
    }
    //sign in function
    private void SignIn() {
        Intent signInIntent = gsc.getSignInIntent();
        Log.d(TAG, "Launching sign-in activity.");
        startActivityForResult(signInIntent, 1000);
    }

    @Override //sign in and authenticate with google
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToHomeActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Error signing in", Toast.LENGTH_SHORT).show();
            }

        }
    }
        //once signed in, go to home screen
    private void navigateToHomeActivity() {
        finish();
        Toast.makeText(getApplicationContext(), "Make sure you're connected to Wifi or the videos won't play!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}






