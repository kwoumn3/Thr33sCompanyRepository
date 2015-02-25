package com.thr33scompany.tre.shoppingwithfriends;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Tre' on 1/31/2015.
 * Controls onClickListeners for Friends home screen: fragment_friendshome.
 */
public class FriendsHolderFragment extends Fragment implements View.OnClickListener {
    private Button btnLogOut;
    private Button btnAddFriend;
    //private TabWidget tabHolder;
    private ListView friendsList;
    ArrayAdapter<String> friendListAdapter;
    TextView noFriendsText;
    ArrayList<String> testArray;


    public FriendsHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_friendshome, container, false);
        //INSTANTIATION OF ALL BUTTONS AND TEXT VIEWS,ETC.
        btnLogOut = (Button) view.findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(this);
        btnAddFriend = (Button) view.findViewById(R.id.btnAddFriend);
        btnAddFriend.setOnClickListener(this);

        noFriendsText = (TextView) view.findViewById(R.id.textNoFriends);
        testArray = new ArrayList<String>();
        String UserFriends = ((MainActivity)getActivity()).getFriends(((MainActivity)getActivity()).getCURRENTUSER());
        //NULL CHECKS
        if(!(UserFriends == null)) {
            testArray = new ArrayList<String>(Arrays.asList(UserFriends.split(";")));

        }
        /*
        testArray.add("Hi");
        testArray.add("Bye");
        testArray.add("Karl Grounded");
        */
        //IF THERE ARE NO USERS TO DISPLAY WILL SAY SO
        if (testArray.size() < 1) {
            noFriendsText.setVisibility(View.VISIBLE);
        }
        else {
            noFriendsText.setVisibility(View.INVISIBLE);
            friendListAdapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_frienditem, testArray);
            friendsList = (ListView) view.findViewById(R.id.friendsListView);
            friendsList.setAdapter(new FriendListAdapter(
                    getActivity(), R.layout.fragment_frienditem, testArray
            ));
        }
        friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Friends" , ((MainActivity)getActivity()).getFriendID(testArray.get(position)));
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogOut:
                //Log.d("Karl", "Hi Karl");
                ((MainActivity)getActivity()).showMainFragment();
                break;
            case R.id.btnAddFriend:
                //Log.d("Karl", "Hi Karl");
                ((MainActivity)getActivity()).showAddFriendFragment();
                break;

        }
    }
}