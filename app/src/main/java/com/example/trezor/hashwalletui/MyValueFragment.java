package com.example.trezor.hashwalletui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class MyValueFragment extends Fragment{

    //数值
    private String bitvalueString;
    private String bitTitleTopString;
    private String bitTitleRightString;
    private String RMBValueString;

    //控件
    private TextView bitvaluetv;
    private TextView bitTitleToptv;
    private TextView bitTitleRighttv;
    private TextView RMBValuetv;

    //back
    private TextView backtv;

    public  MyValueFragment(String bitTitleTopString,String bitvalueString,String bitTitleRightString,String RMBValueString) {
        this.bitvalueString = bitvalueString;
        this.bitTitleTopString = bitTitleTopString;
        this.bitTitleRightString=bitTitleRightString;
        this.RMBValueString=RMBValueString;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View viewFragment = LayoutInflater.from(getActivity()).inflate(R.layout.fragmentitem,container,false);
        bitvaluetv = viewFragment.findViewById(R.id.bitvalue);
        bitTitleToptv = viewFragment.findViewById(R.id.bitTitleTop);
        bitTitleRighttv = viewFragment.findViewById(R.id.bitTitleRight);
        RMBValuetv = viewFragment.findViewById(R.id.RMBValue);
        backtv = viewFragment.findViewById(R.id.back);

        bitvaluetv.setText(bitvalueString);
        bitTitleToptv.setText(bitTitleTopString);
        bitTitleRighttv.setText(bitTitleRightString);
        RMBValuetv.setText(RMBValueString);
        backtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        return viewFragment;
    }

}
