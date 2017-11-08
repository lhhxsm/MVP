package com.android.mvp.model;

import com.android.mvp.bean.Book;
import java.util.List;

/**
 * 作者:lhh
 * 描述:用来加载数据
 * 时间:2017/11/8.
 */
public interface IBookModel {
  void loadBook(BookOnLoadListener listener);

  //设计一个内部回调接口
  interface BookOnLoadListener {
    void onComplete(List<Book> data);
  }
}
