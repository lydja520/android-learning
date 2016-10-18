package com.example.ydc.androidlearning.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ydc.androidlearning.R;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterLearn extends AppCompatActivity {

    private ListView lv_array_adapter_learn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_learn);
        lv_array_adapter_learn = (ListView) this.findViewById(R.id.lv_array_adapter_learn);

        List<String> data = new ArrayList<>();
        data.add("条目一");
        data.add("条目二");
        data.add("条目三");
        data.add("条目四");
        data.add("条目五");
        data.add("条目六");
        data.add("条目七");
        data.add("条目八");
        data.add("条目九");
        data.add("条目十");
        data.add("条目十一");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_array_item, data);
        lv_array_adapter_learn.setAdapter(adapter);
    }
}
