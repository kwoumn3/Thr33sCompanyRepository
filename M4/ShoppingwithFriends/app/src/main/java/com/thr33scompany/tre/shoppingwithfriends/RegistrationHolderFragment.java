package com.thr33scompany.tre.shoppingwithfriends;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Tre' on 1/30/2015.
 * Contains OnClickListeners for RegistrationFragment: fragment_regestration
 * Also holds the logic for storing data and registration
 */
public class RegistrationHolderFragment extends Fragment implements OnClickListener {
    private Button btnRegistrationConfirm;
    private Button btnRegistrationCancel;

    private TextView textIncorrect;
    private EditText textInputRegistrationLogin;
    private EditText textInputRegistrationEmail;
    private EditText textInputRegistrationPassword;
    ParseObject userDatabase;
    User currentUser;
    public RegistrationHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_registration, container, false);
        btnRegistrationConfirm = (Button) view.findViewById(R.id.btnRegistrationConfirm);
        btnRegistrationConfirm.setOnClickListener(this);
        btnRegistrationCancel = (Button) view.findViewById(R.id.btnRegistrationCancel);
        btnRegistrationCancel.setOnClickListener(this);

        textInputRegistrationLogin = (EditText) view.findViewById(R.id.inputRegistrationUsernameText);
        textInputRegistrationPassword = (EditText) view.findViewById(R.id.inputRegistrationPasswordText);
        textInputRegistrationEmail = (EditText) view.findViewById(R.id.inputRegistrationEmailText);
        userDatabase = ((MainActivity) getActivity()).getDatabase();
        textIncorrect = (TextView) view.findViewById(R.id.textRegistrationIncorrectInput);
        currentUser = new User();
        return view;
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnRegistrationConfirm:

                String InputUsernameText= textInputRegistrationLogin.getText().toString();
                String InputPasswordText= textInputRegistrationPassword.getText().toString();
                String InputEmailText= textInputRegistrationEmail.getText().toString();
                currentUser.setUsername(InputUsernameText);
                currentUser.setPassword(InputPasswordText);
                currentUser.setEmail(InputEmailText);
                //if (userDatabase.containsKey("" + currentUser.getUsername())) {
                    userDatabase.put(InputUsernameText, "" + currentUser);
                    userDatabase.saveInBackground();
                    Log.d("userDatabase", userDatabase.get("" + InputUsernameText).toString());
                    textIncorrect.setVisibility(View.INVISIBLE);
                    ((MainActivity) getActivity()).showRegistrationConfirmationFragment();

                /*}

                else {
                    textIncorrect.setVisibility(View.VISIBLE);
                }
                */
                break;
            case R.id.btnRegistrationCancel:
                //Log.d("Karl2", "Hi KarlCancel");
                textIncorrect.setVisibility(View.INVISIBLE);
                ((MainActivity)getActivity()).showMainFragment();
                break;

        }
    }
}

