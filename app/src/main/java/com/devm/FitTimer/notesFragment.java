package com.devm.FitTimer;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class notesFragment extends Fragment {



    Button setBtn, timerBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notes, container, false);





        setBtn = v.findViewById(R.id.setsFragBtn);
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setsFragment setsFrag = new setsFragment();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.setReorderingAllowed(true);
                fragmentTransaction.replace(R.id.frameLayout1,setsFrag,null).commit();
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