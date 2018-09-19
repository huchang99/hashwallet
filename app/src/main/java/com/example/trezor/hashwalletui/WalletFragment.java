package com.example.trezor.hashwalletui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class WalletFragment extends Fragment {

    private RelativeLayout RelativeETH_bt;
    private RelativeLayout RelativeEOS_bt;
    private RelativeLayout RelativeAE_bt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View walletLayout = inflater.inflate(R.layout.walletinfo_layout,container,false);
        RelativeETH_bt = walletLayout.findViewById(R.id.RelativeETH);
        RelativeEOS_bt = walletLayout.findViewById(R.id.RelativeEOS);
        RelativeAE_bt = walletLayout.findViewById(R.id.RelativeAE);
        return walletLayout;
    }
}
