package com.karla.control_venta;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;
import android.widget.Toast;

import com.karla.control_venta.Tablas.Abono;
import com.karla.control_venta.Tablas.Cliente;
import com.karla.control_venta.Tablas.Distribuidor;
import com.karla.control_venta.Tablas.Venta;

import java.util.ArrayList;

public class Administrador extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;
    FloatingActionButton btnFlotante;

    public static ArrayList<Cliente> lista_Clientes= new ArrayList<>();
    public static ArrayList<Distribuidor> lista_Distribuidores= new ArrayList<>();
    public static ArrayList<Venta> lista_Ventas= new ArrayList<>();
    public static ArrayList<Abono> lista_Abono= new ArrayList<>();

    Dialog Dialogo_Agregar_Cliente, Dialogo_Agregar_Distribuidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager (viewPager);
        btnFlotante= findViewById(R.id.fab_admin);

        btnFlotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(viewPager.getCurrentItem()){
                    case 0:
                        try {
                            Dialogo_Agregar_Cliente = new Dialog(Administrador.this);
                            Dialogo_Agregar_Cliente.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            Dialogo_Agregar_Cliente.setContentView(R.layout.registrar_cliente);
                            Dialogo_Agregar_Cliente.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                            lp.copyFrom(Dialogo_Agregar_Cliente.getWindow().getAttributes());
                            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                            Dialogo_Agregar_Cliente.getWindow().setAttributes(lp);
                            Dialogo_Agregar_Cliente.setCancelable(true);
                            Dialogo_Agregar_Cliente.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //style id
                            Dialogo_Agregar_Cliente.show();
                        }catch (Exception e){}
                        break;
                    case 1:
                        try {
                            Dialogo_Agregar_Distribuidor = new Dialog(Administrador.this);
                            Dialogo_Agregar_Distribuidor.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            Dialogo_Agregar_Distribuidor.setContentView(R.layout.registrar_distribuidor);
                            Dialogo_Agregar_Distribuidor.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                            lp.copyFrom(Dialogo_Agregar_Distribuidor.getWindow().getAttributes());
                            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                            Dialogo_Agregar_Distribuidor.getWindow().setAttributes(lp);
                            Dialogo_Agregar_Distribuidor.setCancelable(true);
                            Dialogo_Agregar_Distribuidor.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //style id
                            Dialogo_Agregar_Distribuidor.show();
                            break;
                        }catch (Exception e){}
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @SuppressLint("RestrictedApi")
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        btnFlotante.setVisibility(View.VISIBLE);
                        btnFlotante.setImageDrawable(getResources().getDrawable(R.drawable.ic_agregar_cliente));
                        break;
                    case 1:
                        btnFlotante.setVisibility(View.VISIBLE);
                        btnFlotante.setImageDrawable(getResources().getDrawable(R.drawable.ic_agregar_distribuidor));
                        break;
                    case 2:
                        btnFlotante.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        @StringRes
        private final int[] TAB_TITLES = new int[]{R.string.tab_admin_1, R.string.tab_admin_2, R.string.tab_admin_3};
        private final Context mContext;

        public SectionsPagerAdapter(Context context, FragmentManager fm) {
            super(fm);
            mContext = context;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mContext.getResources().getString(TAB_TITLES[position]);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Admin_Cliente tab1 = new Admin_Cliente();
                    return tab1;
                case 1:
                    Admin_Distribuidor tab2 = new Admin_Distribuidor();
                    return tab2;
                case 2:
                    Admin_Reportes tab3 = new Admin_Reportes();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 3;
        }
    }
}
