package com.example.torino.fragments;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.torino.R;
import com.example.torino.activities.CargarFragmentosActivity;
import com.example.torino.activities.ChatsActivity;
import com.example.torino.activities.MensajeDirectoActivity;
import com.example.torino.activities.PublicarActivity;
import com.example.torino.adaptadores.FeedAdapter;
import com.example.torino.datos.Publicacion;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
        View contentView = inflater.inflate(R.layout.fragment_first, container, false);
        return contentView;
    }

    @Override
    public void onStart() {
        super.onStart();
        ListView listView = (ListView) getView().findViewById(R.id.lista_grupos_cercanos);
        FeedAdapter listAdapter = new FeedAdapter(getActivity(), Publicacion.publicacionesInicialesFicticias);
        listView.setAdapter(listAdapter);
        Button publicar = getView().findViewById(R.id.button_publicar);
        publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPublicar = new Intent( view.getContext(), PublicarActivity.class );
                startActivity( intentPublicar );
            }
        });
        ImageView md = (ImageView) getView().findViewById(R.id.imageView2);
        md.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ChatsActivity.class);
                Log.i("Abriendo Chats", "ALGO PASO");
                startActivity(i);
            }
        });
    }
}