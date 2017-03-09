package com.example.yangxc.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
    private Context mContext;
    private List<Fruit> fruitList;

    public FruitAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();//防止调用不必要的context 占用内存。
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item, parent, false);
        final FruitViewHolder holder = new FruitViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(mContext, FruitActivity.class);
                intent.putExtra(FruitActivity.FRUIT_NAME, fruitList.get(position).getName());
                intent.putExtra(FruitActivity.FRUIT_IMAGE_ID, fruitList.get(position).getImageId());
                mContext.startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.fruit_name.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.fruit_img);

    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    class FruitViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fruit_img;
        TextView fruit_name;

        public FruitViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            fruit_img = (ImageView) itemView.findViewById(R.id.fruit_img);
            fruit_name = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }
}
