package com.thr33scompany.tre.shoppingwithfriends.Registry;

import android.os.Bundle;
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
 * Contains the OnClickListeners for the Add Item Fragment: fragment_addregistryitem
 */
public class AddRegistryItemFragment extends BaseFragment {
    private Button btnRegistrySave;
    private Button btnRegistryCancel;

    private EditText registryItemName;
    private EditText registryItemThreshold;

    private TextView registrySaveCompleteText;
    private TextView registryItemAlreadyAddedText;
    private ParseObject userDatabase;
    private String REGISTRY;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_addregistryitem, container, false);
        //INSTANTIATION
        btnRegistrySave = (Button) view.findViewById(R.id.btnRegistrySave);
        btnRegistrySave.setOnClickListener(this);
        btnRegistryCancel = (Button) view.findViewById(R.id.btnRegistryCancel);
        btnRegistryCancel.setOnClickListener(this);

        registryItemName = (EditText) view.findViewById(R.id.registryItemName);
        registryItemThreshold = (EditText) view.findViewById(R.id.registryItemThreshold);

        registrySaveCompleteText = (TextView) view.findViewById(R.id.registrySaveComplete);
        registryItemAlreadyAddedText = (TextView) view.findViewById(R.id.registryItemAlreadyAdded);

        userDatabase = ((MainActivity) getActivity()).getDatabase();
        REGISTRY = ((MainActivity) getActivity()).getRegistry();
        return view;
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnRegistrySave:
                REGISTRY = ((MainActivity) getActivity()).getRegistry();
                if (REGISTRY != null) {
                   if(REGISTRY.contains(registryItemName.getText().toString() + "-" + registryItemThreshold.getText().toString())) {
                       registrySaveCompleteText.setVisibility(View.INVISIBLE);
                       registryItemAlreadyAddedText.setVisibility(View.VISIBLE);
                   }
                    else{
                       registryItemAlreadyAddedText.setVisibility(View.INVISIBLE);
                       registrySaveCompleteText.setVisibility(View.VISIBLE);
                       ((MainActivity) getActivity()).addToRegistry(registryItemName.getText().toString(), registryItemThreshold.getText().toString());
                       ((MainActivity) getActivity()).updateDatabase();
                   }
                }
                else {
                    registryItemAlreadyAddedText.setVisibility(View.INVISIBLE);
                    registrySaveCompleteText.setVisibility(View.VISIBLE);
                    ((MainActivity) getActivity()).addToRegistry(registryItemName.getText().toString(), registryItemThreshold.getText().toString());
                    ((MainActivity) getActivity()).updateDatabase();
                }
                break;


            case R.id.btnRegistryCancel:
                ((MainActivity)getActivity()).showRegistryHolderFragment();
                break;

        }
    }
}

