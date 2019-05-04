package com.karla.control_venta;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Admin_Distribuidor extends Fragment {

    RecyclerView rv_Distribuidores;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_admin__distribuidor, container, false);

        rv_Distribuidores= view.findViewById(R.id.rv_admin_distribuidores);

        if(Administrador.lista_Distribuidores.isEmpty()){
            rv_Distribuidores.setVisibility(View.GONE);
        }else{
            rv_Distribuidores.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
