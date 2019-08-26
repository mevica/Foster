package com.example.forster;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private List<Child> mData=new ArrayList<>();
    private RecyclerviewActivity mContext;

    public RecyclerViewAdapter(List<Child> mData, RecyclerviewActivity mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.childrecycler,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).bindData(position);
        ((MyViewHolder) holder).Name.setText(mData.get(position).getName());
        ((MyViewHolder) holder).Description.setText(mData.get(position).getDescription());
        byte[] decodedString=  Base64.decode(mData.get(position).getImage(),Base64.DEFAULT);
        Bitmap decodedByte= BitmapFactory.decodeByteArray(decodedString,0,decodedString.length);
        ((MyViewHolder) holder).Image.setImageBitmap(decodedByte);

    }

    @Override
    public int getItemCount() { return mData.size(); }


    private class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView Image;
        TextView Name ,Description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Image=itemView.findViewById(R.id.childimg);
            Name=itemView.findViewById(R.id.tvname);
            Description=itemView.findViewById(R.id.tvdesc);
        }


        void bindData(int position){
        }
    }
}
