package com.example.ydc.androidlearning.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.ydc.androidlearning.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SimpleAdapterLearn extends AppCompatActivity {

    private ListView lv_simple_adapter_learn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_learn);
        lv_simple_adapter_learn = (ListView) this.findViewById(R.id.lv_simple_adapter_learn);

        List<Map<String, Object>> data = new ArrayList<>();

        Map<String, Object> subData = new HashMap<>();
        subData.put("img", R.drawable.f1);
        subData.put("name", "goods1");
        subData.put("price", "25元");
        data.add(subData);

        subData = new HashMap<>();
        subData.put("img", R.drawable.f2);
        subData.put("name", "goods2");
        subData.put("price", "12元");
        data.add(subData);

        subData = new HashMap<>();
        subData.put("img", R.drawable.f3);
        subData.put("name", "goods3");
        subData.put("price", "10元");
        data.add(subData);

        subData = new HashMap<>();
        subData.put("img", R.drawable.f4);
        subData.put("name", "goods4");
        subData.put("price", "12元");
        data.add(subData);

        subData = new HashMap<>();
        subData.put("img", R.drawable.f5);
        subData.put("name", "goods5");
        subData.put("price", "52元");
        data.add(subData);

        subData = new HashMap<>();
        subData.put("img", R.drawable.f6);
        subData.put("name", "goods6");
        subData.put("price", "10元");
        data.add(subData);

        subData = new HashMap<>();
        subData.put("img", R.drawable.f7);
        subData.put("name", "goods7");
        subData.put("price", "17元");
        data.add(subData);

        subData = new HashMap<>();
        subData.put("img", R.drawable.f8);
        subData.put("name", "goods8");
        subData.put("price", "18元");
        data.add(subData);

        subData = new HashMap<>();
        subData.put("img", R.drawable.f9);
        subData.put("name", "goods9");
        subData.put("price", "19元");
        data.add(subData);

        subData = new HashMap<>();
        subData.put("img", R.drawable.f10);
        subData.put("name", "goods10");
        subData.put("price", "30元");
        data.add(subData);

        String[] from = new String[]{"img", "name", "price"};
        int[] to = new int[]{R.id.iv_simple_adapter_item_img, R.id.tv_simple_adapter_name, R.id.tv_simple_adapter_price};

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_simple_adapter_item, from, to);

        lv_simple_adapter_learn.setAdapter(adapter);

    }
}
