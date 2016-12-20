package com.example.pulltoref.BasicPull;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.pulltoref.MyAdapter;
import com.example.pulltoref.R;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class BasicPullActivity extends AppCompatActivity {

    private PtrFrameLayout basicPull;
    private RecyclerView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_pull);
        basicPull = ((PtrFrameLayout) findViewById(R.id.basicPull));
        mListView = ((RecyclerView) findViewById(R.id.mListView));
        mListView.setLayoutManager(new LinearLayoutManager(this));
        mListView.setAdapter(new MyAdapter());
        basicPull.setPtrHandler(new PtrDefaultHandler() {
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
                basicPull.refreshComplete();
            }
        }.execute();
    }
}
