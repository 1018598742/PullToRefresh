package com.example.pulltoref.jingdong;

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

/**
 * Created by Administrator on 2016/12/19.
 */
public class JingDongActivity extends AppCompatActivity{

    private JdRefreshLayout mLayout;
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jingdong);

        mLayout = ((JdRefreshLayout) findViewById(R.id.tes_list_recyview_frame));

        mRecyclerView = ((RecyclerView) findViewById(R.id.testRecyclerView));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
