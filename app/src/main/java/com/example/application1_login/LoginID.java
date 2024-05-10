package com.example.application1_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginID extends AppCompatActivity {

    CardView Home, Settings, EmergencyContact, Maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_id);

        // Adjust padding to account for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.homemain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Home = findViewById(R.id.HomeActivity);
        Settings = findViewById(R.id.SettingsActivity);
        EmergencyContact = findViewById(R.id.EmergencyContactActivity);
        Maps = findViewById(R.id.MapsActivity);



        Home.setOnClickListener(v -> {
            Intent intent = new Intent(LoginID.this, HomeActivity.class);
            startActivity(intent);
        });

        Settings.setOnClickListener(v -> {
            Intent intent = new Intent(LoginID.this, SettingsActivity.class);
            startActivity(intent);
        });

        EmergencyContact.setOnClickListener(v -> {
            Intent intent = new Intent(LoginID.this, EmergencyContactActivity.class);
            startActivity(intent);
        });


        Maps.setOnClickListener(v -> {
            Intent intent = new Intent(LoginID.this, MapsActivity.class);
            startActivity(intent);
        });

    }
}