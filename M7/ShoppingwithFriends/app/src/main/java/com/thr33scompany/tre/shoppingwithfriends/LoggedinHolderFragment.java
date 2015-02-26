package com.thr33scompany.tre.shoppingwithfriends;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabWidget;

import java.util.ArrayList;

/**
 * Created by Tre' on 1/31/2015.
 * Controls onClickListeners for Loggedin Fragment: fragment_loggedinhome
 */
public class LoggedinHolderFragment extends Fragment implements View.OnClickListener {
    private Button btnLogOut;
    private Button btnFriends;
    //private TabWidget tabHolder;
   // private ListView friendsList;
    //ArrayAdapter<String> friendListAdapter;
    public LoggedinHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_loggedinhome, container, false);
        btnLogOut = (Button) view.findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(this);
        btnFriends = (Button) view.findViewById(R.id.btnFriends);
        btnFriends.setOnClickListener(this);
        /*
       ArrayList<String> testArray = new ArrayList<String>();
        testArray.add("Hi");
        testArray.add("Bye");
        testArray.add("Karl Grounded");
        friendListAdapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_frienditem, testArray);
        friendsList = (ListView) view.findViewById(R.id.friendsListView);
        friendsList.setAdapter(new FriendListAdapter(
                getActivity(), R.layout.fragment_frienditem, testArray
        ));
        */
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogOut:
                //Log.d("Karl", "Hi Karl");
                ((MainActivity)getActivity()).showMainFragment();
            break;
            case R.id.btnFriends:
                Log.d("Karl", "Hi Karl");
                ((MainActivity)getActivity()).showFriendsFragment();
            break;

        }
    }
}