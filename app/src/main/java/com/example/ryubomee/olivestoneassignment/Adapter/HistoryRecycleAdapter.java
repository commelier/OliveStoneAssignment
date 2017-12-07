package com.example.ryubomee.olivestoneassignment.Adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ryubomee.olivestoneassignment.R;
import com.example.ryubomee.olivestoneassignment.data.HistoryData;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.OrderedRealmCollection;

/**
 * Created by RyuBomee on 2017. 12. 7..
 *
 * this class is for making recyclerView & viewHolder
 * it makes your program more smooth, and also it uses less memory
 */

public class HistoryRecycleAdapter extends RealmRecyclerViewAdapter<HistoryData, HistoryRecycleAdapter.MyViewHolder> {


    public HistoryRecycleAdapter(@Nullable OrderedRealmCollection<HistoryData> data, boolean autoUpdate) {
        super(data, autoUpdate);
        setHasStableIds(true);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historylist, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final HistoryData historyData = getItem(position);
        holder.historyData = historyData;
        holder.textInput.setText(String.valueOf(historyData.getInput()));
        holder.textResult.setText(String.valueOf(historyData.getResult()));

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_input)
        TextView textInput;
        @BindView(R.id.text_result)
        TextView textResult;

        public HistoryData historyData;

        public MyViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
