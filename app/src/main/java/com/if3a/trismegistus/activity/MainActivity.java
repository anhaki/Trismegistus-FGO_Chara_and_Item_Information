package com.if3a.trismegistus.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.if3a.trismegistus.fragment.CEFragment;
import com.if3a.trismegistus.fragment.MaterialFragment;
import com.if3a.trismegistus.R;
import com.if3a.trismegistus.fragment.ServantsFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnvTrismegistus;
    private ActionBar judulBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        judulBar = getSupportActionBar();
        judulBar.hide();

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bnv_trismegistus);
        bottomNavigationView.setSelectedItemId(R.id.menu_servants);


        bukaFragment(new ServantsFragment());
        judulBar.setTitle("Servants");

        bnvTrismegistus = findViewById(R.id.bnv_trismegistus);

        bnvTrismegistus.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment FR;
                switch (menuItem.getItemId()){
                    case R.id.menu_servants:
                        bukaFragment(new ServantsFragment());
                        return true;
                    case R.id.menu_ce:
                        bukaFragment(new CEFragment());
                        return true;
                    case R.id.menu_material:
                        bukaFragment(new MaterialFragment());
                        return true;
                }
                return false;
            }
        });
    }

    private void bukaFragment(Fragment FR){
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.fl_container, FR);
        FT.commit();
    }

}