package com.example.application1_login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    MaterialButton LoginID;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(MainActivity.this, LoginID.class);
            startActivity(intent);
            finish();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginmain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView registerid = findViewById(R.id.RegisterID);
        registerid.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterID.class);
            startActivity(intent);
        });

        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        LoginID = findViewById(R.id.LoginID);
        progressBar = findViewById(R.id.ProgressBar);

        LoginID.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            String un, pass;
            un = String.valueOf(username.getText());
            pass = String.valueOf(password.getText());

            if (TextUtils.isEmpty(un)) {
                Toast.makeText(MainActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
            }
            if (TextUtils.isEmpty(pass)) {
                Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
            }

            mAuth.signInWithEmailAndPassword(un, pass)
                    .addOnCompleteListener(task -> {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

    }
}
