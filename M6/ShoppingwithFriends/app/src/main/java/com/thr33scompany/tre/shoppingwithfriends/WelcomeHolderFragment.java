package com.thr33scompany.tre.shoppingwithfriends;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 * Created by Tre' on 1/30/2015.
 */
public class WelcomeHolderFragment extends Fragment implements OnClickListener {
    private Button btnLogin;
    private Button btnRegistration;
    public WelcomeHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        btnRegistration = (Button) view.findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogin:
                Log.d("Karl","Hi Karl");
                ((MainActivity)getActivity()).showLoginFragment();
                break;
            case R.id.btnRegistration:
                //Log.d("Karl2", "Hi KarlCancel");
                ((MainActivity)getActivity()).showRegistrationFragment();
                break;
        }
    }
}