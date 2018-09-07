package com.example.trezor.hashwalletui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowAnimationFrameStats;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class BackupMemoryWordsActivity extends Activity implements View.OnClickListener {

    private GridView BackupWordsgridView;
    private GridView BackupWordsgridView1;

    private ViewStub BackupWStub;
    private Button backupmemorywords2bt1;

    private TextView memorywordback;
    private TextView  backuptitle;

    private String walletFlag;//标志如何初始化界面

    //数据来源
    private String[] OrderNum = {"01","02","03","04","05","6","7","8","9","10","11","12"};
    private String[] Words = {"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12"};
    private String[] Words1 = {"Hello1","Hello2","Hello3","Hello4","Hello5","Hello6","Hello7","Hello8","Hello9","Hello10","Hello11","Hello12"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_backup_memory_words);
        initData();
        initViews();
        initLinstener();
       //BackupWordsgridView.setAdapter(new backwords1Adapter(OrderNum,Words,this));
        //BackupWordsgridView1.setAdapter(new backwords2Adapter(this,Words1));
    }

    private void initLinstener() {
        memorywordback.setOnClickListener(this);
        backupmemorywords2bt1.setOnClickListener(this);
    }

    private void initViews() {
        memorywordback = (TextView)findViewById(R.id.memorywordback);
        backuptitle = (TextView) findViewById(R.id.backuptitle);
        //stub里的控件
        BackupWordsgridView = (GridView)findViewById(R.id.BackupWordsgridView);
        BackupWStub = (ViewStub) findViewById(R.id.backwVstub1);
        View BackupWStubView = BackupWStub.inflate();
        BackupWordsgridView1 = (GridView) findViewById(R.id.bkmemorywgridView);
        backupmemorywords2bt1 = BackupWStubView.findViewById(R.id.backupmemorywords2bt1);


        if(walletFlag.equals("create")) {
            //backuptitle.setText();
            BackupWordsgridView.setAdapter(new backwords1Adapter(OrderNum,Words,this));
            backupmemorywords2bt1.setVisibility(View.VISIBLE);
            BackupWordsgridView1.setVisibility(View.GONE);
        }
        else if(walletFlag.equals("import")){
            backupmemorywords2bt1.setVisibility(View.GONE);
            BackupWordsgridView1.setVisibility(View.VISIBLE);
            BackupWordsgridView.setAdapter(new backwords1Adapter(OrderNum,this));
            BackupWordsgridView1.setAdapter(new backwords2Adapter(this,Words1));
        }
    }

    private void initData() {
        walletFlag = getIntent().getStringExtra("walletFlag");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.memorywordback:{
                finish();
                break;
            }
        }
    }
}
