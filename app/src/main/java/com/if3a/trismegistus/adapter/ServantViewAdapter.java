package com.if3a.trismegistus.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.if3a.trismegistus.R;
import com.if3a.trismegistus.activity.DetailServantActivity;
import com.if3a.trismegistus.activity.about;
import com.if3a.trismegistus.model.servant.ModelServants;

import java.util.ArrayList;
import java.util.List;

public class ServantViewAdapter extends RecyclerView.Adapter<ServantViewAdapter.ViewHolder> {

    private List<ModelServants> servantsList = new ArrayList<>();
    private Context servantContext;

    public ServantViewAdapter(List<ModelServants> servantsList, Context servantContext){
        this.servantsList = servantsList;
        this.servantContext = servantContext;
    }
    @NonNull
    @Override
    public ServantViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(servantContext).inflate(R.layout.servant_item, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ServantViewAdapter.ViewHolder holder, int position) {
        ModelServants MS = servantsList.get(position);

        holder.rbRarity.setRating(MS.getRarity());

        holder.tvName.setText((MS.getName()));
        Glide.with(holder.itemView.getContext())
                .load(MS.getextraAssets().getfaces().getascension().getSatu())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.ivFace);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idServant = MS.getId();
                String id = Integer.toString(idServant);
                Intent intent = new Intent(servantContext, DetailServantActivity.class);
                intent.putExtra("varId", id);
                servantContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return servantsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView ivFace, about;
        private RatingBar rbRarity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            about = itemView.findViewById(R.id.ke_aboutUs);
            rbRarity = itemView.findViewById(R.id.Rb_Rarity);
            tvName = itemView.findViewById(R.id.tv_servantName);
            ivFace = itemView.findViewById(R.id.iv_servantFace);

            //tidak berfungsi apa-apa, hanya agar bintang tidak muncul saat di klik
            rbRarity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }
    }
}
