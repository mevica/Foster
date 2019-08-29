package com.example.forster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VerificationActivity extends AppCompatActivity {
    EditText fullname,id,location,whatyoudo,interst,record;
    Button btnverify;
    user User;
     FirebaseDatabase database;
     DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);


        fullname = (EditText) findViewById(R.id.etfullname);
        id = (EditText) findViewById(R.id.etID);
        location = (EditText) findViewById(R.id.etlocation);
        whatyoudo = (EditText) findViewById(R.id.etwhatyoudo);
        interst = (EditText) findViewById(R.id.etintrest);
        record = (EditText) findViewById(R.id.etcriminal);
        btnverify = (Button) findViewById(R.id.btnverify);

//        if (validate())
//        database = FirebaseDatabase.getInstance();
//        ref = database.getReference("user");

        ref=FirebaseDatabase.getInstance().getReference().child("user");
        User = new user();

        btnverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.setFullname(fullname.getText().toString());
                User.setId(id.getText().toString());
                User.setLocation(location.getText().toString());
                User.setWhatyoudo(whatyoudo.getText().toString());
                User.setIntrest(interst.getText().toString());
                User.setRecord(record.getText().toString());

                ref.push().setValue(User).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(VerificationActivity.this, "submited successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(VerificationActivity.this,MainActivity.class));

                        } else {
                            Toast.makeText(VerificationActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }


                });

            }
        });
    }
//
//    private void getValues()
//    {
//      User.setFullname(fullname.getText().toString());
//      User.setId(id.getText().toString());
//      User.setLocation(location.getText().toString());
//      User.setWhatyoudo(whatyoudo.getText().toString());
//      User.setIntrest(interst.getText().toString());
//      User.setRecord(record.getText().toString());
//    }
//
//
//    public void MovetoLogin(View view) {
//        startActivity(new Intent(VerificationActivity.this,MainActivity.class));
//
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                getValues();
//        ref.Child("user02").setValue(User);
//                Toast.makeText(VerificationActivity.this,"Data inserted",Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }

    private boolean validate() {
        boolean result =false;
        String getfullname=fullname.getText().toString();
        String getid=id.getText().toString();
        String getlocation=location.getText().toString();
        String getwhatyoudo=whatyoudo.getText().toString();
        String getintrest=interst.getText().toString();
        String getrecord=whatyoudo.getText().toString();

        if (getfullname.isEmpty()){
            Toast.makeText(this, "The fullname is empty", Toast.LENGTH_SHORT).show();

        }else if(getid.isEmpty()) {
            Toast.makeText(this, "The id is empty", Toast.LENGTH_SHORT).show();

        }else if(getlocation.isEmpty()){
            Toast.makeText(this, "location is empty", Toast.LENGTH_SHORT).show();

        }else if(getwhatyoudo.isEmpty()){
            Toast.makeText(this, "what you do  is empty", Toast.LENGTH_SHORT).show();

        }
        else if(getintrest.isEmpty()){
            Toast.makeText(this, "intrest is empty", Toast.LENGTH_SHORT).show();

        }else if(getrecord.isEmpty()){
            Toast.makeText(this, "record  is empty", Toast.LENGTH_SHORT).show();

        }

        else {
            result=true;
        }
        return result;
    }


}
