package com.android.mvp.presenter;

import java.lang.ref.WeakReference;

/**
 * 作者:lhh
 * 描述:
 * 时间:2017/11/8.
 */
public class BasePresenter<V> {

  //1. view 层的引用
  private WeakReference<V> mReference;

  //进行绑定
  public void attachView(V view) {
    mReference = new WeakReference<V>(view);
  }

  //进行解绑
  public void detachView() {
    mReference.clear();
  }

  protected V getView() {
    return mReference.get();
  }
}
