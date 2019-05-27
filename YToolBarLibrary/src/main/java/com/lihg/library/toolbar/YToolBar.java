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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class YToolBar extends FrameLayout {

    private Context mContext;

    private boolean mBackViewHide;
    private boolean mLineViewHide;
    private int mHeight;
    private int mBackgroundColor;
    private int mTextSize;
    private int mTextColor;
    private int mViewMargin;
    private int mImageWidth;
    private int mImageHeight;

    private LinearLayout mLeftLayout;
    private LinearLayout mMiddleLayout;
    private LinearLayout mRightLayout;

    private View mLineView;
    private TextView mTitleView;
    private ImageView mBackView;


    public YToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context.getApplicationContext();
        mBackViewHide = false;
        mLineViewHide = false;
        mHeight = YDesityUtil.dp2px(mContext, 45);
        mBackgroundColor = Color.TRANSPARENT;
        mTextSize = 18;
        mTextColor = Color.BLACK;
        mViewMargin = YDesityUtil.dp2px(mContext, 15);
        mImageWidth = YDesityUtil.dp2px(mContext, 24);
        mImageHeight = YDesityUtil.dp2px(mContext, 24);

        this.initAttrs(attrs);
        this.initViews();

        this.addBackView();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.YToolBar);
        mBackViewHide = typedArray.getBoolean(R.styleable.YToolBar_toolbar_backView_hide, mBackViewHide);
        mLineViewHide = typedArray.getBoolean(R.styleable.YToolBar_toolbar_lineView_hide, mLineViewHide);
        mHeight = typedArray.getDimensionPixelSize(R.styleable.YToolBar_toolbar_height, mHeight);
        mBackgroundColor = typedArray.getColor(R.styleable.YToolBar_toolbar_backgroundColor, mBackgroundColor);
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.YToolBar_toolbar_textSize, mTextSize);
        mTextColor = typedArray.getColor(R.styleable.YToolBar_toolbar_textColor, mTextColor);
        mViewMargin = typedArray.getDimensionPixelSize(R.styleable.YToolBar_toolbar_viewMargin, mViewMargin);
        mImageWidth = typedArray.getDimensionPixelSize(R.styleable.YToolBar_toolbar_imageWidth, mImageWidth);
        mImageHeight = typedArray.getDimensionPixelSize(R.styleable.YToolBar_toolbar_imageHeight, mImageHeight);
        typedArray.recycle();
    }

    private void initViews() {
        this.setLayoutParams(new LayoutParams(-1, mHeight));
        this.setBackgroundColor(mBackgroundColor);

        mTitleView = new TextView(mContext);
        mTitleView.setLayoutParams(new LayoutParams(-1, -1));
        mTitleView.setGravity(Gravity.CENTER);
        mTitleView.setTextSize(18);
        mTitleView.setTextColor(Color.BLACK);
        this.addView(mTitleView);

        mLineView = new View(mContext);
        mLineView.setVisibility(mLineViewHide ? View.GONE : View.VISIBLE);
        mLineView.setLayoutParams(new LayoutParams(-1, 1, Gravity.BOTTOM));
        mLineView.setBackgroundColor(Color.LTGRAY);
        this.addView(mLineView);

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
        params.setMarginStart(mViewMargin);
        params.setMarginEnd(mViewMargin);
        mMiddleLayout.setLayoutParams(params);
        mMiddleLayout.setGravity(Gravity.CENTER_VERTICAL);
        layout.addView(mMiddleLayout);

        mRightLayout = new LinearLayout(mContext);
        mRightLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        mRightLayout.setGravity(Gravity.CENTER_VERTICAL);
        layout.addView(mRightLayout);
    }

    private void addBackView() {
        mBackView = createViewWithImage(R.mipmap.back);
        mBackView.setVisibility(mBackViewHide ? View.GONE : View.VISIBLE);
        this.addLeftView(mBackView);
    }

    public void addLeftView(View view) {
        this.addLeftView(view, mViewMargin, 0);
    }

    public void addLeftView(View view, int marginStart, int marginEnd) {
        if (view != null) {
            int w = -2, h = -2;
            if (view instanceof ImageView) {
                w = mImageWidth;
                h = mImageHeight;
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(w, h);
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
        this.addRightView(view, 0, mViewMargin);
    }

    public void addRightView(View view, int marginStart, int marginEnd) {
        if (view != null) {
            int w = -2, h = -2;
            if (view instanceof ImageView) {
                w = mImageWidth;
                h = mImageHeight;
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(w, h);
            params.setMarginStart(marginStart);
            params.setMarginEnd(marginEnd);
            view.setLayoutParams(params);
            mRightLayout.addView(view);
        }
    }

    public ImageView createViewWithImage(int resid) {
        ImageView view = new ImageView(mContext);
        view.setBackgroundColor(Color.TRANSPARENT);
        view.setImageResource(resid);
        return view;
    }

    public TextView createViewWithText(int resid) {
        TextView view = new TextView(mContext);
        view.setText(resid);
        view.setTextSize(mTextSize);
        view.setTextColor(mTextColor);
        return view;
    }

    public TextView createViewWithText(String text) {
        TextView view = new TextView(mContext);
        view.setText(text);
        view.setTextSize(mTextSize);
        view.setTextColor(mTextColor);
        return view;
    }

    public View getLineView() {
        return mLineView;
    }

    public TextView getTitleView() {
        return mTitleView;
    }

    public ImageView getBackView() {
        return mBackView;
    }

    public int getViewMargin() {
        return mViewMargin;
    }
}
