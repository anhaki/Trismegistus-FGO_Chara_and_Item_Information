package com.if3a.trismegistus.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.if3a.trismegistus.api.APIRequestData;
import com.if3a.trismegistus.adapter.CEViewAdapter;
import com.if3a.trismegistus.model.ce.ModelCE;
import com.if3a.trismegistus.R;
import com.if3a.trismegistus.api.RetroServer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CEFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CEFragment extends Fragment {

    private RecyclerView rvCE;
    private List<ModelCE> listCE;
    private CEViewAdapter adapterCE;
    private ProgressBar pbData;
    private LinearLayoutManager linearLayoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CEFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CEFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CEFragment newInstance(String param1, String param2) {
        CEFragment fragment = new CEFragment();
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
        View view = inflater.inflate(R.layout.fragment_c_e, container, false);

        pbData = view.findViewById(R.id.pb_data);

        rvCE = view.findViewById(R.id.rv_ce);

        linearLayoutManager = new LinearLayoutManager(view.getContext());
        rvCE.setLayoutManager(linearLayoutManager);

        retriveCE();

        return view;
    }

    private void retriveCE() {
        pbData.setVisibility(View.VISIBLE);

        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<ModelCE>> retriveProcess = ardData.getCE();
        retriveProcess.enqueue(new Callback<List<ModelCE>>() {
            @Override
            public void onResponse(Call<List<ModelCE>> call, Response<List<ModelCE>> response) {
                listCE = response.body();
                adapterCE = new CEViewAdapter(listCE);
                rvCE.setAdapter(adapterCE);
                pbData.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<ModelCE>> call, Throwable t) {
                pbData.setVisibility(View.INVISIBLE);
            }
        });
    }
}