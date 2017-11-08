package com.android.mvp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.android.mvp.adapter.BookAdapter;
import com.android.mvp.bean.Book;
import com.android.mvp.presenter.BookPresenter;
import com.android.mvp.view.IBookView;
import java.util.List;

public class MainActivity extends BaseActivity<IBookView, BookPresenter<IBookView>>
    implements IBookView {
  private BookAdapter mAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_data);
    mAdapter = new BookAdapter(this);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(mAdapter);
    mPresenter.fetch();
  }

  @Override protected BookPresenter<IBookView> createPresenter() {
    return new BookPresenter<>();
  }

  @Override public void showLoading() {
    Toast.makeText(this, "开始加载", Toast.LENGTH_SHORT).show();
  }

  @Override public void showBook(List<Book> data) {
    mAdapter.setList(data);
  }

  @Override public void dismissLoading() {
    Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
  }
}
