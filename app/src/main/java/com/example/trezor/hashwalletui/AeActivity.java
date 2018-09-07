package com.example.trezor.hashwalletui;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class AeActivity extends FragmentActivity {

    private MyValueFragment AeFragment;

    private ArrayList<String> tv1Strings; //地址
    private ArrayList<String> recordingTimeStrings; //时间
    private ArrayList<String> MoneyStrings; //金额
    private ArrayList<String> Symbols; //标志
    private ArrayList<String> MoneyFlags;

    private AccoutRecycleView adapter;
    private RecyclerView recyclerView;

    //控件
    private TextView Transferbt;//转账
    private TextView Receiptbt;//收款

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eth);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        AeFragment = new MyValueFragment("AE","0.00","AE","0.00");
        transaction.add(R.id.fragment_title ,AeFragment);
        transaction.show(AeFragment);
        transaction.commit();

        initViews();
        //准备数据集合
        initdata();

        adapter = new AccoutRecycleView(this,tv1Strings,recordingTimeStrings,MoneyStrings,Symbols,MoneyFlags);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Transferbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //启动转账界面
                Intent intent = new Intent();
                intent.setClass(AeActivity.this,SendActivity.class);
                intent.putExtra("TextViewEEE","AE");
                startActivity(intent);
            }
        });

        Receiptbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //启动收款界面
                Intent intent = new Intent();
                intent.setClass(AeActivity.this,CollectionMoneyActivity.class);
                // intent.putExtra("TextViewEEE","EOS");
                startActivity(intent);
                intent = null;
            }
        });
    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        Transferbt = (TextView)findViewById(R.id.Transfer);
        Receiptbt = (TextView)findViewById(R.id.Receipt);
    }

    private void initdata() {
        //example
        tv1Strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tv1Strings.add("address_" + i);
        }

        recordingTimeStrings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            recordingTimeStrings.add("time" + i);
        }

        MoneyStrings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MoneyStrings.add("Money_" + i);
        }

        Symbols = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Symbols.add("+" + i);
        }

        MoneyFlags = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MoneyFlags.add("ether" + i);
        }
    }
}
