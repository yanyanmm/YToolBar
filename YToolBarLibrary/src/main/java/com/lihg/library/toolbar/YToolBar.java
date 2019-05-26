package com.lihg.library.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class YToolBar extends FrameLayout {

    private Context mContext;

    private int mToolBarHeight;

    private TextView mTitleView;
    private LinearLayout mToolBarLayout;

    public YToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context.getApplicationContext();
        mToolBarHeight = YDesityUtil.dp2px(mContext, 45);

        this.initAttrs(attrs);
        this.initViews();
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

        mToolBarLayout = new LinearLayout(mContext);
        mToolBarLayout.setLayoutParams(new LayoutParams(-1, -1));
        this.addView(mToolBarLayout);

        View lineView = new View(mContext);
        lineView.setLayoutParams(new LayoutParams(-1, 1, Gravity.BOTTOM));
        lineView.setBackgroundColor(Color.LTGRAY);
        this.addView(lineView);
    }

    public TextView getTitleView() {
        return mTitleView;
    }
}
