package com.android.mvp.presenter;

import com.android.mvp.bean.Book;
import com.android.mvp.model.BookModelImpl;
import com.android.mvp.model.IBookModel;
import com.android.mvp.view.IBookView;
import java.util.List;

/**
 * 作者:lhh
 * 描述:表示层
 * 时间:2017/11/8.
 */
public class BookPresenter<V extends IBookView> extends BasePresenter<V> {

  //2. model 层的引用
  private IBookModel mBookModel = new BookModelImpl();

  //4.执行操作(UI逻辑)
  public void fetch() {
    if (getView() != null) {
      getView().showLoading();
      if (mBookModel != null) {
        mBookModel.loadBook(new IBookModel.BookOnLoadListener() {
          @Override public void onComplete(List<Book> data) {
            getView().showBook(data);
            getView().dismissLoading();
          }
        });
      }
    }
  }
}
