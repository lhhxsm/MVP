package com.android.mvp.model;

import com.android.mvp.bean.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者:lhh
 * 描述:
 * 时间:2017/11/8.
 */
public class BookModelImpl implements IBookModel {
  @Override public void loadBook(BookOnLoadListener listener) {
    List<Book> data = new ArrayList<>();
    data.add(new Book("三国演义", "罗贯中"));
    data.add(new Book("红楼梦", "曹雪芹"));
    data.add(new Book("水浒传", "施耐庵"));
    data.add(new Book("西游记", "吴承恩"));
    listener.onComplete(data);
  }
}
