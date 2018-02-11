package com.example.pulltoref.tianmao;

import android.content.Context;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrFrameLayout;


/**
 * 仿天猫下拉刷新view
 * Created by shenminjie on 2016/12/6.
 */

public class TmallRefreshLayout extends PtrFrameLayout {

    /**
     * headerView
     */
     TmallRefreshHeader mHeaderView;

    public TmallRefreshLayout(Context context) {
        this(context,null);
    }

    public TmallRefreshLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TmallRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }


    /**
     * 初始化view
     */
    private void initView() {
        mHeaderView = new TmallRefreshHeader(getContext());
        setHeaderView(mHeaderView);
        addPtrUIHandler(mHeaderView);
    }


}
