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
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText name,id,location,email,whatyoudo,records,intrest,password,confirmpass;
    Button register;

    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
        findIds();
    }



    private boolean validate() {
        boolean result =false;
        String getname=name.getText().toString();
        String getemail=email.getText().toString();
        String getpassword=password.getText().toString();
        String getconfirmpassword=confirmpass.getText().toString();

        if (getname.isEmpty()){
            Toast.makeText(this, "The user name is empty", Toast.LENGTH_SHORT).show();

        }else if(getemail.isEmpty()) {
            Toast.makeText(this, "The email is empty", Toast.LENGTH_SHORT).show();

        }else if(getpassword.isEmpty()){
            Toast.makeText(this, "the password is empty", Toast.LENGTH_SHORT).show();

        }else if(getconfirmpassword.isEmpty()){
            Toast.makeText(this, "the confirm password  is empty", Toast.LENGTH_SHORT).show();

        }
//        else if(!getpassword.equals(confirmpassword)){
//            Toast.makeText(this, "password mismatch", Toast.LENGTH_SHORT).show();
//
//        }
        else {
            result=true;
        }
        return result;
    }





    private void findIds() {
        name=(EditText)findViewById(R.id.etname);
        email=(EditText)findViewById(R.id.etemail);
        password=(EditText)findViewById(R.id.etpassword);
        confirmpass=(EditText)findViewById(R.id.etconfirm);

        register=(Button) findViewById(R.id.btnreg);

    }

    public void MovetoLogin(View view) {
        if (validate()){
            String reg_email=email.getText().toString().trim();
            String reg_password=password.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(reg_email,reg_password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Registration was succefull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,VerificationActivity.class));

                            }else{
                                Toast.makeText(RegisterActivity.this, "Registration not succefull", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }

    }
    }

