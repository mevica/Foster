package com.example.forster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    EditText mName, mEmail, mPassword, mConfirmpass;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        findIds();
    }

    public void SignUp(View view) {

        String email = mEmail.getText().toString();
        String pass = mPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this,VerificationActivity.class));

                        } else {
                            Toast.makeText(SignUpActivity.this, "Not succesfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    private void findIds() {
        mEmail = (EditText) findViewById(R.id.etemail);
        mPassword = (EditText) findViewById(R.id.etpassword);

    }

}
