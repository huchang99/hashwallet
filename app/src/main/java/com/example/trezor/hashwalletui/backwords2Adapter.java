package com.example.trezor.hashwalletui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class backwords2Adapter extends BaseAdapter {

    private Context context;
    private String[] Words;

    public backwords2Adapter( Context context,String[] Words){
        this.context = context;
        this.Words = Words;
    }

    @Override
    public int getCount() {
        return Words.length;
    }

    @Override
    public Object getItem(int i) {
        return Words[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.backupwords_item1,null);
        }
        TextView wordDisText = view.findViewById(R.id.wordDis);
        wordDisText.setText(Words[i]);
        return view;
    }


}
