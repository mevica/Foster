package com.example.forster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RecyclerviewActivity extends AppCompatActivity {

    private RecyclerView mChildlist;
    private DatabaseReference mRef;
    private FirebaseDatabase mDatabase;
    private ArrayList<Child> arrayList;
    private ArrayList<String> categoryList;
    //private FirebaseRecyclerOptions<Child> options;
    // private FirebaseRecyclerAdapter<Child, FirebaseViewholder> adapter;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        image = (ImageView) findViewById(R.id.childimg);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference();
        //mRef = mDatabase.getReference().Child("children");
        // mRef.keepSynced(true);

        mChildlist = (RecyclerView) findViewById((R.id.myrecyclerview));
        mChildlist.setHasFixedSize(true);
        mChildlist.setLayoutManager(new LinearLayoutManager(this));
        // final List<Child>arrayList=new ArrayList<>();

        mRef.child("children").limitToLast(20).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    final Child child1 = child.getValue(com.example.forster.Child.class);
                    arrayList.add(child1);
                }
                final RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(arrayList, RecyclerviewActivity.this);
                mChildlist.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // ActionBar actionBar = getSupportActionBar();
        // actionBar.setTitle("Children List");

        // options = new FirebaseRecyclerOptions.Builder<Child>().setQuery(mRef, Child.class).build();
        // adapter = new FirebaseRecyclerAdapter<Child, FirebaseViewholder>(options) {


//            @NonNull
//            @Override
//            public FirebaseViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                return new FirebaseViewholder(LayoutInflater.from(RecyclerviewActivity.this).inflate(R.layout.childrecycler,parent,false));
//            }
//
//            @Override
//            protected void onBindViewHolder(@NonNull FirebaseViewholder firebaseViewholder, int i, @NonNull Child Child) {
//                firebaseViewholder.setDetails(Child.getName(),Child.getDescription());
//            }
//        };
//
//
//
//        mChildlist.setAdapter(adapter);


    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        mRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String Image=dataSnapshot.Child("Image").toString();
//
//                if(!Image.isEmpty()) {
//                //    Picasso.get().load(Image).into(image);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
}

