package com.example.trezor.hashwalletui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MySelectMeunView extends RelativeLayout{

    private TextView mainselectText;
    private ImageView mainselectImage;

    private int imgNormal,imgSelect,tvNormal,tvSelect;

    private boolean isSelect=false;

    public MySelectMeunView(Context context) {
        super(context);
    }

    public MySelectMeunView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

        //拿到自定义的属性
        TypedArray tameun = context.obtainStyledAttributes(attrs,R.styleable.myselectmenu_attrs);
        //获取自定义属性的值
       // Drawable image = tameun.getDrawable(R.styleable.myselectmenu_attrs_src);
        String text =tameun.getString(R.styleable.myselectmenu_attrs_text);
        //把值设置到相应的组件上
        mainselectText.setText(text);

        //mainselectImage.setImageDrawable(image);
        imgNormal = tameun.getResourceId(R.styleable.myselectmenu_attrs_image_normal,0);
        imgSelect = tameun.getResourceId(R.styleable.myselectmenu_attrs_image_selected,0);
        tvNormal = tameun.getColor(R.styleable.myselectmenu_attrs_text_color_normal,0);
        tvSelect = tameun.getColor(R.styleable.myselectmenu_attrs_text_color_selected,0);

        mainselectImage.setImageResource(imgNormal);
        mainselectText.setTextColor(tvNormal);
    }

    private void initView(Context context) {
        View.inflate(context,R.layout.mainselectview,this);
        mainselectImage = this.findViewById(R.id.mainselectImage);
        mainselectText = this.findViewById(R.id.mainselectText);
    }

    public void selectMenu() {
        isSelect=true;
        mainselectImage.setImageResource(imgSelect);
        mainselectText.setTextColor(tvSelect);
    }


    public void unSelectMenu() {
        isSelect=false;
        mainselectImage.setImageResource(imgNormal);
        mainselectText.setTextColor(tvNormal);

    }
    public boolean isSelect(){
        return isSelect;
    }

}
