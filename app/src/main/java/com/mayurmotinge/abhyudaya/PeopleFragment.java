package com.mayurmotinge.abhyudaya;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PeopleFragment extends Fragment {

    ImageView ivAddPeople;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_people, container, false);

        ivAddPeople = view.findViewById(R.id.ivAddPeople);

        ivAddPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditUserInfoActivity.class);
            }
        });







        return view;
    }
}