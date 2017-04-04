package com.example.macadoshus.quizer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<CardInfo> listItems;
    private Context mContext;

    public CardAdapter(List<CardInfo> listItems, Context mContext){
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CardInfo items = listItems.get(position);
        holder.title.setText(items.getTitle());

        holder.title.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), EditCards.class);
                i.putExtra("Card_Title", items.getTitle());
                i.putExtra("position", position);
                v.getContext().startActivity(i);
            }

        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;

        public ViewHolder(View itemView){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.cardtitle);
        }
    }


}
