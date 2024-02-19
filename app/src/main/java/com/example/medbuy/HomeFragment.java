package com.example.medbuy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
ImageView img;
TextView txt1,txt2;
    RecyclerView firstview;
    ArrayList<Modal> listdata;
    FirebaseFirestore fire;

    Context context;

    myadapter myadapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        img=view.findViewById(R.id.image1);
//        txt1=view.findViewById(R.id.medname1);
//        txt2=view.findViewById(R.id.price);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               Intent intent=new Intent(getContext(), itemdetails.class);
//               intent.putExtra("name",txt1.getText().toString());
//                intent.putExtra("price",txt2.getText().toString());
//                startActivity(intent);
//            }
//        });
        firstview=view.findViewById(R.id.firstview);
        firstview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        listdata =new ArrayList<>();
        myadapter=new myadapter(listdata);
        firstview.setAdapter(myadapter)  ;
        fire=FirebaseFirestore.getInstance();
        fire.collection("FirstAid").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> List = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d: List){
                            Modal obj=d.toObject(Modal.class);
                            listdata.add(obj);

                        }
                        myadapter.notifyDataSetChanged();


                    }
                });



    }
}