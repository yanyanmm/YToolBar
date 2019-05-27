package com.lihg.toolbar;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        toolBar.getTitleView().setText("班级圈");
        toolBar.getBackView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击返回", Toast.LENGTH_LONG).show();
            }
        });
        ImageView addView = toolBar.createViewWithImage(R.mipmap.btn_add);
        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击+", Toast.LENGTH_LONG).show();
            }
        });
        toolBar.addRightView(addView);


        YToolBar toolBar2 = findViewById(R.id.toolBar2);
        toolBar2.getTitleView().setVisibility(View.GONE);
        toolBar2.getBackView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击返回", Toast.LENGTH_LONG).show();
            }
        });
        toolBar2.addLeftView(toolBar2.createViewWithText("班级圈"));
        ImageView switchView2 = toolBar.createViewWithImage(R.mipmap.btn_switch);
        switchView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击切换", Toast.LENGTH_LONG).show();
            }
        });
        toolBar2.addRightView(switchView2);
        ImageView addView2 = toolBar2.createViewWithImage(R.mipmap.btn_add);
        addView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击+", Toast.LENGTH_LONG).show();
            }
        });
        toolBar2.addRightView(addView2);


        /*TextView rightBtn2 = toolBar2.createViewWithText("切换");//Image(R.mipmap.btn_switch);
        rightBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击切换", Toast.LENGTH_LONG).show();
            }
        });
        toolBar2.addRightView(rightBtn2);//*/
    }
}
