package com.sherlockxu.recyclerviewdevelop.link;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sherlockxu.recyclerviewdevelop.DataBean;
import com.sherlockxu.recyclerviewdevelop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * author         xulei
 * Date           2017/3/28
 */

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.MyViewHolder> {
    private Context context;
    private List<DataBean> list = new ArrayList<>();
    private LayoutInflater inflater;

    public TypeAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(List<DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.item_recyclerview_type, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvType.setText(list.get(position).getName());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvType;

        MyViewHolder(View itemView) {
            super(itemView);
            tvType = (TextView) itemView.findViewById(R.id.tv_type);
        }
    }
}
