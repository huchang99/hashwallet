package com.example.trezor.hashwalletui;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

//    private RelativeLayout RelativeETH_bt;
//    private RelativeLayout RelativeEOS_bt;
//    private RelativeLayout RelativeAE_bt;
    private WalletFragment walletFragment;
    private myinfoFragment myinfoFragmentview;
    private marketinfoFragment marketinfoFragmentview;

    private MySelectMeunView walletmentbt,marketmenubt,mineinfobt,lastBottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        initLinstener();

//        RelativeETH_bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //调用ETH详细交易界面
//                Intent intentETH = new Intent();
//                intentETH.setClass(MainActivity.this,ETHActivity.class);
//                startActivity(intentETH);
//            }
//        });
//
//        RelativeEOS_bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //调用EOS详细交易界面
//                Intent intentEOS = new Intent();
//                intentEOS.setClass(MainActivity.this,EOSActivity.class);
//                startActivity(intentEOS);
//            }
//        });
//
//        RelativeAE_bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //调用AE详细交易界面
//                Intent intentAE = new Intent();
//                intentAE.setClass(MainActivity.this,AeActivity.class);
//                startActivity(intentAE);
//            }
//        });

    }

    private void initLinstener() {
        walletmentbt.setOnClickListener(this);
        marketmenubt.setOnClickListener(this);
        mineinfobt.setOnClickListener(this);


    }
    private void initData() {
    }
    private void initViews() {
        //默认加载钱包的fragment
        FragmentManager Fm = getSupportFragmentManager();

        //菜单选项
        walletmentbt = (MySelectMeunView) findViewById(R.id.walletmentbt);
        marketmenubt = (MySelectMeunView) findViewById(R.id.marketmenubt);
        mineinfobt = (MySelectMeunView)findViewById(R.id.mineinfobt);
        //默认选中第一项
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                walletmentbt.performClick();//模拟点击事件 让首页选中
            }
        });
        //walletmentbt.performClick();
    }


    @Override
    public void onClick(View v) {
        MySelectMeunView mySelectMeunView = (MySelectMeunView) v;
        if(mySelectMeunView.isSelect()) {
            return;
        }
        mySelectMeunView.selectMenu();
        if(lastBottomMenu != null)
        {
            lastBottomMenu.unSelectMenu();
        }
        lastBottomMenu = mySelectMeunView;

    }
}
