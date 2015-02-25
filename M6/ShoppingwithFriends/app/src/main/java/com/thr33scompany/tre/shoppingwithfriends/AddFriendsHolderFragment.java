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
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Tre' on 1/31/2015.
 * Controls onClickListeners and List View Logic for the fragment: fragment_addfriend.
 */
public class AddFriendsHolderFragment extends Fragment implements View.OnClickListener {
    private Button btnLogOut;
    private Button btnHome;
    //private Button btnAdd;
    TextView textSuccess;
    TextView textFailure;
    //private TabWidget tabHolder;
    private ListView friendsList;
    private ArrayAdapter<String> friendListAdapter;
    private TextView noFriendsText;
    private ArrayList<String> UserFriendsList;
    private String[] tempUserList;
    private String UserFriends;
    public AddFriendsHolderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_addfriend, container, false);
        //INSTANTIATION OF ALL OBJECTS IN FRAGMENT
        btnLogOut = (Button) view.findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(this);
        btnHome = (Button) view.findViewById(R.id.btnHome);
        btnHome.setOnClickListener(this);
        //btnAdd = (Button) view.findViewById(R.id.btnAdd);
        //btnAdd.setOnClickListener(this);
        textSuccess = (TextView) view.findViewById(R.id.textSuccess);
        textFailure = (TextView) view.findViewById(R.id.textFailure);
        noFriendsText = (TextView) view.findViewById(R.id.textNoFriends);
        ArrayList<String> testArray = new ArrayList<String>();
        String UserList = ((MainActivity)getActivity()).getUsers(((MainActivity)getActivity()).getCURRENTUSER());
        //TO BE SURE NOT TO ADD NULL TO THE DATABASE
        if(!(UserList == null)) {
            tempUserList = UserList.split(";");
            testArray = new ArrayList<String>(Arrays.asList(tempUserList));
        }
        //Log.d("Register3", "UserList: " + tempUserList);


        /*
        testArray.add("Hi");
        testArray.add("Bye");
        testArray.add("Karl Grounded");
        */
        //TRIGGERS "NO FRIENDS TO DISPLAY" TEXT
        if (testArray.size() < 1) {
            noFriendsText.setVisibility(View.VISIBLE);
        }
        else {
            noFriendsText.setVisibility(View.INVISIBLE);
            friendListAdapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_addfrienditem, testArray);
            friendsList = (ListView) view.findViewById(R.id.addFriendsListView);
             UserFriends = ((MainActivity)getActivity()).getFriends(((MainActivity)getActivity()).getCURRENTUSER());
            if (!(UserFriends == null)) {
                 UserFriendsList = new ArrayList<String>(Arrays.asList(UserFriends.split(";")));
            }
            else {
                UserFriends=" ";
            }
            //LOGIC FOR LIST VIEW ONCLICKLISTENER
            friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if (!(UserFriendsList == null)) {
                        //IF THE USER IS ALREADY ADDED DISPLAYS FAILURE MESSAGE
                        if(UserFriendsList.contains(tempUserList[position])) {
                            textFailure.setVisibility(View.VISIBLE);
                            textSuccess.setVisibility(View.INVISIBLE);
                        } else {
                            textFailure.setVisibility(View.INVISIBLE);
                            textSuccess.setVisibility(View.VISIBLE);
                            ((MainActivity) getActivity()).addFriend(tempUserList[position]);
                        }
                    }
                    else {
                        textFailure.setVisibility(View.INVISIBLE);
                        textSuccess.setVisibility(View.VISIBLE);
                        ((MainActivity) getActivity()).addFriend(tempUserList[position]);
                    }
                    //IMPORTANT!!!!!!!!!!! REFRESHES DATA AFTER ADDITIONS
                    ((MainActivity) getActivity()).updateDatabase();
                    UserFriends = ((MainActivity)getActivity()).getFriends(((MainActivity)getActivity()).getCURRENTUSER());
                    if ((UserFriends != null)) {
                        UserFriendsList = new ArrayList<String>(Arrays.asList(UserFriends.split(";")));
                    }

                }

            });

            friendsList.setAdapter(new FriendListAdapter(
                    getActivity(), R.layout.fragment_addfrienditem, testArray
            ));
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        //ON CLICK VIA BUTTON ID
        switch(v.getId()){
            case R.id.btnLogOut:
                //Log.d("Karl", "Hi Karl");
                ((MainActivity)getActivity()).showMainFragment();
                break;
            case R.id.btnHome:
                //Log.d("Karl", "Hi Karl");
                //Log.d("Register3", ((MainActivity)getActivity()).getCURRENTUSER());
                //Log.d("Register3", ((MainActivity)getActivity()).getUsers(((MainActivity) getActivity()).getCURRENTUSER()));
                ((MainActivity)getActivity()).showLoggedinFragment();
                break;
            /*case R.id.btnAdd:
                Log.d("Karl", "Hi Karl");
                //((MainActivity)getActivity()).showAddFriendFragment();

                break;*/

        }
    }
}