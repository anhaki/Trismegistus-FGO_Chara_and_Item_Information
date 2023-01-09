package com.if3a.trismegistus.api;

import com.if3a.trismegistus.model.ce.ModelCE;
import com.if3a.trismegistus.model.material.ModelMaterial;
import com.if3a.trismegistus.model.servant.ModelServants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIRequestData {

    @GET("export/NA/nice_servant.json")
    Call<List<ModelServants>> getServants();

    @GET("nice/NA/servant/{id}?lore=true")
    Call<ModelServants> getDetailServantNice(@Path("id") String idServant);

    @GET("nice/NA/servant/search")
    Call<List<ModelServants>> getServantByClass(@Query("className") String className);

    @GET("export/NA/basic_equip.json")
    Call<List<ModelCE>> getCE();

    @GET("basic/NA/equip/{id}")
    Call<ModelCE> getDetailCE(@Path("id") String idCE);

    @GET("nice/NA/equip/{id}?lore=true")
    Call<ModelCE> getDetailCENice(@Path("id") String idCE);

    @GET("export/NA/nice_item.json")
    Call<List<ModelMaterial>> getMaterial();

    @GET("nice/NA/item/{id}")
    Call<ModelMaterial> getDetailMaterial(@Path("id") String idMaterial);
}
