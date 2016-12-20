package com.example.pulltoref.jingdong;

import android.content.Context;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2016/12/19.
 */

public class JdRefreshLayout extends PtrFrameLayout {

    private JdRefreshHeader mHeader;

    public JdRefreshLayout(Context context) {
        this(context,null);
    }

    public JdRefreshLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public JdRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        mHeader = new JdRefreshHeader(getContext());
        setHeaderView(mHeader);
        addPtrUIHandler(mHeader);
    }
}
