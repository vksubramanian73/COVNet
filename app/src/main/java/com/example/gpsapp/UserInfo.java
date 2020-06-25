package com.example.gpsapp;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class UserInfo {
     String userId;
     String user;
     String status;
     String date;

     public UserInfo() {

     }

    public UserInfo(String userId, String user, String status, String date) {
        this.userId = userId;
        this.user = user;
        this.status = status;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public String getUser() {
        return user;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }
}
