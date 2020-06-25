package com.example.gpsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("userinfo");
    public static String id = databaseReference.push().getKey();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newuser = findViewById(R.id.newuser);
        Button existinguser = findViewById(R.id.existinguser);
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNewUserActivity();
            }
        });
        existinguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToExistingUserActivity();
            }
        });
    }

    private void goToNewUserActivity() {
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }

    private void goToExistingUserActivity() {
        Intent intent = new Intent(this, ExistingUserActivity.class);
        startActivity(intent);
    }
}
