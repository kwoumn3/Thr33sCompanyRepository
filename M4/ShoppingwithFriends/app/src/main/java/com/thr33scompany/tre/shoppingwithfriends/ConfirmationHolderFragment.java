package com.thr33scompany.tre.shoppingwithfriends;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Tre' on 1/31/2015.
 * Holds the OnClickListeners for he ConfirmationFragment: fragment_confirmation
 */
public class ConfirmationHolderFragment extends Fragment implements View.OnClickListener {
    private Button btnConfirmOK;
    public ConfirmationHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_confirmation, container, false);
        btnConfirmOK = (Button) view.findViewById(R.id.btnConfirmOK);
        btnConfirmOK.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnConfirmOK:
                //Log.d("Karl", "Hi Karl");
                ((MainActivity)getActivity()).showLoggedinFragment();

        }
    }
}