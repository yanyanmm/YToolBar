package com.lihg.library.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class YToolBar extends FrameLayout {

    private Context mContext;

    private int mToolBarHeight;
    private int mPadding;

    private LinearLayout mLeftLayout;
    private LinearLayout mMiddleLayout;
    private LinearLayout mRightLayout;

    private TextView mTitleView;
    private ImageButton mBackBtn;

    public YToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context.getApplicationContext();
        mToolBarHeight = YDesityUtil.dp2px(mContext, 45);
        mPadding = YDesityUtil.dp2px(mContext, 15);

        this.initAttrs(attrs);
        this.initViews();

        this.addBackButton();
    }

    private void initAttrs(AttributeSet attrs) {

        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.YToolBar);
        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int attr = typedArray.getIndex(i);
        }
    }

    private void initViews() {
        this.setLayoutParams(new LayoutParams(-1, mToolBarHeight));
        this.setBackgroundColor(Color.TRANSPARENT);

        mTitleView = new TextView(mContext);
        mTitleView.setLayoutParams(new LayoutParams(-1, -1));
        mTitleView.setGravity(Gravity.CENTER);
        mTitleView.setTextSize(18);
        mTitleView.setTextColor(Color.BLACK);
        this.addView(mTitleView);

        View lineView = new View(mContext);
        lineView.setLayoutParams(new LayoutParams(-1, 1, Gravity.BOTTOM));
        lineView.setBackgroundColor(Color.LTGRAY);
        this.addView(lineView);

        LinearLayout layout = new LinearLayout(mContext);
        layout.setLayoutParams(new LayoutParams(-1, -1));
        layout.setGravity(Gravity.CENTER_VERTICAL);
        this.addView(layout);

        mLeftLayout = new LinearLayout(mContext);
        mLeftLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        mLeftLayout.setGravity(Gravity.CENTER_VERTICAL);
        layout.addView(mLeftLayout);

        mMiddleLayout = new LinearLayout(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2, 1);
        params.setMarginStart(mPadding);
        params.setMarginEnd(mPadding);
        mMiddleLayout.setLayoutParams(params);
        mMiddleLayout.setGravity(Gravity.CENTER_VERTICAL);
        layout.addView(mMiddleLayout);

        mRightLayout = new LinearLayout(mContext);
        mRightLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        mRightLayout.setGravity(Gravity.CENTER_VERTICAL);
        layout.addView(mRightLayout);
    }

    private void addBackButton() {
        mBackBtn = createButtonWithImage(R.mipmap.back);
        this.addLeftView(mBackBtn);
    }

    public void addLeftView(View view) {
        this.addLeftView(view, mPadding, 0);
    }

    public void addLeftView(View view, int marginStart, int marginEnd) {
        if (view != null) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
            params.setMarginStart(marginStart);
            params.setMarginEnd(marginEnd);
            view.setLayoutParams(params);
            mLeftLayout.addView(view);
        }
    }

    public void addMiddleView(View view) {
        if (view != null) {
            mMiddleLayout.addView(view);
        }
    }

    public void addRightView(View view) {
        this.addRightView(view, 0, mPadding);
    }

    public void addRightView(View view, int marginStart, int marginEnd) {
        if (view != null) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
            params.setMarginStart(marginStart);
            params.setMarginEnd(marginEnd);
            view.setLayoutParams(params);
            mRightLayout.addView(view);
        }
    }

    public ImageButton createButtonWithImage(int resid) {
        ImageButton btn = new ImageButton(mContext);
        btn.setBackgroundColor(Color.TRANSPARENT);
        btn.setImageResource(resid);
        return btn;
    }

    public Button createButtonWithText(int resid) {
        Button btn = new Button(mContext);
        btn.setBackgroundColor(Color.TRANSPARENT);
        btn.setText(resid);
        btn.setTextSize(15);
        return btn;
    }

    public Button createButtonWithText(String text) {
        Button btn = new Button(mContext);
        btn.setBackgroundColor(Color.TRANSPARENT);
        btn.setText(text);
        btn.setTextSize(18);
        btn.setTextColor(Color.BLACK);
        return btn;
    }

    public TextView getTitleView() {
        return mTitleView;
    }

    public ImageButton getBackBtn() {
        return mBackBtn;
    }

    public int getPadding() {
        return mPadding;
    }

    public void setPadding(int padding) {
        this.mPadding = mPadding;
    }
}
