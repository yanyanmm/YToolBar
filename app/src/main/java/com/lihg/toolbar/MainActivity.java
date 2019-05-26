package com.lihg.toolbar;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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
        toolBar.getTitleView().setText("班级圈");
        toolBar.getBackBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击返回", Toast.LENGTH_LONG).show();
            }
        });
        ImageButton rightAddBtn = toolBar.createButtonWithImage(R.mipmap.btn_add);
        rightAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击+", Toast.LENGTH_LONG).show();
            }
        });
        toolBar.addRightView(rightAddBtn);
        ImageButton rightBtn = toolBar.createButtonWithImage(R.mipmap.btn_switch);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击切换", Toast.LENGTH_LONG).show();
            }
        });
        toolBar.addRightView(rightBtn);

        YToolBar toolBar2 = findViewById(R.id.toolBar2);
        toolBar2.getTitleView().setVisibility(View.GONE);
        //toolBar2.getBackBtn().setVisibility(View.GONE);
        toolBar2.getBackBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击返回", Toast.LENGTH_LONG).show();
            }
        });
        int left = 0 - YDesityUtil.dp2px(this, 10);
        toolBar2.addLeftView(toolBar2.createButtonWithText("班级圈"), left, 0);
        ImageButton rightAddBtn2 = toolBar2.createButtonWithImage(R.mipmap.btn_add);
        rightAddBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击+", Toast.LENGTH_LONG).show();
            }
        });
        toolBar2.addRightView(rightAddBtn2);
        ImageButton rightBtn2 = toolBar2.createButtonWithImage(R.mipmap.btn_switch);
        rightBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击切换", Toast.LENGTH_LONG).show();
            }
        });
        toolBar2.addRightView(rightBtn2);
    }
}
