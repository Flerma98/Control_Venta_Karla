package com.karla.control_venta;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Admin_Cliente extends Fragment {

    RecyclerView rv_Clientes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_admin__cliente, container, false);

        rv_Clientes= view.findViewById(R.id.rv_admin_clientes);

        if(Administrador.lista_Clientes.isEmpty()){
            rv_Clientes.setVisibility(View.GONE);
        }else{
            rv_Clientes.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
