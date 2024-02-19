package com.example.medbuy;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.medbuy.databinding.ActivityMainBinding;
import com.example.medbuy.databinding.ActivityFragmentContainerBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.color.DynamicColors;


public class FragmentContainer extends AppCompatActivity {

    ActivityFragmentContainerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFragmentContainerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DynamicColors.applyToActivitiesIfAvailable(this.getApplication());
        binding.bottomview.setBackground(null);
        replaceFragment(new HomeFragment());
        binding.bottomview.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.chat) {
                replaceFragment(new ChatFragment());
            } else if (itemId == R.id.plus) {
                replaceFragment(new SellFragment());
            } else if (itemId == R.id.acct) {
                replaceFragment(new ProfileFragment());
            }
            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();
    }


}