package com.example.rental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.data.DataHolder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetPassword extends AppCompatActivity {
    EditText hintUserId,hintPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
    }

    public void Process(View view) {
        hintUserId=(EditText) findViewById(R.id.hintUserId);
        hintPassword=(EditText) findViewById(R.id.hintPassword);


        String userId = hintUserId.getText().toString().trim();
        String password = hintPassword.getText().toString().trim();

        Dataholder obj = new Dataholder("","",userId,password);
        FirebaseDatabase db = FirebaseDatabase.getInstance();

        DatabaseReference node= db.getReference("Customer");
        node.child(userId).setValue(obj);

        hintPassword.getText();
        Toast.makeText(this, "Value inserted", Toast.LENGTH_SHORT).show();












    }
}