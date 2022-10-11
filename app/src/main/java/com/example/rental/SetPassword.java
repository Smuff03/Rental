package com.example.rental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.common.data.DataHolder;

public class SetPassword extends AppCompatActivity {
    EditText hintName,hintEmail,hintMobileNO,hintUserId,hintPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
    }

    public void Process(View view) {
        hintName=(EditText) findViewById(R.id.hintName);
        hintEmail=(EditText) findViewById(R.id.hintEmail);
        hintMobileNO=(EditText) findViewById(R.id.hintMobileNo);
        hintUserId=(EditText) findViewById(R.id.hintUserId);
        hintPassword=(EditText) findViewById(R.id.hintPassword);

        String name=hintName.getText().toString().trim();
        String email= hintEmail.getText().toString().trim();
        String mobileNo=hintMobileNO.getText().toString().trim();
        String userId = hintUserId.getText().toString().trim();
        String password = hintPassword.getText().toString().trim();









    }
}