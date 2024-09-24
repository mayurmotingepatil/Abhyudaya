package com.mayurmotinge.abhyudaya;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class HomeFragment extends Fragment {

    ImageView ivAddHome;
    PopupMenu popUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ivAddHome = view.findViewById(R.id.ivAddHome);

        ivAddHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popUp = new PopupMenu(getActivity(), ivAddHome);
                popUp.getMenuInflater().inflate(R.menu.add_menu_at_home, popUp.getMenu());

                popUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent i;
                        if (item.getItemId() == R.id.addEvent){
                            i = new Intent(getActivity(), AddEventActivity.class);
                            startActivity(i);
                            return true;
                        } else if (item.getItemId() == R.id.addNotice){
                            i = new Intent(getActivity(), AddNoticeActivity.class);
                            startActivity(i);
                            return true;
                        }
                        return false;
                    }
                });

                popUp.show();
            }

        });




        return view;
    }

}