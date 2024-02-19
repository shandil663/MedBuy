package com.example.medbuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class itemdetails extends AppCompatActivity {
ImageView img;
    ArrayAdapter<String> adapterItems;

    Button btn;
    String imageurl;

    String[] items={"1","2","3","4","5","6","7","8","9","10"};
AutoCompleteTextView autoCompleteTextView;
TextView txt1,txt2,txt3,txt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdetails);

        btn=findViewById(R.id.addtocart);
        autoCompleteTextView=findViewById(R.id.auto_complete_txt);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item =adapterView.getItemAtPosition(i).toString();
            }
        });
        img=findViewById(R.id.productimage);
        txt4=findViewById(R.id.name);
        txt1=findViewById(R.id.price);
        txt2=findViewById(R.id.desc);
        txt3=findViewById(R.id.stock);
        imageurl=getIntent().getStringExtra("productimage");
        txt4.setText(getIntent().getStringExtra("productname"));
        txt1.setText(getIntent().getStringExtra("productprice"));
        txt2.setText(getIntent().getStringExtra("productdesc"));
        txt3.setText(getIntent().getStringExtra("stock"));
        Glide.with(getApplicationContext()).load(getIntent().getStringExtra("productimage")).into(img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x,y,tt;
                x=Integer.parseInt(txt1.getText().toString());
                y=Integer.parseInt(autoCompleteTextView.getText().toString());
                tt=x*y;
                String total;
                total=String.valueOf(tt);
                // Get the current user's UID
//                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

// Create a reference to the collection
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                DocumentReference documentReference=db.collection("uid").document(txt4.getText().toString().trim()); // "uid" is the current user's UID

// Create a Map object to store the data
                Map<String, Object> data = new HashMap<>();
                data.put("Medname", txt4.getText().toString()); // Replace with actual name
                data.put("Medprice", txt1.getText().toString()); // Replace with actual price
                data.put("Medqt", autoCompleteTextView.getText().toString()); // Replace with actual quantity
                data.put("Medimg", imageurl);
                data.put("totalprice",total);// Replace with actual image URL

// Add the data to the collection
                documentReference.set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(itemdetails.this, "Added to cart", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(itemdetails.this, "Some error occured", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}