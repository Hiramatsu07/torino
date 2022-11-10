package com.example.torino.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.torino.R;
import com.example.torino.adaptadores.UsuarioAdapter;
import com.example.torino.datos.Usuario;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuscarUsuarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuscarUsuarioFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String TAG = "SecondFragment";

    public BuscarUsuarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuscarUsuarioFragment newInstance(String param1, String param2) {
        BuscarUsuarioFragment fragment = new BuscarUsuarioFragment();
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
        return inflater.inflate(R.layout.fragment_buscar_usuarios, container, false);
    }
    SearchView searchView;
    @Override
    public void onStart() {

        super.onStart();
        Log.i(TAG, "Voy a listar usuarios");
        ListView listView = (ListView) getView().findViewById(R.id.lista_usuarios);
        UsuarioAdapter listAdapter = new UsuarioAdapter(getActivity(), Usuario.usuarios);
        listView.setAdapter(listAdapter);
        searchView = getView().findViewById(R.id.search_bar);

        Log.i(TAG, "Voy a poner un query text listener: ");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Log.i(TAG, "Texto buscar: " + query);
                //adapter.filtrar(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //Log.i(TAG, "Texto buscar: " + query);
                listAdapter.filtrar(query);
                return true;
            }
        });

    }
}