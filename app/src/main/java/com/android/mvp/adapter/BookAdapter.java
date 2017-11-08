package com.android.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.mvp.R;
import com.android.mvp.bean.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者:lhh
 * 描述:
 * 时间:2017/11/8.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
  private LayoutInflater mInflater;
  private List<Book> mList;

  public BookAdapter(Context context) {
    mInflater = LayoutInflater.from(context);
    this.mList = new ArrayList<>();
  }

  public void setList(List<Book> list) {
    if (mList != null && mList.size() > 0) {
      mList.clear();
    }
    if (list != null && list.size() > 0) {
      mList.addAll(list);
    }
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.item_book, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Book book = mList.get(position);
    holder.mTvName.setText(TextUtils.isEmpty(book.name) ? "" : book.name);
    holder.mTvAuthor.setText(TextUtils.isEmpty(book.author) ? "" : book.author);
  }

  @Override public int getItemCount() {
    return mList != null ? mList.size() : 0;
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvName;
    private TextView mTvAuthor;

    public ViewHolder(View itemView) {
      super(itemView);
      mTvName = (TextView) itemView.findViewById(R.id.tv_name);
      mTvAuthor = (TextView) itemView.findViewById(R.id.tv_author);
    }
  }
}
