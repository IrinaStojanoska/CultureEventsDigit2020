package com.example.cultureevents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

        private BottomNavigationView navigationView;

    int timeout = 4000; // make the activity visible for 4 seconds




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(navigationListener);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        },4000);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    int id = menuItem.getItemId();
                    if (id == R.id.home) {
                      //  selectedFragment = new HomeFragment();
                    }
                    if (id == R.id.profile) {
                      //  selectedFragment = new FavouritesFragment();
                    }
                    if (id == R.id.random) {

                      //  selectedFragment = new FastingPlansFragment();
                    }

                    return true;
                }

            };
}