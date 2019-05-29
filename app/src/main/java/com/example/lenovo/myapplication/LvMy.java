package com.example.lenovo.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class LvMy extends RecyclerView.Adapter<LvMy.ViewHolder> {
    Context context;
    ArrayList<Bean> list;

    public LvMy(Context context, ArrayList<Bean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList<Bean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LvMy.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LvMy.ViewHolder viewHolder, int i) {
        Bean bean = list.get(i);
        viewHolder.tv1.setText(bean.getName());
        viewHolder.tv2.setText(bean.getPaw());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv1;
        private final TextView tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);

        }
    }
}
