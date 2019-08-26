package com.example.forster;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

import java.util.ArrayList;
import java.util.List;

public class FirebaseViewholder extends RecyclerView.ViewHolder {

    private List<Child>mData=new ArrayList<>();
    private Context mContext;

    public FirebaseViewholder(@NonNull View itemView, List<Child> mData, Context mContext) {
        super(itemView);
        this.mData = mData;
        this.mContext = mContext;
    }

    public FirebaseViewholder(@NonNull View itemView) {
        super(itemView);

    }

//    View mView;
//
//    public FirebaseViewholder(@NonNull View itemView) {
//        super(itemView);
//        mView=itemView;
//    }
//
//    public void setDetails(String Name,String Description){
//        TextView tvname=mView.findViewById(R.id.tvname);
//        TextView tvdesc=mView.findViewById(R.id.tvdesc);
//
//        tvname.setText(Name);
//        tvdesc.setText(Description);
//    }
}

