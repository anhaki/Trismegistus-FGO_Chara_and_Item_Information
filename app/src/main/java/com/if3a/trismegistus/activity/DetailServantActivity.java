package com.if3a.trismegistus.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.if3a.trismegistus.api.APIRequestData;
import com.if3a.trismegistus.model.servant.ModelServants;
import com.if3a.trismegistus.R;
import com.if3a.trismegistus.api.RetroServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailServantActivity extends AppCompatActivity {

    private TextView tvNameDetail, tvBaseHp, tvBaseAtk, tvLore,
            tvSkill1, tvSkill2, tvSkill3,
            tvDetailSkill1, tvDetailSkill2, tvDetailSkill3,
            tvNpName, tvNpRank, tvNpClass, tvNpType, tvNpCard, tvNpDetail,
            stg1, stg2, stg3, stg4,
            skillNya, nobleNya, tvprofil, tvServantClass;
    private ImageView ivFaceDetail, ivIconSkill1, ivIconSkill2, ivIconSkill3;
    private RelativeLayout rlSkillServant, rlNpServant;
    private LinearLayout llProfil;
    private ActionBar judulBar;
    private RatingBar rbServant;
    private ScrollView svProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_servant);

        judulBar = getSupportActionBar();
        judulBar.hide();

        Intent intent = getIntent();
        String idServant = intent.getStringExtra("varId");

        rbServant = findViewById(R.id.tv_detailServantRarity);
        tvNameDetail = findViewById(R.id.tv_detailServantName);
        tvServantClass = findViewById(R.id.tv_DetailServantClass);
        tvBaseHp = findViewById(R.id.tv_detailServantBaseHp);
        tvBaseAtk = findViewById(R.id.tv_detailServantBaseAtk);

        tvLore = findViewById(R.id.tv_detailServantLore);

        tvSkill1 = findViewById(R.id.tv_skill1);
        tvSkill2 = findViewById(R.id.tv_skill2);
        tvSkill3 = findViewById(R.id.tv_skill3);
        tvDetailSkill1 = findViewById(R.id.tv_detailSkill1);
        tvDetailSkill2 = findViewById(R.id.tv_detailSkill2);
        tvDetailSkill3 = findViewById(R.id.tv_detailSkill3);

        tvNpName = findViewById(R.id.tv_npName);
        tvNpRank = findViewById(R.id.tv_npRank);
        tvNpClass = findViewById(R.id.tv_npClass);
        tvNpType = findViewById(R.id.tv_npType);
        tvNpCard = findViewById(R.id.tv_npCard);
        tvNpDetail = findViewById(R.id.tv_npDetail);

        rlSkillServant = findViewById(R.id.rl_skillServant);
        rlNpServant = findViewById(R.id.rl_npServant);

        ivFaceDetail = findViewById(R.id.iv_detailServantFace);

        ivIconSkill1 = findViewById(R.id.iv_iconSkill1);
        ivIconSkill2 = findViewById(R.id.iv_iconSkill2);
        ivIconSkill3 = findViewById(R.id.iv_iconSkill3);

        stg1 = findViewById(R.id.tv_stg1);
        stg2 = findViewById(R.id.tv_stg2);
        stg3 = findViewById(R.id.tv_stg3);
        stg4 = findViewById(R.id.tv_stg4);

        skillNya = findViewById(R.id.tv_skillNya);
        nobleNya = findViewById(R.id.tv_nobleNya);

        llProfil = findViewById(R.id.ll_profil);
        tvprofil = findViewById(R.id.tv_profil);
        svProfil = findViewById(R.id.sv_profil);

        skillNya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlSkillServant.setVisibility(View.VISIBLE);
                rlNpServant.setVisibility(View.GONE);

                skillNya.setBackgroundResource(R.drawable.stages1_selected);
                skillNya.setTextColor(Color.WHITE);

                nobleNya.setBackgroundResource(R.drawable.stages4);
                nobleNya.setTextColor(Color.BLACK);
            }
        });

        nobleNya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlSkillServant.setVisibility(View.GONE);
                rlNpServant.setVisibility(View.VISIBLE);

                skillNya.setBackgroundResource(R.drawable.stages1);
                skillNya.setTextColor(Color.BLACK);

                nobleNya.setBackgroundResource(R.drawable.stages4_selected);
                nobleNya.setTextColor(Color.WHITE);
            }
        });

        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<ModelServants> retriveDetail = ardData.getDetailServantNice(idServant);
        retriveDetail.enqueue(new Callback<ModelServants>() {
            @Override
            public void onResponse(Call<ModelServants> call, Response<ModelServants> response) {
                rbServant.setNumStars(response.body().getRarity());
                rbServant.setRating(response.body().getRarity());

                rbServant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

                Glide.with(DetailServantActivity.this)
                        .load(response.body().getextraAssets().getcharaGraph().getascension().getSatu())
                        .into(ivFaceDetail);


                stg1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ivFaceDetail.setVisibility(View.VISIBLE);
                        svProfil.setVisibility(View.GONE);

                        Glide.with(DetailServantActivity.this)
                                .load(response.body().getextraAssets().getcharaGraph().getascension().getSatu())
                                .into(ivFaceDetail);
                        stg1.setBackgroundResource(R.drawable.stages1_selected);
                        stg1.setTextColor(Color.WHITE);

                        stg2.setBackgroundResource(R.drawable.stages2);
                        stg2.setTextColor(Color.BLACK);

                        stg3.setBackgroundResource(R.drawable.stages3);
                        stg3.setTextColor(Color.BLACK);

                        stg4.setBackgroundResource(R.drawable.stages4);
                        stg4.setTextColor(Color.BLACK);

                        llProfil.setBackgroundResource(R.drawable.profile);
                        tvprofil.setTextColor(Color.BLACK);
                    }
                });

                stg2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ivFaceDetail.setVisibility(View.VISIBLE);
                        svProfil.setVisibility(View.GONE);

                        Glide.with(DetailServantActivity.this)
                                .load(response.body().getextraAssets().getcharaGraph().getascension().getDua())
                                .into(ivFaceDetail);
                        stg1.setBackgroundResource(R.drawable.stages1);
                        stg1.setTextColor(Color.BLACK);

                        stg2.setBackgroundResource(R.drawable.stages2_selected);
                        stg2.setTextColor(Color.WHITE);

                        stg3.setBackgroundResource(R.drawable.stages3);
                        stg3.setTextColor(Color.BLACK);

                        stg4.setBackgroundResource(R.drawable.stages4);
                        stg4.setTextColor(Color.BLACK);

                        llProfil.setBackgroundResource(R.drawable.profile);
                        tvprofil.setTextColor(Color.BLACK);
                    }
                });

                stg3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ivFaceDetail.setVisibility(View.VISIBLE);
                        svProfil.setVisibility(View.GONE);

                        Glide.with(DetailServantActivity.this)
                                .load(response.body().getextraAssets().getcharaGraph().getascension().getTiga())
                                .into(ivFaceDetail);
                        stg1.setBackgroundResource(R.drawable.stages1);
                        stg1.setTextColor(Color.BLACK);

                        stg2.setBackgroundResource(R.drawable.stages2);
                        stg2.setTextColor(Color.BLACK);

                        stg3.setBackgroundResource(R.drawable.stages3_selected);
                        stg3.setTextColor(Color.WHITE);

                        stg4.setBackgroundResource(R.drawable.stages4);
                        stg4.setTextColor(Color.BLACK);

                        llProfil.setBackgroundResource(R.drawable.profile);
                        tvprofil.setTextColor(Color.BLACK);
                    }
                });

                stg4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ivFaceDetail.setVisibility(View.VISIBLE);
                        svProfil.setVisibility(View.GONE);

                        Glide.with(DetailServantActivity.this)
                                .load(response.body().getextraAssets().getcharaGraph().getascension().getEmpat())
                                .into(ivFaceDetail);
                        stg1.setBackgroundResource(R.drawable.stages1);
                        stg1.setTextColor(Color.BLACK);

                        stg2.setBackgroundResource(R.drawable.stages2);
                        stg2.setTextColor(Color.BLACK);

                        stg3.setBackgroundResource(R.drawable.stages3);
                        stg3.setTextColor(Color.BLACK);

                        stg4.setBackgroundResource(R.drawable.stages4_selected);
                        stg4.setTextColor(Color.WHITE);

                        llProfil.setBackgroundResource(R.drawable.profile);
                        tvprofil.setTextColor(Color.BLACK);
                    }
                });

                llProfil.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ivFaceDetail.setVisibility(View.GONE);
                        svProfil.setVisibility(View.VISIBLE);


                        Glide.with(DetailServantActivity.this)
                                .load(response.body().getextraAssets().getcharaGraph().getascension().getEmpat())
                                .into(ivFaceDetail);
                        stg1.setBackgroundResource(R.drawable.stages1);
                        stg1.setTextColor(Color.BLACK);

                        stg2.setBackgroundResource(R.drawable.stages2);
                        stg2.setTextColor(Color.BLACK);

                        stg3.setBackgroundResource(R.drawable.stages3);
                        stg3.setTextColor(Color.BLACK);

                        stg4.setBackgroundResource(R.drawable.stages4);
                        stg4.setTextColor(Color.BLACK);

                        llProfil.setBackgroundResource(R.drawable.profile_selected);
                        tvprofil.setTextColor(Color.WHITE);
                    }
                });

                tvNameDetail.setText(response.body().getName());
                switch (response.body().getClassName()){
                    case("saber"):
                        tvServantClass.setText("Class: Saber");
                        break;
                    case("archer"):
                        tvServantClass.setText("Class: Archer");
                        break;
                    case("lancer"):
                        tvServantClass.setText("Class: Lancer");
                        break;
                    case("rider"):
                        tvServantClass.setText("Class: Rider");
                        break;
                    case("assassin"):
                        tvServantClass.setText("Class: Assassin");
                        break;
                    case("caster"):
                        tvServantClass.setText("Class: Caster");
                        break;
                    case("berserker"):
                        tvServantClass.setText("Class: Berserker");
                        break;
                    case("ruler"):
                        tvServantClass.setText("Class: Ruler");
                        break;
                    case("avenger"):
                        tvServantClass.setText("Class: Avenger");
                        break;
                    case("moonCancer"):
                        tvServantClass.setText("Class: Moon Cancer");
                        break;
                    case("alterEgo"):
                        tvServantClass.setText("Class: Alter Ego");
                        break;
                    case("foreigner"):
                        tvServantClass.setText("Class: Foreigner");
                        break;
                    case("shielder"):
                        tvServantClass.setText("Class: Shielder");
                        break;
                    case("grandCaster"):
                        tvServantClass.setText("Class: Grand Caster");
                        break;
                    case("beastI"):
                        tvServantClass.setText("Class: Beast I");
                        break;
                    case("beastII"):
                        tvServantClass.setText("Class: Beast II");
                        break;
                    case("beastIIIR"):
                        tvServantClass.setText("Class: Beast III/R");
                        break;
                    case("beastIIIL"):
                        tvServantClass.setText("Class: Beast III/L");
                        break;
                }
                if(response.body().getHpBase() < 1000){
                    tvBaseHp.setText("Hp :  " + Integer.toString(response.body().getHpBase()) + "/" + Integer.toString(response.body().getHpMax()));
                }else{
                    tvBaseHp.setText("Hp : " + Integer.toString(response.body().getHpBase()) + "/" + Integer.toString(response.body().getHpMax()));
                }
                if(response.body().getAtkBase() < 1000){
                    tvBaseAtk.setText("Atk :  " + Integer.toString(response.body().getAtkBase()) + "/" + Integer.toString(response.body().getAtkMax()));
                }else{
                    tvBaseAtk.setText("Atk : " + Integer.toString(response.body().getAtkBase()) + "/" + Integer.toString(response.body().getAtkMax()));
                }

                tvLore.setText(response.body().getProfile().getComments().get(0).getComment());

                if(response.body().getType().equals("enemyCollectionDetail")){
                    tvDetailSkill1.setText("No Data");
                    tvDetailSkill2.setText("No Data");
                    tvDetailSkill3.setText("No Data");

                    tvNpName.setText("No Data");
                    tvNpRank.setText("Rank\t\t\t\t\t: No Data");
                    tvNpClass.setText("Class\t\t\t\t\t: No Data");
                    tvNpType.setText("NP Type\t: No Data");
                    tvNpCard.setText("NP Card\t: No Data");
                    tvNpDetail.setText("No Data");
                }else{
                    tvSkill1.setText(response.body().getSkills().get(0).getName());
                    Glide.with(DetailServantActivity.this)
                            .load(response.body().getSkills().get(0).getIcon())
                            .into(ivIconSkill1);
                    tvDetailSkill1.setText(response.body().getSkills().get(0).getDetail());

                    tvSkill2.setText(response.body().getSkills().get(1).getName());
                    Glide.with(DetailServantActivity.this)
                            .load(response.body().getSkills().get(1).getIcon())
                            .into(ivIconSkill2);
                    tvDetailSkill2.setText(response.body().getSkills().get(1).getDetail());

                    tvSkill3.setText(response.body().getSkills().get(2).getName());
                    Glide.with(DetailServantActivity.this)
                            .load(response.body().getSkills().get(2).getIcon())
                            .into(ivIconSkill3);
                    tvDetailSkill3.setText(response.body().getSkills().get(2).getDetail());

                    tvNpName.setText(response.body().getNoblePhantasms().get(0).getName());
                    tvNpRank.setText("Rank\t\t\t\t\t: " + response.body().getNoblePhantasms().get(0).getRank());
                    tvNpClass.setText("Class\t\t\t\t\t: " + response.body().getNoblePhantasms().get(0).getType());
                    switch (response.body().getNoblePhantasms().get(0).getEffectFlags().get(0)){
                        case ("attackEnemyAll"):
                            tvNpType.setText("NP Type\t: AOE Damage");
                            break;
                        case ("attackEnemyOne"):
                            tvNpType.setText("NP Type\t: Single-Target Damage");
                            break;
                        case ("support"):
                            tvNpType.setText("NP Type\t: Support");
                            break;
                    }
                    tvNpCard.setText("NP Card\t: " + response.body().getNoblePhantasms().get(0).getCard());
                    tvNpDetail.setText(response.body().getNoblePhantasms().get(0).getDetail());
                }
            }

            @Override
            public void onFailure(Call<ModelServants> call, Throwable t) {

            }
        });
    }
}