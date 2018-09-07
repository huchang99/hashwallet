package com.example.trezor.hashwalletui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class TradingResultActivity extends Activity implements View.OnClickListener {

    private Button TradingBackbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_trading_result);

        initViews();
        initData();
        initLinstener();
    }

    private void initLinstener() {
        TradingBackbt.setOnClickListener(this);
    }

    private void initData() {

    }

    private void initViews() {
        TradingBackbt = (Button)findViewById(R.id.TradingBackbt);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.TradingBackbt:{
                Intent intent = new Intent();
                intent.setClass(TradingResultActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            }

        }
    }
}
