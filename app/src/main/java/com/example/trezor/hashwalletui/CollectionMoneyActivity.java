package com.example.trezor.hashwalletui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class CollectionMoneyActivity extends Activity implements View.OnClickListener {

    private Button collectback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_collection_money);

        initViews();
        initData();
        initLinstener();
    }

    private void initViews() {
        collectback = (Button)findViewById(R.id.collectback);
    }

    private void initData() {

    }

    private void initLinstener() {
        collectback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.collectback:
            {
                finish();
                break;
            }
        }
    }
}
