package com.mayurmotinge.abhyudaya;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {

    CheckBox cbShowPassword;
    EditText etName, etMobNo, etMail, etAadhar, etUsername, etPassword;
    Button btnCont;
    
    String strName, strMobNo, strMail, strAadhar, strUsername, strPassword; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cbShowPassword = findViewById(R.id.cbShowPassword);
        etName = findViewById(R.id.etName);
        etMobNo = findViewById(R.id.etMobNo);
        etMail = findViewById(R.id.etEmail);
        etAadhar = findViewById(R.id.etAadhar);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnCont = findViewById(R.id.btnCont);

        strName = etName.getText().toString(); 
        strMobNo = etMobNo.getText().toString(); 
        strMail = etMail.getText().toString();
        strAadhar = etAadhar.getText().toString();
        strUsername = etUsername.getText().toString(); 
        strPassword = etPassword.getText().toString();

        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean valid = true;

                //Name
                if (strName.isEmpty()){
                    etName.setError("Name is Required");
                    valid = false;
                } else if (!strName.matches(".*[A-Z].+")) {
                    etName.setError("At least 1 Uppercase");
                    valid = false;
                } else if (strName.matches(".*[!@#$%^&*].*")) {
                    etName.setError("Must not have Special Symbol");
                    valid = false;
                } else if (strName.matches(".*[0-9].*")) {
                    etName.setError("Must not have Numbers");
                    valid = false;
                }

                //Mobile no.
                if (strMobNo.length()<10){
                    etMobNo.setError("Must be 10 digit long");
                    valid = false;
                }

                //Username validation
                if (strUsername.isEmpty()){
                    etUsername.setError("Username is Required.");
                    valid = false;
                } else if (strUsername.length() < 8){
                    etUsername.setError("Username must be 8 characters long");
                    valid = false;
                } else if (strUsername.matches(".*[A-Z].*")) {
                    etUsername.setError("Username must not contain Uppercase...");
                    valid = false;
                } else if (strUsername.matches(".*[!@#$%^&*].*")) {
                    etUsername.setError("Username must not contain Special Symbol");
                    valid = false;
                }

                //Password validation
                if (strPassword.isEmpty()){
                    etPassword.setError("Password is Required.");
                    valid = false;
                } else if (strPassword.length() < 8){
                    etPassword.setError("Password must be 8 characters long");
                    valid = false;
                } else if (!strPassword.matches(".*[A-Z].*")) {
                    etPassword.setError("Password must contain at least 1 Uppercase...");
                    valid = false;
                } else if (!strPassword.matches(".*[a-z].*")) {
                    etPassword.setError("Password must contain at least 1 Lowercase...");
                    valid = false;
                } else if (!strPassword.matches(".*[0-9].*")) {
                    etPassword.setError("Password must contain at least 1 Number");
                    valid = false;
                } else if (!strPassword.matches(".*[!@#$%^&*].*")) {
                    etPassword.setError("Password must contain at least 1 Special Symbol");
                    valid = false;
                }

                if (valid){
                    Toast.makeText(RegistrationActivity.this, "Logged in Successfully",
                            Toast.LENGTH_SHORT).show();
                    Intent intnt = new Intent(RegistrationActivity.this, FillSocietyInfoActivity.class);
                    startActivity(intnt);
                    finish();



                }

            }
        });

        cbShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}