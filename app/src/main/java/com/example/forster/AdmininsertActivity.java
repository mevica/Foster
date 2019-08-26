package com.example.forster;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.net.URI;

public class AdmininsertActivity extends AppCompatActivity {
    Button submit;
    EditText Name, Description;
    ImageView Image;
    StorageReference mStorageRef;
    FirebaseDatabase mDB;
    DatabaseReference reff;
    children Children;
    private StorageTask uploadTask;
    public Uri imguri;
private static final int IMAGE_PICK_CODE=1000;
private static final int PERMISSION_CODE=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admininsert);

        mStorageRef = FirebaseStorage.getInstance().getReference("Image");

        submit = (Button) findViewById(R.id.btnsubmit);
        Name = (EditText) findViewById(R.id.etfname);
        Description = (EditText) findViewById(R.id.etdescribtion);
        Image = (ImageView) findViewById(R.id.imchild);

        //select image
        Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Filechooser();
            }
        });

        mDB = FirebaseDatabase.getInstance();

        reff = FirebaseDatabase.getInstance().getReference().child("children");
        Children = new children();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Children.setName(Name.getText().toString());
                Children.setDescription(Description.getText().toString());

                byte[] fileByte = FileHelper.getByteArrayFromFile(AdmininsertActivity.this, imguri);
                String encodedImage = Base64.encodeToString(fileByte, Base64.NO_WRAP);
                Children.setImage(encodedImage);

                reff.push().setValue(Children).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(AdmininsertActivity.this, "submited succesfuly", Toast.LENGTH_SHORT).show();
                         } else {
                            Toast.makeText(AdmininsertActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }


                });



            }
        });
    }

    private String getExtention(Uri uri){
        ContentResolver cr=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

//    private void Fileuploader() {
//        StorageReference Ref=mStorageRef.Child(System.currentTimeMillis()+","+getExtention(imguri));
//
//       uploadTask= Ref.putFile(imguri)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        // Get a URL to the uploaded content
//                       // Uri downloadUrl = taskSnapshot.getDownloadUrl();
//                        Toast.makeText(AdmininsertActivity.this, "uploaded succesfully", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        // Handle unsuccessful uploads
//                        // ...
//                    }
//                });


    //upload img
    private void Filechooser(){
        Intent intent= new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);

    }



//    private void pickImageFromGallery() {
//        //intent to pick image
//        Intent intent= new Intent(Intent.ACTION_PICK);
//        intent.setType("image/*");
//        startActivityForResult(intent,IMAGE_PICK_CODE);
//    }

    //handle results of runtime permission

   // @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode){
//            case PERMISSION_CODE:{
//                if(grantResults.length>0&& grantResults[0]==
//                PackageManager.PERMISSION_GRANTED){
//                  //  pickImageFromGallery();
//                }else{
//                    Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//    }

    //handle rusults for picked image

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==RESULT_OK && requestCode==IMAGE_PICK_CODE){
            Image.setImageURI(data.getData());
        }
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imguri=data.getData();
            Image.setImageURI(imguri);
        }
    }
}










