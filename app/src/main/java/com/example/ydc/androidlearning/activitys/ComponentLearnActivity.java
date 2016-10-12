package com.example.ydc.androidlearning.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ydc.androidlearning.R;
import com.example.ydc.androidlearning.utils.StringUtils;

public class ComponentLearnActivity extends AppCompatActivity {

    private EditText et_activity_comp_learn_phone;
    private EditText et_activity_comp_learn_pwd;
    private String phoneNumber;
    private CheckBox cb_interest_foot;
    private CheckBox cb_interest_basket;
    private CheckBox cb_interest_pingpang;
    private RadioGroup rg_component_learn_sex;
    private TextView tv_activity_component_sex;
    private Button btn_main_component_learn_contextMenu;
    private String pwd;
    private boolean displyFlage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_learn);
        et_activity_comp_learn_phone = (EditText) this.findViewById(R.id.et_activity_comp_learn_phone);
        et_activity_comp_learn_pwd = (EditText) this.findViewById(R.id.et_activity_comp_learn_pwd);
        cb_interest_foot = (CheckBox) this.findViewById(R.id.cb_interest_foot);
        cb_interest_basket = (CheckBox) this.findViewById(R.id.cb_interest_basket);
        cb_interest_pingpang = (CheckBox) this.findViewById(R.id.cb_interest_pingpang);
        rg_component_learn_sex = (RadioGroup) this.findViewById(R.id.rg_component_learn_sex);
        tv_activity_component_sex = (TextView) this.findViewById(R.id.tv_activity_component_sex);
        btn_main_component_learn_contextMenu = (Button) this.findViewById(R.id.btn_main_component_learn_contextMenu);

        rg_component_learn_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) ComponentLearnActivity.this.findViewById(checkedId);
                tv_activity_component_sex.setText("你选择的性别是：" + radioButton.getText().toString());
            }
        });

        registerForContextMenu(btn_main_component_learn_contextMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 1, 0, "更新");
        menu.add(0, 2, 0, "删除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case 1:
                Toast.makeText(this, "更新了！", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "删除了！", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
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

    /**
     * 选择兴趣爱好
     *
     * @param view
     */
    public void confirmInterest(View view) {
        StringBuffer interestBuff = new StringBuffer("");
        if (cb_interest_foot.isChecked()) {
            interestBuff.append(cb_interest_foot.getText().toString() + "，");
        }
        if (cb_interest_basket.isChecked()) {
            interestBuff.append(cb_interest_basket.getText().toString() + "，");
        }
        if (cb_interest_pingpang.isChecked()) {
            interestBuff.append(cb_interest_pingpang.getText().toString() + "，");
        }
        String interest = interestBuff.toString();
        interest = interest.substring(0, interest.length() - 1);
        Toast.makeText(this, interest.toString(), Toast.LENGTH_SHORT).show();
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
