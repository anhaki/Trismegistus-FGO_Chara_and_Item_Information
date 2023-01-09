package com.if3a.trismegistus.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.if3a.trismegistus.api.APIRequestData;
import com.if3a.trismegistus.model.ce.ModelCE;
import com.if3a.trismegistus.R;
import com.if3a.trismegistus.api.RetroServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailCeActivity extends AppCompatActivity {

    private TextView tvNameDetailCE, tvCeHp, tvCeAtk,
            tvCeLore, tvCeSkillBaseDetail, tvCeSkillMaxDetail, tvCeSkillMaxTitle;
    private ImageView ivFaceDetailCE, ivCeIconSkillBase, ivCeIconSkillMax;
    private Button btnSekil, btnKlos;
    private RelativeLayout rlceDetailBody;
    private RatingBar rbRarityCe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ce);

        getSupportActionBar().hide();

        Intent intent = getIntent();
        String idCE = intent.getStringExtra("varIdCE");

        tvNameDetailCE = findViewById(R.id.tv_ceNameDetail);

        rbRarityCe = findViewById(R.id.tv_detailCeRarity);
        tvCeHp = findViewById(R.id.tv_detailCeBaseHp);
        tvCeAtk = findViewById(R.id.tv_detailCeBaseAtk);

        tvCeLore = findViewById(R.id.tv_ceLore);
        tvCeSkillBaseDetail = findViewById(R.id.tv_ceSkillBaseDetail);
        tvCeSkillMaxDetail = findViewById(R.id.tv_ceSkillMaxDetail);

        ivFaceDetailCE = findViewById(R.id.iv_ceDetailFace);
        ivCeIconSkillBase = findViewById(R.id.iv_ceIconSkillBase);
        ivCeIconSkillMax = findViewById(R.id.iv_ceIconSkillMax);
        tvCeSkillMaxTitle = findViewById(R.id.tv_ceSkillMax);

        rlceDetailBody = findViewById(R.id.rl_ceDetailBody);

        btnSekil = findViewById(R.id.btn_sekil);
        btnKlos = findViewById(R.id.btn_close);

        btnSekil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlceDetailBody.setVisibility(View.VISIBLE);
            }
        });

        btnKlos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlceDetailBody.setVisibility(View.GONE);
            }
        });


        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<ModelCE> retriveFace = ardData.getDetailCE(idCE);
        retriveFace.enqueue(new Callback<ModelCE>() {
            @Override
            public void onResponse(Call<ModelCE> call, Response<ModelCE> response) {
                Glide.with(DetailCeActivity.this).load(response.body().getFace()).into(ivFaceDetailCE);
            }

            @Override
            public void onFailure(Call<ModelCE> call, Throwable t) {

            }
        });

        Call<ModelCE> retriveDetail = ardData.getDetailCENice(idCE);
        retriveDetail.enqueue(new Callback<ModelCE>() {
            @Override
            public void onResponse(Call<ModelCE> call, Response<ModelCE> response) {
                rbRarityCe.setNumStars(response.body().getRarity());
                rbRarityCe.setRating(response.body().getRarity());

                rbRarityCe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });



                tvNameDetailCE.setText(response.body().getName());
                tvCeHp.setText("Hp : " + Integer.toString(response.body().getHpBase()) + "/" + Integer.toString(response.body().getHpMax()));
                tvCeAtk.setText("Atk : " + Integer.toString(response.body().getAtkBase()) + "/" + Integer.toString(response.body().getAtkMax()));

                tvCeLore.setText(response.body().getProfile().getComments().get(0).getComment());

                Glide.with(DetailCeActivity.this).load(response.body().getSkills().get(0).getIcon()).into(ivCeIconSkillBase);
                tvCeSkillBaseDetail.setText(response.body().getSkills().get(0).getDetail());

                if(response.body().getSkills().size() > 1){
                    if(response.body().getSkills().get(1).getNum() == 1){
                        Glide.with(DetailCeActivity.this).load(response.body().getSkills().get(1).getIcon()).into(ivCeIconSkillMax);
                        tvCeSkillMaxDetail.setText(response.body().getSkills().get(1).getDetail());
                    }else {
                        Glide.with(DetailCeActivity.this).load(response.body().getSkills().get(2).getIcon()).into(ivCeIconSkillMax);
                        tvCeSkillMaxDetail.setText(response.body().getSkills().get(2).getDetail());
                    }
                }
                else{
                    ivCeIconSkillMax.setVisibility(View.GONE);
                    tvCeSkillMaxDetail.setVisibility(View.GONE);
                    tvCeSkillMaxTitle.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ModelCE> call, Throwable t) {

            }
        });
    }
}