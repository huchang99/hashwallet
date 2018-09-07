package com.example.trezor.hashwalletui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.renderscript.Script;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;

public class SendActivity extends Activity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private SeekBar mseekbar;
    private TextView tipEEE;
    private TextView CNY_valueSend;
    private TextView backtv1;
    private Button Sendbt;
    private ImageView Erweimasanpic; //二维码
    private EditText CollectionAddressEt;

    //需要初始化的数据
    private  TextView TextViewEEE0;  //nameTitle
    private  TextView TextViewEEE1;
    private  TextView TextViewEEE2;
    private  TextView TextViewEEE3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_send);

//      EditText CollectionAddressEt = (EditText)findViewById(R.id.CollectionAddressEt);
//      Drawable ScanDwPic = getResources().getDrawable(R.drawable.scan);
//      ScanDwPic.setBounds(0,0,150,150);
//      CollectionAddressEt.setCompoundDrawables(null,null,ScanDwPic,null);

        initViews();
        initDatas();
        //监听器
        mseekbar.setOnSeekBarChangeListener(this);
        Erweimasanpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(SendActivity.this, CaptureActivity.class), 0);
            }
        });
    }
    private void initViews() {
        mseekbar=(SeekBar) findViewById(R.id.seekbar);
        tipEEE = (TextView)findViewById(R.id.tipEEE);
        CNY_valueSend = (TextView)findViewById(R.id.CNY_valueSend);
        backtv1 = (TextView)findViewById(R.id.backtv1);
        backtv1.setOnClickListener(this);
        Sendbt = (Button) findViewById(R.id.Sendbt1);
        Sendbt.setOnClickListener(this);

        Erweimasanpic = (ImageView)findViewById(R.id.erweimasanpic);

        TextViewEEE0 = (TextView)findViewById(R.id.nameTitle);
        TextViewEEE1=  (TextView)findViewById(R.id.TextViewEEE1);
        TextViewEEE2 = (TextView)findViewById(R.id.TextViewEEE2);
        TextViewEEE3 = (TextView)findViewById(R.id.TextViewEEE3);
        CollectionAddressEt = (EditText)findViewById(R.id.CollectionAddressEt);

    }

    private void initDatas() {

        Intent intent = getIntent();//获取传来的intent对象
        String data = intent.getStringExtra("TextViewEEE");//获取键值对的键名
        TextViewEEE0.setText("Send "+data);
        TextViewEEE1.setText(data);
        TextViewEEE2.setText(data);
        TextViewEEE3.setText(data);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        tipEEE.setText(i+"");
        CNY_valueSend.setText(i+"");


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.backtv1:
            {
                finish();
                break;
            }
            case R.id.Sendbt1:
            {
                Intent intent = new Intent();
                intent.setClass(SendActivity.this,InputpwdActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String result = data.getExtras().getString("result");
            CollectionAddressEt.setText(result);
        }

    }
}
