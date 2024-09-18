package com.mayurmotinge.abhyudaya;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.mayurmotinge.abhyudaya.supportclasses.NetworkChangeListener;
import com.mayurmotinge.abhyudaya.supportclasses.Urls;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    CheckBox cbShowPassword;
    Button btnLogin;
    TextView tvNewUser;

    NetworkChangeListener ncl;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        editor = preferences.edit();

        if (preferences.getBoolean("isLoggedIn",false)){
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        cbShowPassword = findViewById(R.id.cbShowPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvNewUser = findViewById(R.id.tvNewUser);

        ncl = new NetworkChangeListener();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                boolean valid = true;

                //Username validation
                if (username.isEmpty()){
                    etUsername.setError("Username is Required.");
                    valid = false;
                } else if (username.length() < 8){
                    etUsername.setError("Username must be 8 characters long");
                    valid = false;
                } else if (username.matches(".*[A-Z].*")) {
                    etUsername.setError("Username must not contain Uppercase...");
                    valid = false;
                } else if (username.matches(".*[!@#$%^&*].*")) {
                    etUsername.setError("Username must not contain Special Symbol");
                    valid = false;
                }

                //Password validation
                if (password.isEmpty()){
                    etPassword.setError("Password is Required.");
                    valid = false;
                } else if (password.length() < 8){
                    etPassword.setError("Password must be 8 characters long");
                    valid = false;
                } else if (!password.matches(".*[A-Z].*")) {
                    etPassword.setError("Password must contain at least 1 Uppercase...");
                    valid = false;
                } else if (!password.matches(".*[a-z].*")) {
                    etPassword.setError("Password must contain at least 1 Lowercase...");
                    valid = false;
                } else if (!password.matches(".*[0-9].*")) {
                    etPassword.setError("Password must contain at least 1 Number");
                    valid = false;
                } else if (!password.matches(".*[!@#$%^&*].*")) {
                    etPassword.setError("Password must contain at least 1 Special Symbol");
                    valid = false;
                }

                //Login successful
                if (valid){
                    Toast.makeText(LoginActivity.this, "Logged in Successfully",
                            Toast.LENGTH_SHORT).show();
                    Intent intnt = new Intent(LoginActivity.this, HomeActivity.class);
                    editor.putString("loggedInUsername", username).commit();
                    editor.putBoolean("isLoggedIn", true).commit();

                    login(username, password);

                    startActivity(intnt);
                    finish();
                }
            }
        });



        tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
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

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(ncl, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(ncl);
    }

    private void login(String username, String password){
        AsyncHttpClient client = new AsyncHttpClient();

    }



}