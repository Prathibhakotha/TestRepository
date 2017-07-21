package com.example.prathibha.testproject.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prathibha.testproject.R;
import com.example.prathibha.testproject.adapters.VideoFragmentAdapter;
import com.example.prathibha.testproject.model.Actor;

import java.util.ArrayList;


public class VideosFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Actor> actorsList;
    private VideoFragmentAdapter mAdapter;
    // TODO: Rename parameter arguments, choose names that match

    private String[] titleArray = new String[] {"Can't Get You Out of My Head", "A Beautiful Lie", "Doors Down, Away from the Sun", "Shadows And Tall Trees", "Black Black Heart", "Avant Garden"};
    private String[] dateArray = new String[] {"20 MINUTES AGO", "25 MINUTES AGO", "1 HOUR AGO", "12 HOURS AGO", "18 HOURS AGO", "20 HOURS AGO"};
    private int[] imageResId = { R.drawable.pager_image1, R.drawable.pager_image2, R.drawable.pager_image3, R.drawable.pager_image4, R.drawable.pager_image5, R.drawable.pager_image6};

    public VideosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_videos, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        actorsList = new ArrayList<Actor>();
        for(int i = 0; i<titleArray.length;i++){
            Actor actor = new Actor();
            actor.title = titleArray[i];
            actor.duration = dateArray[i];
            actor.imageId = imageResId[i];
            actorsList.add(actor);
        }
        mAdapter = new VideoFragmentAdapter(getActivity(), actorsList);
        recyclerView.setAdapter(mAdapter);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
