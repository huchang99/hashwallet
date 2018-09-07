package com.example.trezor.hashwalletui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RelativeLayout RelativeETH_bt;
    private RelativeLayout RelativeEOS_bt;
    private RelativeLayout RelativeAE_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        initLinstener();

        RelativeETH_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //调用ETH详细交易界面
                Intent intentETH = new Intent();
                intentETH.setClass(MainActivity.this,ETHActivity.class);
                startActivity(intentETH);
            }
        });

        RelativeEOS_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //调用EOS详细交易界面
                Intent intentEOS = new Intent();
                intentEOS.setClass(MainActivity.this,EOSActivity.class);
                startActivity(intentEOS);
            }
        });

        RelativeAE_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //调用AE详细交易界面
                Intent intentAE = new Intent();
                intentAE.setClass(MainActivity.this,AeActivity.class);
                startActivity(intentAE);
            }
        });

    }

    private void initLinstener() {

    }
    private void initData() {
    }
    private void initViews() {
        RelativeETH_bt = (RelativeLayout)findViewById(R.id.RelativeETH);
        RelativeEOS_bt = (RelativeLayout)findViewById(R.id.RelativeEOS);
        RelativeAE_bt = (RelativeLayout)findViewById(R.id.RelativeAE);
    }


}
