package com.arcore.first.arfirst;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {
    private static final String TAG = "ModelAdapter";
        Context context;
        private int[] model;
        private String[] modelSFB;


    public ModelAdapter(Context context, int[] model , String[] modelSFB) {
        this.context = context;
        this.model = model;
        this.modelSFB = modelSFB;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.i(TAG, "onCreateViewHolder: it is called");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recylerview_images ,viewGroup , false);
        return new ViewHolder(view);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        Log.i(TAG, "onBindViewHolder: it is called");
        viewHolder.imageView.setImageResource(model[position]);

        viewHolder.cardView.setOnTouchListener((v, event) -> {
            ((MainActivity) context).addObject(Uri.parse(String.valueOf(modelSFB[position])));
            return true;
        });
    }

    public int[] getModels() {
        return model;
    }

    @Override
    public int getItemCount()
    {
        return model.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        CardView cardView;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview_model);
            cardView = itemView.findViewById(R.id.cardview_image);
        }
    }
}
