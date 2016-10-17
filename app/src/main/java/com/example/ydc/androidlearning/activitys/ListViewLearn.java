package com.example.ydc.androidlearning.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ydc.androidlearning.R;


/**
 * Created by ydc on 16-10-17.
 */
public class ListViewLearn extends AppCompatActivity {

    private ListView lv_list_view_learn;
    private ListView lv_list_view_learn2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_list_view_learn);
        lv_list_view_learn = (ListView) this.findViewById(R.id.lv_list_view_learn);
        lv_list_view_learn2 = (ListView) this.findViewById(R.id.lv_list_view_learn2);
        String[] data = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "p", "Q"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_array_item, data);

        lv_list_view_learn2.setAdapter(arrayAdapter);
    }


}
