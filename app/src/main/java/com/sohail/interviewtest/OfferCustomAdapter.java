package com.sohail.interviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class OfferCustomAdapter extends RecyclerView.Adapter<OfferCustomAdapter.ViewHolder> {

    Context context;
    ArrayList<String> arrayList = new ArrayList<String>();

    public OfferCustomAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public OfferCustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_list_item, parent, false);
        return new OfferCustomAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferCustomAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(arrayList.get(position))
                .centerCrop()
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.offerImg);
        }
    }
}
