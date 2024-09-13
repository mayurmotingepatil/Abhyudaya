package com.mayurmotinge.abhyudaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bnvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bnvHome = findViewById(R.id.bottom_navigation);
        bnvHome.setOnNavigationItemSelectedListener(this);
        bnvHome.setSelectedItemId(R.id.home);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.userProfile){
            Intent i = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(i);
        }
        return true;
    }

    HomeFragment homeFragment = new HomeFragment();
    PeopleFragment peopleFragment = new PeopleFragment();
    MaintenanceFragment maintenanceFragment = new MaintenanceFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home){
            getSupportFragmentManager().beginTransaction().replace(R.id.flOnHome,
                    homeFragment).commit();
        } else if (item.getItemId() == R.id.people){
            getSupportFragmentManager().beginTransaction().replace(R.id.flOnHome,
                    peopleFragment).commit();
        } else if (item.getItemId() == R.id.maintenance){
            getSupportFragmentManager().beginTransaction().replace(R.id.flOnHome,
                    maintenanceFragment).commit();
        }
        return true;
    }
}