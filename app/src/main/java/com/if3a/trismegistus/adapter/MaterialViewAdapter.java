package com.if3a.trismegistus.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.if3a.trismegistus.R;
import com.if3a.trismegistus.activity.DetailMaterialActivity;
import com.if3a.trismegistus.model.material.ModelMaterial;

import java.util.ArrayList;
import java.util.List;

public class
MaterialViewAdapter extends RecyclerView.Adapter<MaterialViewAdapter.ViewHolder>{

    private List<ModelMaterial> materialList = new ArrayList<>();

    public MaterialViewAdapter(List<ModelMaterial> materialList){
        this.materialList = materialList;
    }
    @NonNull
    @Override
    public MaterialViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_item, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialViewAdapter.ViewHolder holder, int position) {
        ModelMaterial MM = materialList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(MM.getIcon())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.ivMaterial);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idMaterial = Integer.toString(MM.getId());

                Intent intent = new Intent(holder.itemView.getContext(), DetailMaterialActivity.class);
                intent.putExtra("varIdMaterial", idMaterial);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return materialList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivMaterial;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMaterial = itemView.findViewById(R.id.iv_material);
        }
    }
}
