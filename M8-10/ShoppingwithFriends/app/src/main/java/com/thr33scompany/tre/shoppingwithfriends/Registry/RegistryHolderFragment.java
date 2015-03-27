package com.thr33scompany.tre.shoppingwithfriends.Registry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.thr33scompany.tre.shoppingwithfriends.BaseFragment;
import com.thr33scompany.tre.shoppingwithfriends.Friends.FriendListAdapter;
import com.thr33scompany.tre.shoppingwithfriends.MVP.MainActivity;
import com.thr33scompany.tre.shoppingwithfriends.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Tre' on 1/31/2015.
 * Controls onClickListeners for registry home fragment_registry
 */
public class RegistryHolderFragment extends BaseFragment {
    private Button btnBack;
    private Button btnAddRegistryItem;
    //private TabWidget tabHolder;
    private ListView registryList;
    private ArrayAdapter<String> registryListAdapter;
    private TextView noRegisteredItemsText;
    private ArrayList<String> testArray;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_registryhome, container, false);
        //INSTANTIATION OF ALL BUTTONS AND TEXT VIEWS,ETC.
        btnBack = (Button) view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnAddRegistryItem = (Button) view.findViewById(R.id.btnAddRegistryItem);
        btnAddRegistryItem.setOnClickListener(this);

        noRegisteredItemsText = (TextView) view.findViewById(R.id.noRegisteredItemsText);
        testArray = new ArrayList<>();
        String UserRegistry = ((MainActivity)getActivity()).getRegistry();
        //NULL CHECKS
        if(!(UserRegistry == null)) {
            testArray = new ArrayList<>(Arrays.asList(UserRegistry.split(";")));

        }
        /*
        testArray.add("Hi");
        testArray.add("Bye");
        testArray.add("Karl Grounded");
        */
        //IF THERE ARE NO USERS TO DISPLAY WILL SAY SO
        if (testArray.size() < 1 || testArray.contains("")) {
            noRegisteredItemsText.setVisibility(View.VISIBLE);
        }
        else {
            noRegisteredItemsText.setVisibility(View.INVISIBLE);
            registryListAdapter = new ArrayAdapter<>(getActivity(), R.layout.fragment_registryitem, testArray);
            registryList = (ListView) view.findViewById(R.id.registryListView);
            registryList.setAdapter(new FriendListAdapter(
                    getActivity(), R.layout.fragment_registryitem, testArray
            ));
        }
        /*
        if (registryList!=null) {
            registryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //((MainActivity) getActivity()).setACTIVEFRIEND(((MainActivity) getActivity()).getFriendID(testArray.get(position)));
                    ((MainActivity) getActivity()).showSearchDetailFragment();

                    //Log.d("Registry", ((MainActivity) getActivity()).getItemID(testArray.get(position)));
                }
            });
        }
        */

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnBack:
                //Log.d("Karl", "Hi Karl");
                ((MainActivity)getActivity()).showLoggedinFragment();
                break;
            case R.id.btnAddRegistryItem:
                //Log.d("Karl", "Hi Karl");
                ((MainActivity)getActivity()).showAddRegistryItemFragment();
                break;

        }
    }
}