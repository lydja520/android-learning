package com.example.ydc.androidlearning.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ydc.androidlearning.R;

public class ComponentLearn2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_learn2);
    }

    public void showLinerLayout(View view) {

    }

    public void showRelativeLayout(View view) {

    }

    public void showListView(View view) {
        Intent intent = new Intent(this, ListViewLearn.class);
        startActivity(intent);
    }
}
