package com.example.trezor.hashwalletui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class backwords1Adapter extends BaseAdapter{

    private String[] OrderNums;
    private String[] Words;
    private Context context;
    private boolean backupFlag;

    public backwords1Adapter(String[] OrderNums,String[] Words,Context context) {
        this.OrderNums = OrderNums;
        this.Words = Words;
        this.context = context;
        backupFlag = false;
    }

    public backwords1Adapter(String[] orderNums,Context context) {
        this.OrderNums = orderNums;
        this.context = context;
        backupFlag = true;
    }

    @Override
    public int getCount() {
        return OrderNums.length;
    }

    @Override
    public Object getItem(int i) {
        return OrderNums[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.backupwords_item,null);
        }
        TextView ItemText = view.findViewById(R.id.ItemText);
        TextView OrderNum = view.findViewById(R.id.OrderNum);
        if(backupFlag == false)
        {
            ItemText.setText(Words[i]);
            OrderNum.setText(OrderNums[i]);
        }
        if(backupFlag == true)
        {
            ItemText.setText(null);
            OrderNum.setText(OrderNums[i]);
        }
        return view;
    }
}
