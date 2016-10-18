package com.example.ydc.androidlearning.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.BaseAdapter;


import com.example.ydc.androidlearning.R;


/**
 * Created by ydc on 16-10-17.
 */
public class ListViewLearn extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_list_view_learn);
    }

    public void arrayAdapterLearn(View view) {
        Intent intent = new Intent(this, ArrayAdapterLearn.class);
        startActivity(intent);
    }

    public void simpleAdapterLearn(View view) {
        Intent intent = new Intent(this, SimpleAdapterLearn.class);
        startActivity(intent);
    }

    public void baseAdapterLearn(View view) {
        Intent intent = new Intent(this, BaseAdapterLearn.class);
        startActivity(intent);
    }

}
