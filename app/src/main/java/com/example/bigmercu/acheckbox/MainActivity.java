package com.example.bigmercu.acheckbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bigmercu.bCheckbox.BBox;


public class MainActivity extends AppCompatActivity {

    private BBox mBBoxAlo;
    private BBox mBBoxAndroidArt;
    private BBox mBBoxCoreJava;
    private BBox mBBoxNet;
    private BBox mBBoxWord;
    private BBox mBBoxGirl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       initView();
    }

    private void initView(){
        mBBoxAlo = (BBox) findViewById(R.id.BBox3);
        mBBoxAndroidArt = (BBox) findViewById(R.id.BBox2);
        mBBoxCoreJava = (BBox) findViewById(R.id.BBox4);
        mBBoxNet = (BBox) findViewById(R.id.BBox5);
        mBBoxWord = (BBox) findViewById(R.id.BBox6);
        mBBoxGirl = (BBox) findViewById(R.id.BBox7);
        mBBoxAlo.setChecked(true);
        mBBoxAlo.setOnCheckedChangeListener(new BBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
//                Toast.makeText(getApplicationContext(),"算法",Toast.LENGTH_SHORT).show();
            }
        });

        mBBoxAndroidArt.setOnCheckedChangeListener(new BBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
//                Toast.makeText(getApplicationContext(),"开发艺术探索",Toast.LENGTH_SHORT).show();
            }
        });

        mBBoxCoreJava.setOnCheckedChangeListener(new BBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
//                Toast.makeText(getApplicationContext(),"Core Java",Toast.LENGTH_SHORT).show();
            }
        });

        mBBoxNet.setOnCheckedChangeListener(new BBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
//                Toast.makeText(getApplicationContext(),"网络",Toast.LENGTH_SHORT).show();
            }
        });

        mBBoxWord.setOnCheckedChangeListener(new BBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
//                Toast.makeText(getApplicationContext(),"背单词",Toast.LENGTH_SHORT).show();
            }
        });

        mBBoxGirl.setOnCheckedChangeListener(new BBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
                if (checked){
                    mBBoxAlo.setChecked(false);
                    mBBoxAndroidArt.setChecked(false);
                    mBBoxCoreJava.setChecked(false);
                    mBBoxNet.setChecked(false);
                    mBBoxWord.setChecked(false);
                }else {
                    mBBoxAlo.setChecked(true);
                    mBBoxAndroidArt.setChecked(true);
                    mBBoxCoreJava.setChecked(true);
                    mBBoxNet.setChecked(true);
                    mBBoxWord.setChecked(true);
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
