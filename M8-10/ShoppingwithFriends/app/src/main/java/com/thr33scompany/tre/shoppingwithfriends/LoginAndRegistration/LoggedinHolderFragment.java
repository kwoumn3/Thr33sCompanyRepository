package com.thr33scompany.tre.shoppingwithfriends.LoginAndRegistration;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.thr33scompany.tre.shoppingwithfriends.BaseFragment;
import com.thr33scompany.tre.shoppingwithfriends.MVP.MainActivity;
import com.thr33scompany.tre.shoppingwithfriends.R;

/**
 * Created by Tre' on 1/31/2015.
 * Controls onClickListeners for Loggedin Fragment: fragment_loggedinhome
 */
public class LoggedinHolderFragment extends BaseFragment {
    private Button btnLogOut;
    private Button btnFriends;
    private Button btnRegistry;
    private Button btnSaleReports;
    private TextView SaleAlertText;
    private Switch MapSwitch;
    //private TabWidget tabHolder;
   // private ListView friendsList;
    //ArrayAdapter<String> friendListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_loggedinhome, container, false);
        SaleAlertText = (TextView) view.findViewById(R.id.SaleAlertText);
        ((MainActivity)getActivity()).updateDatabase();
       String Alert = ((MainActivity)getActivity()).registryCheck();
        if (!Alert.isEmpty()) {
            SaleAlertText.setText(Alert);
            SaleAlertText.setVisibility(View.VISIBLE);
        }

        btnLogOut = (Button) view.findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(this);
        btnFriends = (Button) view.findViewById(R.id.btnFriends);
        btnFriends.setOnClickListener(this);
        btnRegistry = (Button) view.findViewById(R.id.btnRegistry);
        btnRegistry.setOnClickListener(this);
        btnSaleReports = (Button) view.findViewById(R.id.btnSaleReports);
        btnSaleReports.setOnClickListener(this);
        MapSwitch = (Switch) view.findViewById(R.id.mapSwitch);
        MapSwitch.setChecked(false);
        //attach a listener to check for changes in state
        MapSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if(isChecked){

                    ((MainActivity)getActivity()).showMapFragment();


                }
                else {
                    ((MainActivity)getActivity()).hideMapFragment();

                }

            }
        });
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
            case R.id.btnRegistry:

                ((MainActivity)getActivity()).showRegistryHolderFragment();
            break;
            case R.id.btnSaleReports:
                ((MainActivity)getActivity()).showSaleReportHolderFragment();
                break;

        }
    }
}