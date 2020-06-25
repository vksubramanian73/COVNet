package com.example.gpsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExistingUserStatusActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    int radioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_status);
        radioGroup = findViewById(R.id.radioGroup);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioId = radioGroup.getCheckedRadioButtonId();
                if(radioId == -1)
                    Toast.makeText(v.getContext(), "Enter a status.", Toast.LENGTH_LONG).show();
                else {
                    addToDatabase();
                    goToMapActivity();
                }
            }
        });
    }

    private void addToDatabase() {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = df.format(c);
        RadioButton radioButton = findViewById(radioId);
        String status = radioButton.getText().toString().trim();
        UserInfo userinfo = new UserInfo(MainActivity.id, ExistingUserActivity.user, status, formattedDate);
        MainActivity.id = ExistingUserActivity.user;
        MainActivity.databaseReference.child(ExistingUserActivity.user).setValue(userinfo);
        Toast.makeText(this, "Info added.", Toast.LENGTH_SHORT).show();
    }

    private void goToMapActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
