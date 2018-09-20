package com.sohail.interviewtest;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AddCustomAdpater extends RecyclerView.Adapter<AddCustomAdpater.ViewHolder> {


    private Context context;
    ArrayList<String> arrayList = new ArrayList<String>();


    public AddCustomAdpater(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AddCustomAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_rv_item, parent, false);
        return new AddCustomAdpater.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AddCustomAdpater.ViewHolder holder, int position) {
        Glide.with(context)
                .load("https://images.unsplash.com/photo-1512058533999-106ee01bf777?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=beeccb39c4dedcaef39987309ab41231&auto=format&fit=crop&w=946&q=80")
                .centerCrop()
                .into(holder.cardImg);

        holder.titleTxt.setText(arrayList.get(position));


    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cardImg;
        TextView titleTxt;
        CardView card;
        public ViewHolder(View itemView) {
            super(itemView);

            cardImg= itemView.findViewById(R.id.cardImg);
            titleTxt= itemView.findViewById(R.id.titleTxt);
            card=itemView.findViewById(R.id.card);
        }
    }


}

