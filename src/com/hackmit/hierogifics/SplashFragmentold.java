package com.hackmit.hierogifics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SplashFragmentold extends Fragment
{
    public View onCreateView(LayoutInflater inflater, 
            ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash, 
                container, false);
        return view;
    }
}
