package com.lihg.library.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class YToolBar extends FrameLayout {

    private Context mContext;

    private boolean mBackViewHide;
    private boolean mTitleViewHide;
    private boolean mLineViewHide;
    private boolean mStatusBarHeight;
    private int mHeight;
    private int mBackgroundColor;
    private int mTextSize;
    private int mTextColor;
    private int mViewMargin;
    private int mImageWidth;
    private int mImageHeight;
    private String mTitle;

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
        mTitleViewHide = false;
        mLineViewHide = false;
        mStatusBarHeight = false;
        mHeight = dp2px(mContext,45);
        mBackgroundColor = Color.TRANSPARENT;
        mTextSize = sp2px(mContext,18);
        mTextColor = Color.BLACK;
        mViewMargin = dp2px(mContext,15);
        mImageWidth = dp2px(mContext,24);
        mImageHeight = dp2px(mContext,24);
        mTitle = null;

        this.initAttrs(attrs);
        this.initViews();

        this.addBackView();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.YToolBar);
        mBackViewHide = typedArray.getBoolean(R.styleable.YToolBar_toolbar_backView_hide, mBackViewHide);
        mTitleViewHide = typedArray.getBoolean(R.styleable.YToolBar_toolbar_titleView_hide, mTitleViewHide);
        mLineViewHide = typedArray.getBoolean(R.styleable.YToolBar_toolbar_lineView_hide, mLineViewHide);
        mStatusBarHeight = typedArray.getBoolean(R.styleable.YToolBar_toolbar_status_bar_height, mStatusBarHeight);
        mHeight = typedArray.getDimensionPixelSize(R.styleable.YToolBar_toolbar_height, mHeight);
        mBackgroundColor = typedArray.getColor(R.styleable.YToolBar_toolbar_backgroundColor, mBackgroundColor);
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.YToolBar_toolbar_textSize, mTextSize);
        mTextColor = typedArray.getColor(R.styleable.YToolBar_toolbar_textColor, mTextColor);
        mViewMargin = typedArray.getDimensionPixelSize(R.styleable.YToolBar_toolbar_viewMargin, mViewMargin);
        mImageWidth = typedArray.getDimensionPixelSize(R.styleable.YToolBar_toolbar_imageWidth, mImageWidth);
        mImageHeight = typedArray.getDimensionPixelSize(R.styleable.YToolBar_toolbar_imageHeight, mImageHeight);
        mTitle = typedArray.getString(R.styleable.YToolBar_toolbar_title);
        typedArray.recycle();
    }

    private void initViews() {
        this.setBackgroundColor(mBackgroundColor);
        LinearLayout layout = new LinearLayout(mContext);
        LayoutParams layoutParams = new LayoutParams(-1, mHeight);
        layoutParams.gravity = Gravity.BOTTOM;
        if (mStatusBarHeight) {
            layoutParams.topMargin = getStatusBarHeight();
        }
        layout.setLayoutParams(layoutParams);
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

        mLineView = new View(mContext);
        mLineView.setVisibility(mLineViewHide ? View.GONE : View.VISIBLE);
        mLineView.setLayoutParams(new LayoutParams(-1, 1, Gravity.BOTTOM));
        mLineView.setBackgroundColor(Color.LTGRAY);
        this.addView(mLineView);

        mTitleView = new TextView(mContext);
        mTitleView.setVisibility(mTitleViewHide ? View.GONE : View.VISIBLE);
        mTitleView.setLayoutParams(new LayoutParams(-1, mHeight, Gravity.BOTTOM));
        mTitleView.setGravity(Gravity.CENTER);
        if (mTitle != null) {
            mTitleView.setText(mTitle);
        }
        mTitleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        mTitleView.setTextColor(mTextColor);
        this.addView(mTitleView);
    }

    public int getStatusBarHeight() {
        int resId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        return getResources().getDimensionPixelSize(resId);
    }

    private void addBackView() {
        mBackView = createViewWithImage(R.mipmap.back);
        mBackView.setVisibility(mBackViewHide ? View.GONE : View.VISIBLE);
        this.addLeftView(mBackView);
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
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        view.setTextColor(mTextColor);
        view.setGravity(Gravity.CENTER);
        return view;
    }

    public TextView createViewWithText(String text) {
        TextView view = new TextView(mContext);
        view.setText(text);
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        view.setTextColor(mTextColor);
        view.setGravity(Gravity.CENTER);
        return view;
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
            params.gravity = Gravity.CENTER;
            view.setLayoutParams(params);
            mLeftLayout.addView(view);
        }
    }

    public void addLeftViewWithImage(int resid) {
        this.addLeftViewWithImage(resid, null);
    }

    public void addLeftViewWithImage(int resid, View.OnClickListener listener) {
        this.addLeftViewWithImage(resid, mViewMargin, 0, listener);
    }

    public void addLeftViewWithImage(int resid, int marginStart, int marginEnd, View.OnClickListener listener) {
        ImageView view = this.createViewWithImage(resid);
        view.setOnClickListener(listener);
        this.addLeftView(view, marginStart, marginEnd);
    }

    public void addLeftViewWithText(int resid) {
        this.addLeftViewWithText(resid, null);
    }

    public void addLeftViewWithText(int resid, View.OnClickListener listener) {
        this.addLeftViewWithText(resid, mViewMargin, 0, listener);
    }

    public void addLeftViewWithText(int resid, int marginStart, int marginEnd, View.OnClickListener listener) {
        TextView view = this.createViewWithText(resid);
        view.setOnClickListener(listener);
        this.addLeftView(view, marginStart, marginEnd);
    }

    public void addLeftViewWithText(String text) {
        this.addLeftViewWithText(text, null);
    }

    public void addLeftViewWithText(String text, View.OnClickListener listener) {
        this.addLeftViewWithText(text, mViewMargin, 0, listener);
    }

    public void addLeftViewWithText(String text, int marginStart, int marginEnd, View.OnClickListener listener) {
        TextView view = this.createViewWithText(text);
        view.setOnClickListener(listener);
        this.addLeftView(view, marginStart, marginEnd);
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
            params.gravity = Gravity.CENTER;
            view.setLayoutParams(params);
            mRightLayout.addView(view);
        }
    }

    public void addRightViewWithImage(int resid) {
        this.addRightViewWithImage(resid, null);
    }

    public void addRightViewWithImage(int resid, View.OnClickListener listener) {
        this.addRightViewWithImage(resid, 0, mViewMargin, listener);
    }

    public void addRightViewWithImage(int resid, int marginStart, int marginEnd, View.OnClickListener listener) {
        ImageView view = this.createViewWithImage(resid);
        view.setOnClickListener(listener);
        this.addRightView(view, marginStart, marginEnd);
    }

    public void addRightViewWithText(int resid) {
        this.addRightViewWithText(resid, null);
    }

    public void addRightViewWithText(int resid, View.OnClickListener listener) {
        this.addRightViewWithText(resid, 0, mViewMargin, listener);
    }

    public void addRightViewWithText(int resid, int marginStart, int marginEnd, View.OnClickListener listener) {
        TextView view = this.createViewWithText(resid);
        view.setOnClickListener(listener);
        this.addRightView(view, marginStart, marginEnd);
    }

    public void addRightViewWithText(String text) {
        this.addRightViewWithText(text, null);
    }

    public void addRightViewWithText(String text, View.OnClickListener listener) {
        this.addRightViewWithText(text, 0, mViewMargin, listener);
    }

    public void addRightViewWithText(String text, int marginStart, int marginEnd, View.OnClickListener listener) {
        TextView view = this.createViewWithText(text);
        view.setOnClickListener(listener);
        this.addRightView(view, marginStart, marginEnd);
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

    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float sp) {
        return (int)TypedValue.applyDimension(2, sp, context.getResources().getDisplayMetrics());
    }
}
