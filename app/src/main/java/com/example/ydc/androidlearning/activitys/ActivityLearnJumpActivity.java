package com.example.ydc.androidlearning.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ydc.androidlearning.R;
import com.example.ydc.androidlearning.utils.StringUtils;

public class ActivityLearnJumpActivity extends AppCompatActivity {

    private EditText et_activity_learn_jump_info;
    private String etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_learn_jump);

        et_activity_learn_jump_info = (EditText) this.findViewById(R.id.et_activity_learn_jump_info);
        Intent intent = this.getIntent();
        String info = intent.getStringExtra("info");
        et_activity_learn_jump_info.setText(info);
    }

    /**
     * 普通返回
     *
     * @param view
     */
    public void generalReturn(View view) {
        this.finish();
    }

    /**
     * 带数据的返回
     *
     * @param view
     */
    public void callbackReturn(View view) {
        checkInput();
        Intent intent = this.getIntent();
        intent.putExtra("info", etContent);
        this.setResult(002, intent);
        this.finish();
    }

    private void checkInput() {
        etContent = et_activity_learn_jump_info.getText().toString();
        if (StringUtils.isEmpty(etContent)) {
            return;
        }
    }

}
