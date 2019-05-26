package com.lihg.library.toolbar;

import android.content.Context;
import android.util.TypedValue;

public class YDesityUtil {

    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float sp) {
        return (int)TypedValue.applyDimension(2, sp, context.getResources().getDisplayMetrics());
    }
}
