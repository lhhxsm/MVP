package com.android.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.android.mvp.presenter.BasePresenter;

/**
 * 作者:lhh
 * 描述:
 * 时间:2017/11/8.
 */
public abstract class BaseActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {

  //表示层的引用
  public P mPresenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mPresenter = createPresenter();
    mPresenter.attachView((V) this);
  }

  protected abstract P createPresenter();

  @Override protected void onDestroy() {
    super.onDestroy();
    mPresenter.detachView();
  }
}
