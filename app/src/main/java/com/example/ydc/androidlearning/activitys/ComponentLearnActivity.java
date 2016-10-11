package com.example.ydc.androidlearning.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ydc.androidlearning.R;
import com.example.ydc.androidlearning.utils.StringUtils;

public class ComponentLearnActivity extends AppCompatActivity {

    private EditText et_activity_comp_learn_phone;
    private EditText et_activity_comp_learn_pwd;
    private String phoneNumber;
    private String pwd;
    private boolean displyFlage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_learn);
        et_activity_comp_learn_phone = (EditText) this.findViewById(R.id.et_activity_comp_learn_phone);
        et_activity_comp_learn_pwd = (EditText) this.findViewById(R.id.et_activity_comp_learn_pwd);
    }


    /**
     * 点击提交按钮
     *
     * @param view
     */
    public void submitPhoneAndPwd(View view) {
        checkPhoneAndPwdInput();
        if (phoneNumber == null || pwd == null) {
            return;
        }
        Toast.makeText(this, "号码：" + phoneNumber + "\n" + "密码：" + pwd, Toast.LENGTH_SHORT).show();
    }

    /**
     * 播放按钮
     *
     * @param view
     */
    public void displyVideo(View view) {
        ImageView displyBtn = (ImageView) view;
        if (displyFlage) {
            displyBtn.setBackgroundResource(android.R.drawable.alert_dark_frame);
            displyBtn.setImageResource(android.R.drawable.ic_media_play);
            displyFlage = false;
        } else {
            displyBtn.setBackgroundResource(android.R.drawable.alert_light_frame);
            displyBtn.setImageResource(android.R.drawable.ic_media_pause);
            displyFlage = true;
        }
    }

    /**
     * 点击重置按钮
     *
     * @param view
     */
    public void resetPhoneAndPwd(View view) {
        et_activity_comp_learn_phone.setText(null);
        et_activity_comp_learn_pwd.setText(null);
    }

    /**
     * 星星点击
     *
     * @param view
     */
    public void clickStar(View view) {
        ImageView star = (ImageView) view;
        star.setImageResource(android.R.drawable.star_big_off);
    }

    private void checkPhoneAndPwdInput() {
        phoneNumber = et_activity_comp_learn_phone.getText().toString();
        pwd = et_activity_comp_learn_pwd.getText().toString();
        if (StringUtils.isEmpty(phoneNumber)) {
            Toast.makeText(this, "请输入电话号码", Toast.LENGTH_SHORT).show();
            et_activity_comp_learn_phone.setFocusable(true);
            return;
        }
        if (StringUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            et_activity_comp_learn_pwd.setFocusable(true);
            return;
        }
    }
}
