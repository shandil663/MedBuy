package com.example.medbuy;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class SellFragment extends Fragment {

    RecyclerView firstview;
    ArrayList<Modalforcart> listdata;
    FirebaseFirestore fire;

    Context context;

    myadapterforcart myadapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sell, container, false);
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
        firstview=view.findViewById(R.id.cartview);
        firstview.setLayoutManager(new LinearLayoutManager(getContext()));
        listdata =new ArrayList<>();
        myadapter=new myadapterforcart(listdata);
        firstview.setAdapter(myadapter)  ;
        fire=FirebaseFirestore.getInstance();
        fire.collection("uid").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> List = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d: List){
                            Modalforcart obj=d.toObject(Modalforcart.class);
                            listdata.add(obj);

                        }
                        myadapter.notifyDataSetChanged();


                    }
                });



    }
}