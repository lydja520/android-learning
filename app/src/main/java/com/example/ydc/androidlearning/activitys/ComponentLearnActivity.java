package com.example.ydc.androidlearning.activitys;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ydc.androidlearning.R;
import com.example.ydc.androidlearning.adapter.OnSeekBarChangeListenerAdapter;
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
    private ProgressBar pb_loading;
    private ProgressBar pb_horizontal_loading;
    private SeekBar sb_change_value;
    private Button btn_general_dialog;
    private Button btn_single_select_dialog;
    private Button btn_progress_bar_dialog;
    private Button btn_progress_bar1_dialog;
    private Button btn_year_select_dialog;
    private Button btn_time_select_dialog;
    private Button btn_custom_layout_dialog;

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
        pb_loading = (ProgressBar) this.findViewById(R.id.pb_loading);
        pb_horizontal_loading = (ProgressBar) this.findViewById(R.id.pb_horizontal_loading);
        sb_change_value = (SeekBar) this.findViewById(R.id.sb_change_value);
        btn_general_dialog = (Button) this.findViewById(R.id.btn_general_dialog);
        btn_single_select_dialog = (Button) this.findViewById(R.id.btn_single_select_dialog);
        btn_progress_bar_dialog = (Button) this.findViewById(R.id.btn_progress_bar_dialog);
        btn_progress_bar1_dialog = (Button) this.findViewById(R.id.btn_progress_bar1_dialog);
        btn_year_select_dialog = (Button) this.findViewById(R.id.btn_single_select_dialog);
        btn_time_select_dialog = (Button) this.findViewById(R.id.btn_time_select_dialog);
        btn_custom_layout_dialog = (Button) this.findViewById(R.id.btn_custom_layout_dialog);

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ComponentLearnActivity.this, "测试===============", Toast.LENGTH_LONG).show();
            }
        });

        /**
         *为CheckBox设置监听器
         */
        cb_interest_foot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox checkBox = (CheckBox) buttonView;
                if (isChecked) {
                    checkBox.setTextColor(Color.RED);
                } else {
                    checkBox.setTextColor(Color.BLACK);
                }
            }
        });

        cb_interest_basket.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setTextColor(Color.RED);
                } else {
                    buttonView.setTextColor(Color.BLACK);
                }
            }
        });

        cb_interest_pingpang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setTextColor(Color.RED);
                } else {
                    buttonView.setTextColor(Color.BLACK);
                }
            }
        });

        /**
         *为seekbar添加监听
         */

        sb_change_value.setOnSeekBarChangeListener(new OnSeekBarChangeListenerAdapter() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pb_horizontal_loading.setProgress(progress);
                if (progress == seekBar.getMax()) {
                    pb_loading.setVisibility(View.GONE);
                } else if (progress == 0) {
                    pb_loading.setVisibility(View.INVISIBLE);
                } else {
                    pb_loading.setVisibility(View.VISIBLE);
                }
            }
        });

        /**
         * 为RadioGroup设置监听器
         */
        rg_component_learn_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(checkedId);
                tv_activity_component_sex.setText("你选择的性别是：" + radioButton.getText().toString());
            }
        });

        /**
         *为按钮注册上下文菜单（长按后触发）
         *
         * 两种方式
         */
//       registerForContextMenu(btn_main_component_learn_contextMenu);
        btn_main_component_learn_contextMenu.setOnCreateContextMenuListener(this);

        /**
         * 一般的dialog
         */
        btn_general_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ComponentLearnActivity.this)
                        .setTitle("删除提示")
                        .setMessage("你确定要删除这条数据吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ComponentLearnActivity.this, "已经删除了此条数据", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

        /**
         * 带单选条目的对话框
         */
        btn_single_select_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] colors = new CharSequence[]{"红色", "蓝色", "绿色"};
                new AlertDialog.Builder(ComponentLearnActivity.this)
                        .setTitle("请选择一种颜色")
                        .setSingleChoiceItems(colors, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ComponentLearnActivity.this, colors[which], Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

        btn_progress_bar_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = ProgressDialog.show(ComponentLearnActivity.this, null, "加载中……", false, true, null);

                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(3000);
                            progressDialog.dismiss();

                            ComponentLearnActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(ComponentLearnActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
                                }
                            });

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 1, 0, "更新");
        menu.add(0, 2, 1, "删除");

        menu.add(1, 1, 2, "发表");
        menu.add(1, 2, 3, "分享");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int groupId = item.getGroupId();
        int itemId = item.getItemId();
        if (groupId == 0) {
            switch (itemId) {
                case 1:
                    Toast.makeText(this, "更新了！", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(this, "删除了！", Toast.LENGTH_SHORT).show();
            }
        }

        return super.onContextItemSelected(item);
    }

    /**
     * 选项菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String optionSelect = null;
        switch (itemId) {
            case R.id.option_menu_item_update:
                optionSelect = "更新";
                break;
            case R.id.option_menu_item_del:
                optionSelect = "删除";
                break;
            case R.id.option_menu_item_publish:
                optionSelect = "发表";
                break;
            case R.id.option_menu_item_share:
                optionSelect = "分享";
        }
        if (!StringUtils.isEmpty(optionSelect)) {
            Toast.makeText(this, optionSelect, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 点击提交按钮的回调方法
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
     * 点击播放图片的回调方法
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
     * 点击重置按钮的回调方法
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
     * 选择兴趣爱好，检查每个checkbox的状态
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
        if (StringUtils.isEmpty(interest)) {
            Toast.makeText(this, "未选择任何爱好！", Toast.LENGTH_SHORT).show();
            return;
        }
        interest = interest.substring(0, interest.length() - 1);
        Toast.makeText(this, interest.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 验证输入框里的内容是否合法
     */
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
