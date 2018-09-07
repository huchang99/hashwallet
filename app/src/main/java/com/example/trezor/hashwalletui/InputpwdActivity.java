package com.example.trezor.hashwalletui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputpwdActivity extends Activity implements View.OnClickListener {

    private final static String TAG = "InputpwdActivity";

    private EditText tv_pass1;
    private EditText tv_pass2;
    private EditText tv_pass3;
    private EditText tv_pass4;
    private EditText tv_pass5;
    private EditText tv_pass6;
    private Button OkPsw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_inputpwd);

        initViews();
        initData();
        initLinstener();
    }

    private void initLinstener() {
        OkPsw.setOnClickListener(this);
//        tv_pass1.addTextChangedListener(this);
//        tv_pass2.addTextChangedListener(this);
//        tv_pass3.addTextChangedListener(this);
//        tv_pass4.addTextChangedListener(this);
//        tv_pass5.addTextChangedListener(this);
//        tv_pass6.addTextChangedListener(this);

    }

    private void initData() {

    }

    private void initViews() {
        tv_pass1 = (EditText) findViewById(R.id.tv_pass1);
        tv_pass2 = (EditText) findViewById(R.id.tv_pass2);
        tv_pass3 = (EditText) findViewById(R.id.tv_pass3);
        tv_pass4 = (EditText) findViewById(R.id.tv_pass4);
        tv_pass5 = (EditText) findViewById(R.id.tv_pass5);
        tv_pass6 = (EditText) findViewById(R.id.tv_pass6);
        OkPsw = (Button) findViewById(R.id.OkPsw);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.OkPsw:
                Intent intent = new Intent();
                intent.setClass(InputpwdActivity.this,TradingResultActivity.class);
                startActivity(intent);
                /*
                String password = tv_pass1.getText().toString()+tv_pass2.getText().toString()+
                        tv_pass3.getText().toString()+tv_pass4.getText().toString()+
                        tv_pass5.getText().toString()+tv_pass6.getText().toString();
                Log.d(TAG+"+++pwd",password);
                if("123456".equals(password))
                {
                    //如果密码正确,跳到成功界面。
                    Intent intent = new Intent();
                    intent.setClass(InputpwdActivity.this,TradingResultActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this,"密码错误，请重新输入密码",Toast.LENGTH_LONG).show();
                    tv_pass1.getText().clear();
                    tv_pass2.getText().clear();
                    tv_pass3.getText().clear();
                    tv_pass4.getText().clear();
                    tv_pass5.getText().clear();
                    tv_pass6.getText().clear();

                }
                */
                break;
        }

    }

}
