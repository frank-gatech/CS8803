package com.example.nav_test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ReplyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        Intent intent = getIntent();
        String reply = intent.getStringExtra("reply");
        ArrayList<String> arr = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(reply);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String s = jsonObject.getString("comment");
                s = s + "\nreplier: " + jsonObject.getString("id");
                arr.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        ListView listView = findViewById(R.id.replyListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(arrayAdapter);
    }
}
