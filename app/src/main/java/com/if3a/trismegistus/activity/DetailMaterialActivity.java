package com.if3a.trismegistus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.if3a.trismegistus.api.APIRequestData;
import com.if3a.trismegistus.model.material.ModelMaterial;
import com.if3a.trismegistus.R;
import com.if3a.trismegistus.api.RetroServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMaterialActivity extends AppCompatActivity {

    private TextView tvNameMaterial, tvDetailMaterial;
    private ImageView ivIconMaterial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_material);

         getSupportActionBar().hide();


        Intent intent = getIntent();
        String idMaterial = intent.getStringExtra("varIdMaterial");

        tvNameMaterial = findViewById(R.id.tv_materialName);
        tvDetailMaterial = findViewById(R.id.tv_materialDetail);
        ivIconMaterial = findViewById(R.id.iv_materialIcon);

        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<ModelMaterial> retriveMaterial = ardData.getDetailMaterial(idMaterial);
        retriveMaterial.enqueue(new Callback<ModelMaterial>() {
            @Override
            public void onResponse(Call<ModelMaterial> call, Response<ModelMaterial> response) {
                tvNameMaterial.setText(response.body().getName());
                tvDetailMaterial.setText(response.body().getDetail());
                Glide.with(DetailMaterialActivity.this).load(response.body().getIcon()).into(ivIconMaterial);
            }

            @Override
            public void onFailure(Call<ModelMaterial> call, Throwable t) {

            }
        });
    }
}