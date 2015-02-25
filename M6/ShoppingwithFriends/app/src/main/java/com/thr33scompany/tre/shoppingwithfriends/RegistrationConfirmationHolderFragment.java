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
 * Controls onClickListeners for RegistrationConfirmationHolderFragment: fragment_registration
 */
public class RegistrationConfirmationHolderFragment extends Fragment implements View.OnClickListener {
    private Button btnLogin;
    public RegistrationConfirmationHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //PLACEHOLDER CLASS FOR CONFIRMATION
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_confirmation_registration, container, false);
        btnLogin = (Button) view.findViewById(R.id.btnRegistrationLogin);
        btnLogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnRegistrationLogin:
                //Log.d("Karl", "Hi Karl");
                ((MainActivity)getActivity()).showLoginFragment();

        }
    }
}