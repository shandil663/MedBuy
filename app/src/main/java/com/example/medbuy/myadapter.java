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

public class myadapter extends  RecyclerView.Adapter<myadapter.myviewholder>{

    ArrayList<Modal> datalist;


    public myadapter(ArrayList<Modal> datalist) {
        this.datalist = datalist;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.datafromdatabase,parent,false);
     return  new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt1.setText(datalist.get(position).getMedname());
        holder.txt2.setText(datalist.get(position).getMedPrice());
        String imageurl=datalist.get(position).getMedimg();
        Glide.with(holder.productimg.getContext()).load(datalist.get(position).getMedimg()).into(holder.productimg);
        holder.productimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.txt1.getContext(), itemdetails.class);
                intent.putExtra("productprice",datalist.get(position).getMedPrice());
                intent.putExtra("productname",datalist.get(position).getMedname());
                intent.putExtra("productdesc",datalist.get(position).getMeddesc());
                intent.putExtra("productimage",datalist.get(position).getMedimg());
               intent.putExtra("stock",datalist.get(position).getMedstock());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               holder.txt1.getContext().startActivity(intent);


            }
        });

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
          productimg=itemView.findViewById(R.id.productimg);
      }
  }
}
