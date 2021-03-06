package com.fei.androidmodel.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fei.androidmodel.R;
import com.fei.androidmodel.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by Administrator on 2017/8/3.
 */

public class BottomListDialog extends BottomSheetDialog {

    @BindView(R.id.tv_dialog_confirm)
    TextView tvDialogConfirm;
    @BindView(R.id.tv_dialog_cancle)
    TextView tvDialogCancle;
    @BindView(R.id.tv_dialog_title)
    TextView tvDialogTitle;
    @BindView(R.id.lv_dialog)
    ListView lvDialog;

    private Context mContext;
    private OnCancleListener onCancleListener;
    private OnItemClickListener onItemClickListener;
    private OnConfirmListener onConfirmListener;

    public void setOnCancleListener(OnCancleListener onCancleListener) {
        this.onCancleListener = onCancleListener;
    }

    public void setOnConfirmListener(OnConfirmListener onConfirmListener) {
        this.onConfirmListener = onConfirmListener;
        tvDialogConfirm.setVisibility(View.VISIBLE);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public BottomListDialog(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public BottomListDialog(Context context, int theme) {
        super(context, theme);
        mContext = context;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_list_dialog, null);
        setContentView(view);
        ButterKnife.bind(this, view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int screenHeight = mContext.getResources().getDisplayMetrics().heightPixels;
        int statusBarHeight = Utils.getStatusBarHeight(mContext);
        int height = screenHeight - statusBarHeight;
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, height == 0 ? ViewGroup.LayoutParams.MATCH_PARENT : height);
    }

    public BottomListDialog setTitle(String title) {
        tvDialogTitle.setText(title);
        return this;
    }

    public BottomListDialog setAdapter(ListAdapter adapter) {
        lvDialog.setAdapter(adapter);
        return this;
    }

    @OnClick(R.id.tv_dialog_cancle)
    void clickCancle(View view) {
        if (onCancleListener != null) {
            onCancleListener.onClick(view);
        }
        this.dismiss();
    }

    @OnClick(R.id.tv_dialog_confirm)
    void clickConfirm(View view) {
        if (onConfirmListener != null) {
            onConfirmListener.onClick(view);
        }
        this.dismiss();
    }

    @OnItemClick(R.id.lv_dialog)
    void clickItem(AdapterView<?> parent, View view, int position, long id) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(parent, view, position, id);
            this.dismiss();
        }
    }

    @Override
    public void show() {
        super.show();
    }

    public interface OnCancleListener {
        void onClick(View view);
    }

    public interface OnConfirmListener {
        void onClick(View view);
    }

    public interface OnItemClickListener {
        void onItemClick(AdapterView<?> parent, View view, int position, long id);
    }

}
