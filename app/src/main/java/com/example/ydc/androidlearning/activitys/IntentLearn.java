package com.example.ydc.androidlearning.activitys;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ydc.androidlearning.R;

public class IntentLearn extends AppCompatActivity {

    private Button btn_intent_distinct;
    private Button btn_intent_hide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_learn);

        btn_intent_distinct = (Button) this.findViewById(R.id.btn_intent_distinct);
        btn_intent_hide = (Button) this.findViewById(R.id.btn_intent_hide);

        btn_intent_distinct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentLearn.this, IntentLearnDistint.class);
                intent.putExtra("info", "这是上个页面利用intent对象传递下来的信息");
                startActivity(intent);
            }
        });

        btn_intent_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + 111);
                intent.setData(data);
                startActivity(intent);
            }
        });
    }
}
