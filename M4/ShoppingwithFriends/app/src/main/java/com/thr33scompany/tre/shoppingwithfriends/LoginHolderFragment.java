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

import com.parse.ParseObject;

/**
 * Created by Tre' on 1/30/2015.
 * Contains he OnClickListeners for the Login Fragment: fragment_login
 */
public class LoginHolderFragment extends Fragment implements OnClickListener {
    private Button btnLoginConfirm;
    private Button btnCancel;

    private TextView textIncorrect;
    private EditText textInputLogin;
    private EditText textInputPassword;
    ParseObject userDatabase;
    User currentUser;
    public LoginHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);
        btnLoginConfirm = (Button) view.findViewById(R.id.btnLoginConfirm);
        btnLoginConfirm.setOnClickListener(this);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);

        textInputLogin = (EditText) view.findViewById(R.id.inputTextUser_ID);
        textInputPassword = (EditText) view.findViewById(R.id.inputTextPassword);

        textIncorrect = (TextView) view.findViewById(R.id.textIncorrectInput);

        userDatabase = ((MainActivity) getActivity()).getDatabase();
        return view;
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLoginConfirm:
                String username="";
                String password="";
                String btnInputLoginText= textInputLogin.getText().toString();
                String btnInputPasswordText= textInputPassword.getText().toString();
                if (userDatabase.containsKey(btnInputLoginText)) {
                    username = userDatabase.get("Username").toString().split(" ")[0];
                    password = userDatabase.get("Username").toString().split(" ")[2];
                    Log.d("userDatabase2", username);
                    Log.d("userDatabase2", password);
                    Log.d("userDatabase2", userDatabase.get("Username").toString());
                    String userID = username;
                    String Password = password;
                }


                if (username.equals(btnInputLoginText) && password.equals(btnInputPasswordText)) {
                    ((MainActivity)getActivity()).showConfirmationFragment();
                }
                else {
                    //((MainActivity) getActivity()).showLoginFragment();

                    textIncorrect.setVisibility(View.VISIBLE);

                }
               break;


            case R.id.btnCancel:
                Log.d("Karl2", "Hi KarlCancel");
                textIncorrect.setVisibility(View.INVISIBLE);
                ((MainActivity)getActivity()).showMainFragment();
                break;

        }
    }
}

