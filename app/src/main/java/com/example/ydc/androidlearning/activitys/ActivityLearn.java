package com.example.ydc.androidlearning.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ydc.androidlearning.R;
import com.example.ydc.androidlearning.utils.StringUtils;

public class ActivityLearn extends AppCompatActivity {

    private EditText et_activity_learn_info;
    private String etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_learn);

        et_activity_learn_info = (EditText) this.findViewById(R.id.et_activity_learn_info);

    }

    /**
     * 普通跳转
     *
     * @param view
     */
    public void generalJump(View view) {
        this.checkInput();
        Intent intent = new Intent(ActivityLearn.this, ActivityLearnJumpActivity.class);
        intent.putExtra("info", etContent);
        startActivity(intent);
    }

    /**
     * 带回调的跳转
     *
     * @param view
     */
    public void callbackJump(View view) {
        this.checkInput();
        Intent intent = new Intent(ActivityLearn.this, ActivityLearnJumpActivity.class);
        intent.putExtra("info", etContent);
        startActivityForResult(intent, 001);
    }

    private void checkInput() {
        etContent = et_activity_learn_info.getText().toString();
        if (StringUtils.isEmpty(etContent)) {
            Toast.makeText(ActivityLearn.this, "输入的信息不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    /**
     * 带数据返回的回调方法
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 001 && resultCode == 002) {
            String info = data.getStringExtra("info");
            et_activity_learn_info.setText(info);
        }
    }
}
