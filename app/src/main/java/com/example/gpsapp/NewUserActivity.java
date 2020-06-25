package com.example.gpsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class NewUserActivity extends AppCompatActivity {

    EditText userId;
    public static String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        Button button = findViewById(R.id.button);
        userId = findViewById(R.id.username);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = userId.getText().toString().trim();
                if(user.equals(""))
                    Toast.makeText(v.getContext(), "Enter a username.", Toast.LENGTH_LONG).show();
                else {
                    MainActivity.databaseReference.child(user).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists())
                                Toast.makeText(getApplicationContext(), "Enter a different username.", Toast.LENGTH_LONG).show();
                            else {
                                goToStatus();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }
    private void goToStatus() {
        Intent intent = new Intent(this, NewUserStatusActivity.class);
        startActivity(intent);
    }
}
