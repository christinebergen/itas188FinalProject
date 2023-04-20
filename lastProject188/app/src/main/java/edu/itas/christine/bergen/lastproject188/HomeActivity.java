package edu.itas.christine.bergen.lastproject188;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class HomeActivity extends AppCompatActivity {

    TextView name;
    Button logout;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name=findViewById(R.id.name);
        logout=findViewById(R.id.logout);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        //display user's google account name
        if(account!=null){
            String userName = account.getDisplayName();
            name.setText(userName);
        }
        logout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SignOut();
            }
        });

    }
    //sign out function
    private void SignOut() {

        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {

            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });

    }
    //go to 2000's page
    public void goPage2000(View view) {
        startActivity(new Intent(HomeActivity.this, SecondActivity.class));
    }
    //go to 1980's page
    public void goPage1980(View view) {
        startActivity(new Intent(HomeActivity.this, FourthActivity.class));
    }
    //go to 1970s page
    public void goPage1970(View view) {
        startActivity(new Intent(HomeActivity.this, FifthActivity.class));
    }
    }