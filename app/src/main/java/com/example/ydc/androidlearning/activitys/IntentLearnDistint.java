package com.example.ydc.androidlearning.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ydc.androidlearning.R;

/**
 * Created by ydc on 16-10-11.
 */
public class IntentLearnDistint extends AppCompatActivity {

    private TextView tv_intetn_learn_distinct;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_intente_learn_distinct);

        tv_intetn_learn_distinct = (TextView) this.findViewById(R.id.tv_intetn_learn_distinct);

        Intent intent = this.getIntent();

        String info = intent.getStringExtra("info");

        tv_intetn_learn_distinct.setText(info);
    }


}
