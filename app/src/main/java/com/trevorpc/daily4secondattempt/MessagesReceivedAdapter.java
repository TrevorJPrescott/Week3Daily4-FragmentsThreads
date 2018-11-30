package com.trevorpc.daily4secondattempt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MessagesReceivedAdapter extends RecyclerView.Adapter<MessagesReceivedAdapter.ViewHolder> {
    ArrayList<String> msgReceivedList = new ArrayList<>();
    Context context;

    public MessagesReceivedAdapter(ArrayList<String> msgReceivedList, Context context) {
        this.msgReceivedList = msgReceivedList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.activity_message_recieved_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvItemsMessage.setText(msgReceivedList.get(i));
    }

    @Override
    public int getItemCount() {
        return msgReceivedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemsMessage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemsMessage = itemView.findViewById(R.id.tvItemsMessage);
        }
    }

    public void getNewMsg(String msg) {
        msgReceivedList.add(msg);
        notifyDataSetChanged();
    }




}
