package com.example.rental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginAs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as);
    }

    public void Sign(View view) {
        Toast.makeText(this, "This is SignUp Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginAs.this,SignUpPage.class);
        startActivity(intent);
    }
}