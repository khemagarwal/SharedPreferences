package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);
/*
        ArrayList<String>friends=new ArrayList<String>();
        friends.add("khem");
        friends.add("khedu");
        friends.add("kalyan");
        friends.add("lobo");

        try {

            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();
            Log.i("friends",ObjectSerializer.serialize(friends));

        } catch (Exception e) {
            e.printStackTrace();
        }
*/
ArrayList<String>newFriends=new ArrayList<String>();
        try {
            newFriends=(ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("New friends",newFriends.toString());


        sharedPreferences.edit().putString("name","khem").apply();

        String username=sharedPreferences.getString("name","");

        Log.i("username",username);
    }
}
