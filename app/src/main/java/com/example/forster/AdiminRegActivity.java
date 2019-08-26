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

public class AdiminRegActivity extends AppCompatActivity {

    EditText email2,password2,confirmpass2;
    Button reg;

    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adimin_reg);
        mAuth=FirebaseAuth.getInstance();
        findIds();
        validate();
    }



    private boolean validate() {
        boolean result =false;
        String getemail2=email2.getText().toString();
        String getpassword2=password2.getText().toString();
        String getconfirmpassword2=confirmpass2.getText().toString();



        if(getemail2.isEmpty()) {
            Toast.makeText(this, "The email is empty", Toast.LENGTH_SHORT).show();

        }else if(getpassword2.isEmpty()){
            Toast.makeText(this, "the password is empty", Toast.LENGTH_SHORT).show();

        }else if(getconfirmpassword2.isEmpty()){
            Toast.makeText(this, "the confirm password  is empty", Toast.LENGTH_SHORT).show();

        }


        else {
            result=true;
        }
        return result;
    }





    private void findIds() {
        email2=(EditText)findViewById(R.id.etemail2);
        password2=(EditText)findViewById(R.id.etpassword2);
        confirmpass2=(EditText)findViewById(R.id.etconfirm2);

        reg=(Button) findViewById(R.id.btnreg2);

    }

    public void MovetoLogin(View view) {
        if (validate()){
            String reg_email=email2.getText().toString().trim();
            String reg_password=password2.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(reg_email,reg_password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(AdiminRegActivity.this, "Registration was succefull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AdiminRegActivity.this,AdminLoginActivity.class));

                            }else{
                                Toast.makeText(AdiminRegActivity.this, "Registration not succefull", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }

    }
}


