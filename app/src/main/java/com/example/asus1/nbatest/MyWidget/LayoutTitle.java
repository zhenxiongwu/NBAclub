package com.example.asus1.nbatest.MyWidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.example.asus1.nbatest.R;

/**
 * Created by ASUS1 on 2017/4/25.
 */

public class LayoutTitle extends RelativeLayout {
    public LayoutTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
    }
}
