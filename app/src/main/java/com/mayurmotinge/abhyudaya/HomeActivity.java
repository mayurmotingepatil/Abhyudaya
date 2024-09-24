package com.mayurmotinge.abhyudaya;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bnvHome;
    ImageView ivProfile, ivSearchIcon;
    TextView tvPageMessage;

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

        ivSearchIcon = findViewById(R.id.ivSearchIcon);
        ivProfile = findViewById(R.id.ivProfile);

        bnvHome = findViewById(R.id.bottom_navigation);
        bnvHome.setOnNavigationItemSelectedListener(this);
        bnvHome.setSelectedItemId(R.id.home);

        tvPageMessage = findViewById(R.id.tvPageMessage);

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

    }

    HomeFragment homeFragment = new HomeFragment();
    PeopleFragment peopleFragment = new PeopleFragment();
    MaintenanceFragment maintenanceFragment = new MaintenanceFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.home){
            getSupportFragmentManager().beginTransaction().replace(R.id.flOnHome,
                    homeFragment).commit();

            return true;
        } else if (item.getItemId() == R.id.people){
            getSupportFragmentManager().beginTransaction().replace(R.id.flOnHome,
                    peopleFragment).commit();

            return true;
        } else if (item.getItemId() == R.id.maintenance){
            getSupportFragmentManager().beginTransaction().replace(R.id.flOnHome,
                    maintenanceFragment).commit();

            return true;
        }
        return true;
    }
}