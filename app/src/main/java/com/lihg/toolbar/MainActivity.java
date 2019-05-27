package com.lihg.toolbar;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lihg.library.toolbar.YDesityUtil;
import com.lihg.library.toolbar.YToolBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        }
        setContentView(R.layout.activity_main);

        YToolBar toolBar = findViewById(R.id.toolBar);
        toolBar.getBackView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击返回", Toast.LENGTH_LONG).show();
            }
        });
        toolBar.addRightViewWithImage(R.mipmap.btn_add, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击+", Toast.LENGTH_LONG).show();
            }
        });


        YToolBar toolBar2 = findViewById(R.id.toolBar2);
        toolBar2.getBackView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击返回", Toast.LENGTH_LONG).show();
            }
        });
        toolBar2.addLeftViewWithText("班级圈");
        toolBar2.addRightViewWithImage(R.mipmap.btn_switch, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击切换", Toast.LENGTH_LONG).show();
            }
        });
        toolBar2.addRightViewWithImage(R.mipmap.btn_add, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击+", Toast.LENGTH_LONG).show();
            }
        });

        YToolBar toolBar3 = findViewById(R.id.toolBar3);
        toolBar3.addLeftViewWithImage(R.mipmap.btn_switch, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击切换", Toast.LENGTH_LONG).show();
            }
        });
        toolBar3.addRightViewWithImage(R.mipmap.btn_switch, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击切换", Toast.LENGTH_LONG).show();
            }
        });
        toolBar3.addRightViewWithImage(R.mipmap.btn_add, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击+", Toast.LENGTH_LONG).show();
            }
        });
        TextView tv = new TextView(this);
        tv.setText("点击搜索");
        tv.setTextColor(Color.LTGRAY);
        tv.setTextSize(12);
        tv.setGravity(Gravity.CENTER);
        tv.setLayoutParams(new LinearLayout.LayoutParams(-1, YDesityUtil.dp2px(this, 30)));
        tv.setBackgroundResource(R.drawable.editview_style);
        toolBar3.addMiddleView(tv);
    }
}
