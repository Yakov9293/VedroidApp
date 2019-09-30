package com.example.assholeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assholeapp.db.CatDb;

import java.util.List;

public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.CatViewHolder> {

    private Context context;
    private List<CatDb> dataCats;

    CatsAdapter(Context context, List<CatDb> data) {
        this.context = context;
        dataCats = data;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cat_item, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        CatDb cat = dataCats.get(position);
        ImageView imageView = holder.catsImage;

        Glide.with(context)
                .load(cat.imageUrl)
                //.placeholder()
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return dataCats.size();
    }

    class CatViewHolder extends RecyclerView.ViewHolder {
        private ImageView catsImage;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            catsImage = itemView.findViewById(R.id.catsImage);
        }
    }
}
