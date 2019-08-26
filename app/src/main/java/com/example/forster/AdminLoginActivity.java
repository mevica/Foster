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

public class AdminLoginActivity extends AppCompatActivity {

    EditText Email,Pass,phone;
    Button mlogin;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        Email=(EditText)findViewById(R.id.etemail2);
        Pass=(EditText)findViewById(R.id.etpass2);
      //  phone=(EditText)findViewById(R.id.etphone);
        mlogin=(Button) findViewById(R.id.btnlogin2);

        mAuth= FirebaseAuth.getInstance();
    }

    private boolean validate() {
        boolean result=false;
        String getEmail=Email.getText().toString();
        String getPass=Pass.getText().toString();
      //  String getphone=phone.getText().toString();
        if (getEmail.isEmpty()) {
            Toast.makeText(this, "the email is empty", Toast.LENGTH_SHORT).show();

       // }else if (getphone.isEmpty()){
         //   Toast.makeText(this, "id is empty is empty", Toast.LENGTH_SHORT).show();


        }else if (getPass.isEmpty()) {
            Toast.makeText(this, "the password is empty", Toast.LENGTH_SHORT).show();

        }else{
            result=true;
        }
        return result;

    }

    public void LoginAdmin(View view) {
        if (validate()){

            String email=Email.getText().toString().trim();
            String password=Pass.getText().toString().trim();
            // String Phone=phone.getText().toString().trim();

            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(AdminLoginActivity.this, "Login succesfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AdminLoginActivity.this, AdmininsertActivity.class));
                            }else {
                                Toast.makeText(AdminLoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


        }
    }

    public void gotoreg2(View view) {
        startActivity(new Intent(AdminLoginActivity.this, AdiminRegActivity.class));

    }
}


