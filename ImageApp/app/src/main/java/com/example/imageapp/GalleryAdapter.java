package com.example.imageapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>{
    //Properties
    Context context;
    ArrayList<Integer> galleryList;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {onItemClickListener = listener;}

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ImageView imageV;

        public GalleryViewHolder(View itemView, final OnItemClickListener listener) {
            //Setup
            super(itemView);
            this.itemView = itemView;

            //Connect XML to variable
            imageV = itemView.findViewById(R.id.galleryImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public GalleryAdapter(Context context, ArrayList<Integer> galleryList) {
        this.context = context;
        this.galleryList = galleryList;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_image, parent, false);
        GalleryViewHolder viewHolder = new GalleryViewHolder(itemView, onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        int image = galleryList.get(position);
        System.out.println(image);
        holder.imageV.setImageResource(image);
    }

    @Override
    public int getItemCount() { return galleryList.size(); }
}
