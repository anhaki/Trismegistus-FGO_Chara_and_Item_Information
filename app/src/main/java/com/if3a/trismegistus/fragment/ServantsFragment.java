package com.if3a.trismegistus.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.if3a.trismegistus.api.APIRequestData;
import com.if3a.trismegistus.model.servant.ModelServants;
import com.if3a.trismegistus.R;
import com.if3a.trismegistus.api.RetroServer;
import com.if3a.trismegistus.adapter.ServantViewAdapter;
import com.if3a.trismegistus.activity.about;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServantsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServantsFragment extends Fragment {

    private RecyclerView rvServants;
    private List<ModelServants> listServants;
    private ServantViewAdapter adapterServants;
    private LinearLayoutManager linearLayoutManager;
    private Button btnClass, btnSaber, btnArcher, btnLancer, btnRider, btnAssassin, btnCaster
            ,btnBerserker, btnRuler, btnAvenger, btnMoonCancer, btnForeigner, btnAlterEgo, btnAllClass, btnClose;
    private ImageView ivAboutUs;
    private ProgressBar pbData;
    private ScrollView SVKami;
    private RelativeLayout rlMenuContainer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ServantsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServantsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServantsFragment newInstance(String param1, String param2) {
        ServantsFragment fragment = new ServantsFragment();
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
        View view = inflater.inflate(R.layout.fragment_servants, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvServants = view.findViewById(R.id.rv_servants);

        btnClass = view.findViewById(R.id.btn_class);

        rlMenuContainer = view.findViewById(R.id.rl_menuContainer);

        pbData = view.findViewById(R.id.pb_data);

        btnSaber = view.findViewById(R.id.btn_saber);
        btnArcher = view.findViewById(R.id.btn_archer);
        btnLancer = view.findViewById(R.id.btn_lancer);
        btnRider = view.findViewById(R.id.btn_rider);
        btnCaster = view.findViewById(R.id.btn_caster);
        btnAssassin = view.findViewById(R.id.btn_assassin);
        btnBerserker = view.findViewById(R.id.btn_berserker);
        btnRuler = view.findViewById(R.id.btn_ruler);
        btnAvenger = view.findViewById(R.id.btn_avenger);
        btnMoonCancer = view.findViewById(R.id.btn_moonCancer);
        btnForeigner = view.findViewById(R.id.btn_foreigner);
        btnAlterEgo = view.findViewById(R.id.btn_alterEgo);
        btnAllClass = view.findViewById(R.id.btn_allClass);

        ivAboutUs = view.findViewById(R.id.ke_aboutUs);

        SVKami = view.findViewById(R.id.SV_Kami);

        btnClose = view.findViewById(R.id.btn_close);

        btnClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlMenuContainer.setVisibility(View.VISIBLE);
            }
        });


        btnSaber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("saber");
                btnClass.setText("Saber");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnArcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("archer");
                btnClass.setText("Archer");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnLancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("lancer");
                btnClass.setText("Lancer");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("rider");
                btnClass.setText("Rider");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnCaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("caster");
                btnClass.setText("Caster");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnAssassin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("assassin");
                btnClass.setText("Assassin");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnBerserker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("berserker");
                btnClass.setText("Berserker");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnRuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("ruler");
                btnClass.setText("Ruler");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnAvenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("avenger");
                btnClass.setText("Avenger");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnMoonCancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("moonCancer");
                btnClass.setText("Moon Cancer");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnForeigner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("foreigner");
                btnClass.setText("Foreigner");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnAlterEgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServantClass("alterEgo");
                btnClass.setText("Alter Ego");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        btnAllClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retriveServants();
                btnClass.setText("All Class");
                rlMenuContainer.setVisibility(View.GONE);
            }
        });


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlMenuContainer.setVisibility(View.GONE);
            }
        });

        ivAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), about.class);
                getContext().startActivity(intent);
            }
        });


        linearLayoutManager = new LinearLayoutManager(getContext());
        //rvServants.setHasFixedSize(true);
        rvServants.setLayoutManager(linearLayoutManager);
        retriveServants();

    }

    private void retriveServants() {
        rvServants.setVisibility(View.INVISIBLE);
        pbData.setVisibility(View.VISIBLE);

        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<ModelServants>> retriveProcess = ardData.getServants();
        retriveProcess.enqueue(new Callback<List<ModelServants>>() {
            @Override
            public void onResponse(Call<List<ModelServants>> call, Response<List<ModelServants>> response) {
                listServants = response.body();
                adapterServants = new ServantViewAdapter(listServants, getContext());
                rvServants.setAdapter(adapterServants);
                pbData.setVisibility(View.INVISIBLE);
                rvServants.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<List<ModelServants>> call, Throwable t) {
                Toast.makeText(getContext(),
                        "Gagal menghubungi server : " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
                Log.d("CEK : ", t.getMessage());
                pbData.setVisibility(View.INVISIBLE);
                rvServants.setVisibility(View.VISIBLE);
                SVKami.fullScroll(ScrollView.FOCUS_UP);
            }
        });
    }

    private void retriveServantClass(String className){
        rvServants.setVisibility(View.INVISIBLE);
        pbData.setVisibility(View.VISIBLE);

        APIRequestData ardData = RetroServer.getRetrofit().create(APIRequestData.class);
        Call<List<ModelServants>> retriveProcess = ardData.getServantByClass(className);

        retriveProcess.enqueue(new Callback<List<ModelServants>>() {
            @Override
            public void onResponse(Call<List<ModelServants>> call, Response<List<ModelServants>> response) {
                listServants = response.body();
                adapterServants = new ServantViewAdapter(listServants, getContext());
                rvServants.setAdapter(adapterServants);
                pbData.setVisibility(View.INVISIBLE);
                rvServants.setVisibility(View.VISIBLE);
                SVKami.fullScroll(ScrollView.FOCUS_UP);
            }

            @Override
            public void onFailure(Call<List<ModelServants>> call, Throwable t) {
                pbData.setVisibility(View.INVISIBLE);
            }
        });
    }

}