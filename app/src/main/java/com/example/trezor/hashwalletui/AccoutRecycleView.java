package com.example.trezor.hashwalletui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AccoutRecycleView extends RecyclerView.Adapter<AccoutRecycleView.MyViewHolder>{

    private final Context context;
    private ArrayList<String> tv1Strings; //地址
    private ArrayList<String> recordingTimeStrings; //时间
    private ArrayList<String> MoneyStrings; //金额
    private ArrayList<String> Symbols; //标志
    private ArrayList<String> MoneyFlags;


    public AccoutRecycleView(Context context,ArrayList<String> tv1Strings,ArrayList<String> recordingTimeStrings,ArrayList<String> MoneyStrings,ArrayList<String> Symbols,ArrayList<String> MoneyFlags) {
        this.context = context;
        this.tv1Strings = tv1Strings;
        this.recordingTimeStrings = recordingTimeStrings;
        this.MoneyStrings = MoneyStrings;
        this.Symbols = Symbols;
        this.MoneyFlags = MoneyFlags;

    }

    @NonNull
    @Override
    public AccoutRecycleView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = View.inflate(context,R.layout.item_recyclerview,null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccoutRecycleView.MyViewHolder holder, int position) {
        String tv1s = tv1Strings.get(position);
        String recordingTimeString = recordingTimeStrings.get(position);
        String MoneyString = MoneyStrings.get(position);
        String Symbol = Symbols.get(position);
        String MoneyFlag = MoneyFlags.get(position);

        holder.tv1.setText(tv1s);
        holder.recordingTime.setText(recordingTimeString);
        holder.symbol.setText(Symbol);
        holder.RMB1value.setText(MoneyString);
        holder.moneyFlag.setText(MoneyFlag);
    }

    @Override
    public int getItemCount() {
        return tv1Strings.size();
    }

    /**
     * 增加数据
     * @param position
     * @param tv1s
     */
    public void addData(int position,String tv1s , String recordingTimeString,String MoneyString,String Symbol,String MoneyFlag){
        //datas.add(position,data);
        tv1Strings.add(position,tv1s);
        recordingTimeStrings.add(position,recordingTimeString);
        MoneyStrings.add(position,MoneyString);
        Symbols.add(position,Symbol);
        MoneyFlags.add(position,MoneyFlag);
        notifyItemInserted(position);

    }

    /**
     * 移除
     * @param position
     */
    public void removeData(int position){
        //datas.remove(position);
        tv1Strings.remove(position);
        recordingTimeStrings.remove(position);
        MoneyStrings.remove(position);
        Symbols.remove(position);
        MoneyFlags.remove(position);
        notifyItemRemoved(position);


    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private TextView recordingTime;
        private TextView symbol;
        private TextView RMB1value;
        private TextView moneyFlag;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            recordingTime = (TextView) itemView.findViewById(R.id.recordingTime);
            symbol = (TextView) itemView.findViewById(R.id.symbol);
            RMB1value = (TextView) itemView.findViewById(R.id.RMB1value);
            moneyFlag = (TextView)itemView.findViewById(R.id.flag);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toast.makeText(context,"data=="+datas.get(getLayoutPosition()),Toast.LENGTH_SHORT).show();
//                    if(onItemClickListener != null){
//                        onItemClickListener.OnItemClick(v,datas.get(getLayoutPosition()));
//                    }
                }
            });
        }
    }

}
