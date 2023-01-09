package com.if3a.trismegistus.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.if3a.trismegistus.R;
import com.if3a.trismegistus.activity.DetailCeActivity;
import com.if3a.trismegistus.model.ce.ModelCE;

import java.util.ArrayList;
import java.util.List;

public class CEViewAdapter extends RecyclerView.Adapter<CEViewAdapter.ViewHolder> {

    private List<ModelCE> ceList = new ArrayList<>();

    public CEViewAdapter(List<ModelCE> ceList){
        this.ceList = ceList;
    }
    @NonNull
    @Override
    public CEViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.ce_item, parent, false);
        ViewHolder holder = new ViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CEViewAdapter.ViewHolder holder, int position) {
        ModelCE MC = ceList.get(position);

        holder.tvName.setText((MC.getName()));
        Glide.with(holder.itemView.getContext())
                .load(MC.getFace())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.ivFace);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idCE = Integer.toString(MC.getId());

                Intent intent = new Intent(holder.itemView.getContext(), DetailCeActivity.class);
                intent.putExtra("varIdCE", idCE);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView ivFace;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_ceName);
            ivFace = itemView.findViewById(R.id.iv_ceFace);
        }
    }
}
