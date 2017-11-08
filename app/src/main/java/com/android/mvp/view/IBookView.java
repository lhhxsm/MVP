package com.android.mvp.view;

import com.android.mvp.bean.Book;
import java.util.List;

/**
 * 作者:lhh
 * 描述:定义出所有的UI逻辑
 * 时间:2017/11/8.
 */
public interface IBookView {
  void showLoading();

  void showBook(List<Book> data);

  void dismissLoading();
}
