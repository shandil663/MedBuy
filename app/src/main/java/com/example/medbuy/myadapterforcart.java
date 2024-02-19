package com.example.medbuy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class myadapterforcart extends  RecyclerView.Adapter<myadapterforcart.myviewholder>{

    ArrayList<Modalforcart> datalist;


    public myadapterforcart(ArrayList<Modalforcart> datalist) {
        this.datalist = datalist;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.datafromdatabaseforcart,parent,false);
     return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt1.setText(datalist.get(position).getMedname());
        holder.txt2.setText(datalist.get(position).getTotalprice());
        holder.txt3.setText(datalist.get(position).getMedqt());
        String imageurl=datalist.get(position).getMedimg();
        Glide.with(holder.productimg.getContext()).load(datalist.get(position).getMedimg()).circleCrop().into(holder.productimg);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {

      TextView txt1,txt2,txt3,txt4,txt5;
      ImageView productimg;
      public myviewholder(@NonNull View itemView) {
          super(itemView);
          txt1=itemView.findViewById(R.id.itemnamehere);
          txt2=itemView.findViewById(R.id.itempricehere);
          txt3=itemView.findViewById(R.id.itemqthere);
          productimg=itemView.findViewById(R.id.productimg);
      }
  }
}
