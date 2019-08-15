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

public class MainActivity extends AppCompatActivity {

    EditText mEmail,mPass;
    Button login;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail=(EditText)findViewById(R.id.etemail);
        mPass=(EditText)findViewById(R.id.etpass);
        login=(Button) findViewById(R.id.btnlogin);

        mAuth= FirebaseAuth.getInstance();
    }

    private boolean validate() {
        boolean result=false;
        String getmEmail=mEmail.getText().toString();
        String getmPass=mPass.getText().toString();
        if (getmEmail.isEmpty()){
            Toast.makeText(this, "the email is empty", Toast.LENGTH_SHORT).show();

        }else if (getmPass.isEmpty()) {
            Toast.makeText(this, "the password is empty", Toast.LENGTH_SHORT).show();

        }else{
            result=true;
        }
        return result;

    }

    public void MovetoRegistration(View view) {
        startActivity(new Intent(MainActivity.this,RegisterActivity.class));
    }

    public void LoginUser(View view) {
        if (validate()){

            String email=mEmail.getText().toString().trim();
            String password=mPass.getText().toString().trim();

            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Login succesfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, VerificationActivity.class));
                            }else {
                                Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


        }

    }

    public void gotoreg(View view) {
        startActivity(new Intent(MainActivity.this, RegisterActivity.class));

    }
}
