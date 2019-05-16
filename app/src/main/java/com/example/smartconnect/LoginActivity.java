package com.example.smartconnect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartconnect.Util.HttpCallbackListener;
import com.example.smartconnect.Util.HttpUtil;

public class LoginActivity extends AppCompatActivity{

    private EditText user_name;
    private EditText password;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Button login_btn = (Button) findViewById(R.id.btn_login);
        user_name = (EditText) findViewById(R.id.et_user_name);
        password = (EditText) findViewById(R.id.et_psw);

        login_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // 登录
                String user_name_str = user_name.getText().toString();
                String password_str = password.getText().toString();
                Toast.makeText(LoginActivity.this, user_name_str, Toast.LENGTH_SHORT).show();
                Toast.makeText(LoginActivity.this, password_str, Toast.LENGTH_SHORT).show();

                //String login_address = "http://192.168.1.110/SmartConnect/public/index/do_android_login?username=admin&password=111111";
                String login_address = "http://192.168.1.110/test_android/public/index/do_android_login";

                showProgressDialog();

                HttpUtil.sendHttpRequest(login_address, new HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) {
                        String responseText = response;

                        if(Boolean.valueOf(responseText)) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    closeProgressDialog();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                        else
                        {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    closeProgressDialog();
                                    Toast.makeText(LoginActivity.this, "登录失败，请检查账号和密码是否正确", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    }

                    @Override
                    public void onError(Exception e) {

                        // 通过runOnUiThread() 方法回到主线程处理逻辑
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                closeProgressDialog();
                                Toast.makeText(LoginActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
            }
        });
    }

    /**
     * 显示进度对话框
     */
    private void showProgressDialog() {
        if(progressDialog == null) {
            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setMessage("正在加载...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    /**
     * 关闭进度对话框
     */
    private void closeProgressDialog() {
        if(progressDialog != null) {
            progressDialog.dismiss();
        }
    }

}
