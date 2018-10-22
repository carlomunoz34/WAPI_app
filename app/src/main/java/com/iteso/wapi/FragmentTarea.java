package com.iteso.wapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.iteso.wapi.beans.Tarea;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentTarea.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentTarea#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTarea extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Tarea> tareas = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView recyclerViewProximas;
    AdapterTarea adapterTarea;
    Button agregar;
    View rootView;


    public FragmentTarea() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTarea.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTarea newInstance(String param1, String param2) {
        FragmentTarea fragment = new FragmentTarea();
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
        rootView = inflater.inflate(R.layout.fragment_tarea, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_tarea_recyclerView_semana_actual);
        recyclerViewProximas = rootView.findViewById(R.id.fragment_tarea_recyclerView_proximas_semanas);
        agregar = rootView.findViewById(R.id.fragment_tarea_agregar);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerViewProximas.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(getActivity());
        recyclerViewProximas.setLayoutManager(mLayoutManager2);

        tareas = new ArrayList<>();
        tareas.add(new Tarea(1, 1, "Leer sobre Teclado Matricial", "Micros", "Mañana", "9:00"));
        tareas.add(new Tarea(2, 1, "Realizar reporte de practica 4", "Micros", "Mañana", "11:55"));

        adapterTarea = new AdapterTarea(4, getActivity(), tareas);
        recyclerView.setAdapter(adapterTarea);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), mLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        tareas = new ArrayList<>();
        tareas.add(new Tarea(3, 2, "Informe de finanzas", "ADSI", "29/10", "7:00"));
        tareas.add(new Tarea(4, 2, "Practica de laboratorio 9", "GBD", "30/10", "13:00"));

        adapterTarea = new AdapterTarea(4, getActivity(), tareas);
        recyclerViewProximas.setAdapter(adapterTarea);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootView.getContext(), ActivityEditarTarea.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
