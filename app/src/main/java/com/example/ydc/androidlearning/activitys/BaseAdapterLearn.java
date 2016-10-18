package com.example.ydc.androidlearning.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ydc.androidlearning.R;
import com.example.ydc.androidlearning.bean.Goods;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapterLearn extends AppCompatActivity {

    private ListView lv_base_adapter_learn;
    private List<Goods> goodses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_learn);
        lv_base_adapter_learn = (ListView) this.findViewById(R.id.lv_base_adapter_learn);

        goodses = new ArrayList<>();
        goodses.add(new Goods(R.drawable.f1, "goods1", "11元"));
        goodses.add(new Goods(R.drawable.f2, "goods2", "12元"));
        goodses.add(new Goods(R.drawable.f3, "goods3", "13元"));
        goodses.add(new Goods(R.drawable.f4, "goods4", "14元"));
        goodses.add(new Goods(R.drawable.f5, "goods5", "15元"));
        goodses.add(new Goods(R.drawable.f6, "goods6", "16元"));
        goodses.add(new Goods(R.drawable.f7, "goods7", "17元"));
        goodses.add(new Goods(R.drawable.f8, "goods8", "18元"));
        goodses.add(new Goods(R.drawable.f9, "goods9", "19元"));
        goodses.add(new Goods(R.drawable.f10, "goods20", "20元"));

        MyBaseAdapter adapter = new MyBaseAdapter();

        lv_base_adapter_learn.setAdapter(adapter);
    }

    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return goodses.size();
        }

        @Override
        public Object getItem(int position) {
            return goodses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = View.inflate(BaseAdapterLearn.this, R.layout.list_simple_adapter_item, null);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_simple_adapter_item_img);
            TextView textView1 = (TextView) convertView.findViewById(R.id.tv_simple_adapter_name);
            TextView textView2 = (TextView) convertView.findViewById(R.id.tv_simple_adapter_price);

            Goods goods = goodses.get(position);

            imageView.setImageResource(goods.getImg());
            textView1.setText(goods.getName());
            textView2.setText(goods.getPrice());

            return convertView;
        }
    }

}
