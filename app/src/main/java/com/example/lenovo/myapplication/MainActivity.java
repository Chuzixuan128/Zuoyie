package com.example.lenovo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//楚子轩
public class MainActivity extends AppCompatActivity {

    private RecyclerView mLv;
    ArrayList<Bean> list = new ArrayList<>();
    private LvMy lvMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
       // initData();
        xianshi();
    }

    private void initData() {
        for (int i = 0;i<=20;i++) {
            list.add(new Bean(Long.valueOf(i),"sadas"+i,"数据"+i));
        }
        Dbutios.getDbutios().insertAll(list);
        }

    private void xianshi() {
        List<Bean> query = Dbutios.getDbutios().query();
        list.addAll(query);
        lvMy.setList(list);
        lvMy.notifyDataSetChanged();
    }

    private void initView() {
        mLv = (RecyclerView) findViewById(R.id.lv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        lvMy = new LvMy(this,list);
        mLv.setLayoutManager(linearLayoutManager);
        mLv.setAdapter(lvMy);
    }
}
