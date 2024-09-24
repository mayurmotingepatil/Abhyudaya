package com.mayurmotinge.abhyudaya;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditUserInfoActivity extends AppCompatActivity {

    EditText etName, etMob, etMail, etAadharNo, etHouseNo, etPrevAddress, etUsername, etPassword;
    CheckBox cbShowPassword;
    RadioGroup rgUserRole;
    AppCompatButton btnCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_user_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.etName);
        etMob = findViewById(R.id.etMobNo);
        etMail = findViewById(R.id.etEmail);
        etAadharNo = findViewById(R.id.etAadhar);
        etHouseNo = findViewById(R.id.etHouseNo);
        etPrevAddress = findViewById(R.id.etPrevAddress);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        cbShowPassword = findViewById(R.id.cbShowPassword);
        rgUserRole = findViewById(R.id.rgUserRole);
        btnCont = findViewById(R.id.btnCont);



    }
}