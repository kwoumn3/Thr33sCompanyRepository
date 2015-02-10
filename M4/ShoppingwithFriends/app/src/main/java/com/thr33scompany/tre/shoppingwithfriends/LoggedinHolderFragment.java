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
 * Controls onClickListeners for Loggedin Fragment: fragment_loggedinhome
 */
public class LoggedinHolderFragment extends Fragment implements View.OnClickListener {
    private Button btnLogOut;
    public LoggedinHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_loggedinhome, container, false);
        btnLogOut = (Button) view.findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogOut:
                //Log.d("Karl", "Hi Karl");
                ((MainActivity)getActivity()).showMainFragment();

        }
    }
}