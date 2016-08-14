package com.example.kidcats.progresslayout;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.progresslayout.OnProgressCompleteListener;
import com.example.progresslayout.ProgressLayout;
import com.example.progresslayout.ReadyAttrs;

import java.util.List;

/**
 * Created by kidcats on 2016/8/14.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private OnItemClickListener itemClickListener;
    private MyViewHolder viewHolder;
    private List<String> datas;

    public MyAdapter(List<String> datas, Context context){
        this.datas=datas;
        this.context=context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.itemClickListener=onItemClickListener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false);
        viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        viewHolder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public interface OnItemClickListener{
        void OnItemClickListener(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, OnProgressCompleteListener {
        private TextView textView;
        private ProgressLayout progressLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.text);
            progressLayout= (ProgressLayout) itemView.findViewById(R.id.progresslayout);
            ReadyAttrs attrs=new ReadyAttrs();
            attrs.setMaxprogress(100)
                    .setAnimationdurction(7000)
                    .setProgress(30)
                    .setPaintAlpha(100)
                    .setReacolor(Color.GRAY);
            progressLayout.setReadyAttrs(attrs);
            progressLayout.setOnProgressCompleteListener(this);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener!=null){
                itemClickListener.OnItemClickListener(v,getPosition());
                progressLayout.startAnimator(progressLayout);
            }
        }

        @Override
        public void OnProgressListener(int progress) {
            Log.i("adapter",progress+" ");
        }

        @Override
        public void OnCompleteListener() {
            Log.i("adapter","进度完成 ");

        }
    }
}


