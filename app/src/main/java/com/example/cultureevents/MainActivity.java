package com.example.cultureevents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

        private BottomNavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(navigationListener);

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