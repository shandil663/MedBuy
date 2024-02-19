package com.example.medbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button btn;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.mainimg);
//        int []imageArray={R.drawable.img,R.drawable.img_1,R.drawable.img};
//
//
//        final Handler handler = new Handler();
//        Runnable runnable = new Runnable() {
//            int i=0;
//            public void run() {
//                img.setImageResource(imageArray[i]);
//                i++;
//                if(i>imageArray.length-1)
//                {
//                    i=0;
//                }
//                handler.postDelayed(this, 2000);  //for interval...
//            }
//        };
//        handler.postDelayed(runnable, 2000); //for initial delay..

        btn=findViewById(R.id.cont);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FragmentContainer.class));
                finish();
            }
        });
    }
}