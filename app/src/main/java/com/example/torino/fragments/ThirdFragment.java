package com.example.torino.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.torino.R;
import com.example.torino.datos.Usuario;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private EditText edit_text_correo, edit_text_nickname;
    String correo, nickname;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    String TAG = "ThirdFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);

    }
    Button guardar;
    private EditText campoEmail;
    private EditText campoNickname;
    @Override
    public void onStart() {
        super.onStart();
        Usuario usuario = Usuario.getUsuarioLogueado();
        correo = usuario.getMail();
        nickname = usuario.getNickname();
        Log.i(TAG, "CORREO: "+correo);
        Log.i(TAG, "NICKNAME: "+nickname);
        edit_text_correo = (EditText) getView().findViewById(R.id.edit_text_correo);
        edit_text_correo.setText(correo);
        edit_text_nickname = (EditText) getView().findViewById(R.id.edit_text_nickname);
        edit_text_nickname.setText(nickname);


        guardar = getView().findViewById(R.id.button_guardar_cambios);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = Usuario.getIndexUsuario(Usuario.getUsuarioLogueado());
                if (index != -1) {
                    Usuario.usuarios.get(index).setMail(edit_text_correo.getText().toString());
                    Usuario.usuarios.get(index).setNickname(edit_text_nickname.getText().toString());
                    casoExitoso();
                }else{
                    casoNull();
                }


            }
        });

    }
    public void casoExitoso() {
        Toast.makeText(getActivity().getApplicationContext(), "Perfil actualizado", Toast.LENGTH_LONG)
                .show();
    }
    public void casoNull() {
        Toast.makeText(getActivity().getApplicationContext(), "Ha ocurrido un error inesperado", Toast.LENGTH_LONG)
                .show();
    }
}