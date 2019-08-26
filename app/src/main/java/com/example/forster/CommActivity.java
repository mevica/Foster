package com.example.forster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class CommActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm);
        String Name=getIntent().getStringExtra("Name");
        String Description=getIntent().getStringExtra("Description");
        String Image=getIntent().getStringExtra("Image");
        Log.i("OUR VALUE",Name);
        Log.i("OUR VALUE2",Image);
        Log.i("OUR VALUE3",Description);
        Toast.makeText(this, ""+Name, Toast.LENGTH_SHORT).show();
    }
}
// firebaseViewholder.setDetails(getApplicationContext(),Child.getName(),Child.getDescription(),Child.getImage());



//    View mView;
//    public FirebaseViewholder(@NonNull View itemView) {
//        super(itemView);
//        mView=itemView;
//    }
//
//    public <val> void setDetails(Context ctx, String Name, String Description, String Image){
//        ImageView childimg=(ImageView) mView.findViewById(R.id.childimg);
//        TextView tvname=(TextView) mView.findViewById(R.id.tvname);
//        TextView tvdesc=(TextView) mView.findViewById(R.id.tvdesc);
//
//        tvdesc.setText(Description);
//        tvname.setText(Name);
//        Picasso.get().load(Image).into(childimg);
//       // val picasso = Picasso.get().load(Image).into(childimg);
//    }