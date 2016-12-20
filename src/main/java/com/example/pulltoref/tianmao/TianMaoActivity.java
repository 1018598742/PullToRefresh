package com.example.pulltoref.tianmao;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.pulltoref.R;
import com.example.pulltoref.MyAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2016/12/19.
 */
public class TianMaoActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private TmallRefreshLayout mLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_tianmao);
        mRecyclerView = ((RecyclerView) findViewById(R.id.recyclerView));
        mLayout = ((TmallRefreshLayout) findViewById(R.id.tmallLayout));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(new MyAdapter());
        mLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                doSth();
            }
        });
    }
    private  void doSth(){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(),"刷新完成", Toast.LENGTH_LONG).show();
                mLayout.refreshComplete();
            }
        }.execute();
    }

}
