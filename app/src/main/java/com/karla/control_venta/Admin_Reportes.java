package com.karla.control_venta;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Admin_Reportes extends Fragment {

    RecyclerView rv_Reportes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_admin__reportes, container, false);

        rv_Reportes= view.findViewById(R.id.rv_admin_reportes);

        if(Administrador.lista_Abono.isEmpty() || Administrador.lista_Ventas.isEmpty()){
            rv_Reportes.setVisibility(View.GONE);
        }else{
            rv_Reportes.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
