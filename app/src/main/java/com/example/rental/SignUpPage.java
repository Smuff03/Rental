package com.example.rental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignUpPage extends AppCompatActivity {
    TextView name,email,mobileNo,otp;
    EditText hintNme,hintMobileNo,hintOtp,hintEmail;
    Button btnGenOtp, btnVerifyOtp;
    FirebaseAuth mAuth;
    String verificationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        mobileNo = findViewById(R.id.mobileNo);
        otp = findViewById(R.id.otp);
        hintNme = findViewById(R.id.hintName);
        hintMobileNo = findViewById(R.id.hintMobileNo);
        hintOtp = findViewById(R.id.hintOtp);
        hintEmail = findViewById(R.id.hintEmail);
        btnGenOtp = findViewById(R.id.btnGenOtp);
        btnVerifyOtp = findViewById(R.id.btnVerifyOtp);
        mAuth = FirebaseAuth.getInstance();



        btnGenOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(hintMobileNo.getText().toString())) {
                    Toast.makeText(SignUpPage.this, "Enter valid mobile number", Toast.LENGTH_SHORT).show();

                } else {
                    String number = hintMobileNo.getText().toString();


                    sendotpverificationcode(number);
                }
            }
        });
        btnVerifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(hintOtp.getText().toString())) {
                    Toast.makeText(SignUpPage.this, "Wrong OTP enter", Toast.LENGTH_SHORT).show();

                } else

                    verifycode(hintOtp.getText().toString());
            }
        });

    }

    private void sendotpverificationcode(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {

            final  String code= credential.getSmsCode();
            if (code!=null){
                verifycode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(SignUpPage.this, "verification failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s,
                               @NonNull PhoneAuthProvider.ForceResendingToken token) {
            super.onCodeSent(s,token);
            verificationId=s;

        }
    };

    private void verifycode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signinbycredentials(credential);
    }

    private void signinbycredentials(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignUpPage.this,"Login succeessfull",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpPage.this,SetPassword.class));

                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser!=null){
            startActivity(new Intent(SignUpPage.this,SetPassword.class));
        }
    }
}



