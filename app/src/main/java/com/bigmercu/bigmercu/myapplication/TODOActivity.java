package com.bigmercu.bigmercu.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bigmercu.cBox.CheckBox;


public class TODOActivity extends AppCompatActivity {

    private CheckBox mCheckBoxAlo;
    private CheckBox mCheckBoxAndroidArt;
    private CheckBox mCheckBoxCoreJava;
    private CheckBox mCheckBoxNet;
    private CheckBox mCheckBoxWord;
    private CheckBox mCheckBoxGirl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    private void initView(){
        mCheckBoxAlo = (CheckBox) findViewById(R.id.BBox3);
        mCheckBoxAndroidArt = (CheckBox) findViewById(R.id.BBox2);
        mCheckBoxCoreJava = (CheckBox) findViewById(R.id.BBox4);
        mCheckBoxNet = (CheckBox) findViewById(R.id.BBox5);
        mCheckBoxWord = (CheckBox) findViewById(R.id.BBox6);
        mCheckBoxGirl = (CheckBox) findViewById(R.id.BBox7);
        mCheckBoxAlo.setChecked(true);
        mCheckBoxAlo.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
//                Toast.makeText(getApplicationContext(),"算法",Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxAndroidArt.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
//                Toast.makeText(getApplicationContext(),"开发艺术探索",Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxCoreJava.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
//                Toast.makeText(getApplicationContext(),"Core Java",Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxNet.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
//                Toast.makeText(getApplicationContext(),"网络",Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxWord.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
//                Toast.makeText(getApplicationContext(),"背单词",Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxGirl.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onChange(boolean checked) {
                if (checked){
                    mCheckBoxAlo.setChecked(false);
                    mCheckBoxAndroidArt.setChecked(false);
                    mCheckBoxCoreJava.setChecked(false);
                    mCheckBoxNet.setChecked(false);
                    mCheckBoxWord.setChecked(false);
                }else {
                    mCheckBoxAlo.setChecked(true);
                    mCheckBoxAndroidArt.setChecked(true);
                    mCheckBoxCoreJava.setChecked(true);
                    mCheckBoxNet.setChecked(true);
                    mCheckBoxWord.setChecked(true);
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
