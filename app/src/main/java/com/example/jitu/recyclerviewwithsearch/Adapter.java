package com.example.jitu.recyclerviewwithsearch;

/**
 * Created by vishal on 9/12/15.
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class Adapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    private List<T> mDataset;

    // The minimum amount of items to have below your current scroll position before loading more.
    private int visibleThreshold = 2;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;

    public Adapter(List<T> myDataSet, RecyclerView recyclerView) {
        mDataset = myDataSet;

        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {

            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        // End has been reached
                        // Do something
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        loading = true;
                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mDataset.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == VIEW_ITEM) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_adapter, parent, false);

            vh = new dataViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.progressbar_item, parent, false);

            vh = new ProgressViewHolder(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof dataViewHolder) {
            ((dataViewHolder) holder).sourcename.setText(mDataset.get(position).toString());
        } else {
            ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    public void setLoaded() {
        loading = false;
    }

    @Override
    public int getItemCount() {

        System.out.println(mDataset.size());
        return mDataset.size();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }


































    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        }
    }


    public static class dataViewHolder extends RecyclerView.ViewHolder {
        public TextView sourcename;
        public TextView title;
        public TextView time;
        public ImageView imageView;

        public dataViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            sourcename = (TextView) itemView.findViewById(R.id.sourcename);
            title = (TextView) itemView.findViewById(R.id.title);
            time = (TextView) itemView.findViewById(R.id.time);

        }
    }

}