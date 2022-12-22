package com.example.polinela_wonderfull;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    CardView cvPangan, cvKebun, cvTektan, cvTernak, cvEkbis, cvPasca;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home, container, false);

        cvPangan = v.findViewById(R.id.cvPangan);
        cvPangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getActivity(), PanganActivity.class);
                startActivity(a);
            }
        });

        cvKebun = v.findViewById(R.id.cvKebun);
        cvKebun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getActivity(), KebunActivity.class);
                startActivity(b);
            }
        });

        cvTektan = v.findViewById(R.id.cvTektan);
        cvTektan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getActivity(), TektanActivity.class);
                startActivity(c);
            }
        });

        cvTernak = v.findViewById(R.id.cvTernak);
        cvTernak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(getActivity(), TernakActivity.class);
                startActivity(d);
            }
        });

        cvEkbis = v.findViewById(R.id.cvEkbis);
        cvEkbis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(getActivity(), EkbisActivity.class);
                startActivity(e);
            }
        });

        cvPasca = v.findViewById(R.id.cvPasca);
        cvPasca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f = new Intent(getActivity(), PascaActivity.class);
                startActivity(f);
            }
        });


        return v;
    }

}