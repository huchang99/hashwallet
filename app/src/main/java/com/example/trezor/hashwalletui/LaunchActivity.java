package com.example.trezor.hashwalletui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class LaunchActivity extends Activity implements View.OnClickListener {

    private Button creatWalletbt;
    private Button importWalletbt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_launch);

        initViews();
        initData();
        initLinstener();
    }

    private void initLinstener() {
        creatWalletbt.setOnClickListener(this);
        importWalletbt.setOnClickListener(this);
    }
    private void initData() {
    }


    private void initViews() {
        creatWalletbt = (Button)findViewById(R.id.creatWalletbt);
        importWalletbt = (Button)findViewById(R.id.importWalletbt);
    }

    @Override
    public void onClick(View view) {
        Intent intent= new Intent();
        switch (view.getId())
        {
            case R.id.creatWalletbt: { //创建钱包
                intent.putExtra("walletFlag","create");
                intent.setClass(LaunchActivity.this,BackupMemoryWordsActivity.class);
                startActivity(intent);
                intent = null;
                break;
            }

            case R.id.importWalletbt: {
                //导入钱包
                intent.putExtra("walletFlag","import");
                intent.setClass(LaunchActivity.this,BackupMemoryWordsActivity.class);
                startActivity(intent);
                intent = null;
                break;
            }

        }

    }
}
