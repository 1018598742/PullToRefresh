package com.example.pulltoref;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.pulltoref.BasicPull.BasicPullActivity;
import com.example.pulltoref.jingdong.JingDongActivity;
import com.example.pulltoref.tianmao.TianMaoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.jingdong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),JingDongActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.tianmao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TianMaoActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.utrlpull).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BasicPullActivity.class);
                startActivity(intent);
            }
        });
    }
}
