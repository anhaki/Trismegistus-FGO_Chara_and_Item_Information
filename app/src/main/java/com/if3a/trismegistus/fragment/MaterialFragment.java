package com.if3a.trismegistus.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.if3a.trismegistus.api.APIRequestData;
import com.if3a.trismegistus.adapter.MaterialViewAdapter;
import com.if3a.trismegistus.model.material.ModelMaterial;
import com.if3a.trismegistus.R;
import com.if3a.trismegistus.api.RetroServer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MaterialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MaterialFragment extends Fragment {

    private RecyclerView rvMaterial;
    private List<ModelMaterial> listMaterial;
    private ProgressBar pbData;
    private MaterialViewAdapter adapterMaterial;
    private LinearLayoutManager linearLayoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MaterialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MaterialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MaterialFragment newInstance(String param1, String param2) {
        MaterialFragment fragment = new MaterialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_material, container, false);

        rvMaterial = view.findViewById(R.id.rv_material);
        pbData = view.findViewById(R.id.pb_data);


        linearLayoutManager = new GridLayoutManager(view.getContext(), 2);
        rvMaterial.setLayoutManager(linearLayoutManager);

        retriveMaterial();

        return view;
    }

    private void retriveMaterial() {
        pbData.setVisibility(View.VISIBLE);

        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<ModelMaterial>> retriveProcess = ardData.getMaterial();
        retriveProcess.enqueue(new Callback<List<ModelMaterial>>() {
            @Override
            public void onResponse(Call<List<ModelMaterial>> call, Response<List<ModelMaterial>> response) {
                listMaterial = response.body();
                adapterMaterial = new MaterialViewAdapter(listMaterial);
                rvMaterial.setAdapter(adapterMaterial);
                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<ModelMaterial>> call, Throwable t) {
                pbData.setVisibility(View.INVISIBLE);

            }
        });
    }
}