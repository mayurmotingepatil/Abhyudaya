package com.mayurmotinge.abhyudaya;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.prefs.AbstractPreferences;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName, tvMobNo, tvEmail, tvAadhar, tvPrevAddress, tvUsername;
    TextView tvLogout, profilePhoto;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvName = findViewById(R.id.tvName);

        tvLogout = findViewById(R.id.tvLogout);

        preferences = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this);
        editor = preferences.edit();


        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(ProfileActivity.this);
                ad.setTitle("Logout");
                ad.setMessage("Are you sure you want to logout?");
                ad.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                ad.setNegativeButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                        editor.putBoolean("isLoggedIn", false).commit();
                        startActivity(i);
                        finish();
                    }
                }).create().show();
            }
        });


    }
}