package com.fei.androidmodel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author huangjf
 * @version 创建时间：2016-4-21 下午2:32:46
 * @description
 */
public class FocuseTextView extends TextView {
	public FocuseTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
 
    @Override
    public boolean isFocused() {
        // TODO Auto-generated method stub
        return true;
    }
}
