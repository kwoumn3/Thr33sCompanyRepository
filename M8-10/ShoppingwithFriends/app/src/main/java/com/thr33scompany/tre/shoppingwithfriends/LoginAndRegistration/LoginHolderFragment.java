package com.thr33scompany.tre.shoppingwithfriends.LoginAndRegistration;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseObject;
import com.thr33scompany.tre.shoppingwithfriends.BaseFragment;
import com.thr33scompany.tre.shoppingwithfriends.MVP.MainActivity;
import com.thr33scompany.tre.shoppingwithfriends.R;

/**
 * Created by Tre' on 1/30/2015.
 * Contains the OnClickListeners for the Login Fragment: fragment_login
 */
public class LoginHolderFragment extends BaseFragment {
    private Button btnLoginConfirm;
    private Button btnCancel;
    private TextView textIncorrect;
    private EditText textInputLogin;
    private EditText textInputPassword;
    private ParseObject userDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);
        //INSTANTIATION
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
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLoginConfirm:
                String username="";
                String password="";
                String btnInputLoginText= textInputLogin.getText().toString();
                String btnInputPasswordText= textInputPassword.getText().toString();
                if (userDatabase.containsKey(btnInputLoginText)) {
                    username = userDatabase.get(btnInputLoginText).toString().split(" ")[0];
                    password = userDatabase.get(btnInputLoginText).toString().split(" ")[2];
                    Log.d("userDatabase2", username + "2");
                    Log.d("userDatabase2", btnInputLoginText + "2");
                    Log.d("userDatabase2", password + "1");
                    Log.d("userDatabase2", btnInputPasswordText + "1");
                    Log.d("userDatabase2", userDatabase.get(btnInputLoginText).toString());


                }

                //CHECKS DATA AGAINST THE DATABASE
                if ((((MainActivity) getActivity()).getUsername(btnInputLoginText).compareTo(btnInputLoginText) == 0) && (((MainActivity) getActivity()).getPassword(btnInputLoginText).compareTo(btnInputPasswordText) == 0)) {
                    ((MainActivity)getActivity()).setCURRENTUSER(btnInputLoginText);
                    ((MainActivity)getActivity()).showLoggedinFragment();
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

