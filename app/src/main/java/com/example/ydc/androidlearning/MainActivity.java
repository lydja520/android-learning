package com.example.ydc.androidlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ydc.androidlearning.activitys.ActivityLearn;
import com.example.ydc.androidlearning.activitys.ComponentLearn2Activity;
import com.example.ydc.androidlearning.activitys.ComponentLearnActivity;
import com.example.ydc.androidlearning.activitys.IntentLearn;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    private Button btn_main_intent_learn;
    private Button btn_main_activity_learn;
    private Button btn_main_component_learn;
    private Button btn_main_component2_learn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_main_intent_learn = (Button) this.findViewById(R.id.btn_main_intent_learn);
        btn_main_activity_learn = (Button) this.findViewById(R.id.btn_main_activity_learn);
        btn_main_component_learn = (Button) this.findViewById(R.id.btn_main_component_learn);
        btn_main_component2_learn = (Button) this.findViewById(R.id.btn_main_component2_learn);

        btn_main_intent_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentLearn.class);
                startActivity(intent);
            }
        });

        btn_main_activity_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityLearn.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btn_main_component_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ComponentLearnActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btn_main_component2_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ComponentLearn2Activity.class);
                startActivity(intent);
            }
        });
    }
}
