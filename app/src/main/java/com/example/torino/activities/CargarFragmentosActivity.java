package com.example.torino.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.torino.R;
import com.example.torino.fragments.FirstFragment;
import com.example.torino.fragments.BuscarUsuarioFragment;
import com.example.torino.fragments.ThirdFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CargarFragmentosActivity extends AppCompatActivity {
    FirstFragment firstFragment = new FirstFragment();
    BuscarUsuarioFragment secondFragment = new BuscarUsuarioFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_fragmentos);
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(firstFragment);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.firstFragement:
                    loadFragment(firstFragment);
                    return true;
                case R.id.secondFragement:
                    loadFragment(secondFragment);
                    return true;
                case R.id.thirdFragement:
                    loadFragment(thirdFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}
