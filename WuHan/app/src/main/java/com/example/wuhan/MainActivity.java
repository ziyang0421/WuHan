package com.example.wuhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 启动服务播放背景音乐
        intent = new Intent(MainActivity.this, BackgroundMusicService.class);
        String action = "android.intent.action.RESPOND_VIA_MESSAGE";
        // 设置action
        intent.setAction(action);
        startService(intent);

        // 绑定btn1的点击事件
        Button button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Page1Activity.class);
                startActivity(intent);
            }
        });

        // 绑定btn2的点击事件
        Button button2 = (Button) findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Page2Activity.class);
                startActivity(intent);
            }
        });

        // 绑定btn3的点击事件
        Button button3 = (Button) findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Page3Activity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 程序退出时销毁播放音乐的进程
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (intent != null){
            // 对于intentService，这一步可能是多余的
            stopService(intent);
        }
    }
}
