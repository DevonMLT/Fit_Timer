package com.devm.FitTimer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class setsFragment extends Fragment {

    Button notesBtn, timerBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sets, container, false);

        notesBtn = v.findViewById(R.id.notesFragBtn);
        notesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notesFragment notesFrag = new notesFragment();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.frameLayout1,notesFrag,null).commit();
                }
            });

        timerBtn = v.findViewById(R.id.timerFragBtn);
        timerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                timerFragment timerFrag = new timerFragment();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.frameLayout1,timerFrag,null).commit();
                }
            });

        return v;
    }
}