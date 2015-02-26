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
import android.widget.RatingBar;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by Tre' on 1/30/2015.
 * Contains the OnClickListeners for the Login Fragment: fragment_login
 */
public class FriendDetail extends Fragment implements OnClickListener {
    private Button btnBack;
    private Button btnSave;
    private Button btnDelete;
    private TextView textUsername;
    private TextView textEmail;
    private TextView textSalesReport;
    private TextView textSaveComplete;
    private TextView textDeleteComplete;
    private RatingBar rating;
    //private EditText textInputPassword;
    //ParseObject userDatabase;
    private String FriendID;
    private ParseQuery<ParseObject> query;

    public FriendDetail() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_frienddetail, container, false);
        //INSTANTIATION
        btnBack = (Button) view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnSave = (Button) view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnDelete = (Button) view.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);

        rating = (RatingBar) view.findViewById(R.id.ratingBar);

        textUsername = (TextView) view.findViewById(R.id.textUsername);
        textEmail = (TextView) view.findViewById(R.id.textEmail);
        textSalesReport = (TextView) view.findViewById(R.id.textSalesReport);
        textSaveComplete = (TextView) view.findViewById(R.id.textSaveComplete);
        textDeleteComplete = (TextView) view.findViewById(R.id.textDeleteComplete);

        query = ((MainActivity) getActivity()).getQuery();
        FriendID = ((MainActivity) getActivity()).getACTIVEFRIEND();
        try {
            textUsername.setText(query.get(FriendID).getString("Username"));
            textEmail.setText(query.get(FriendID).getString("Email"));
            textSalesReport.setText("" + query.get(FriendID).getNumber("SalesReports"));
            rating.setRating(query.get(FriendID).getNumber("Rating").floatValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //textIncorrect = (TextView) view.findViewById(R.id.textIncorrectInput);
        //userDatabase = ((MainActivity) getActivity()).getDatabase();

        return view;
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnBack:
                ((MainActivity)getActivity()).showFriendsFragment();
                break;


            case R.id.btnSave:
                textDeleteComplete.setVisibility(View.INVISIBLE);
                textSaveComplete.setVisibility(View.VISIBLE);
                ((MainActivity)getActivity()).setRating(FriendID, rating.getRating());
                ((MainActivity) getActivity()).updateDatabase();
                break;

            case R.id.btnDelete:
                textSaveComplete.setVisibility(View.INVISIBLE);
                textDeleteComplete.setVisibility(View.VISIBLE);
                ((MainActivity)getActivity()).removeFriend(FriendID);
                ((MainActivity) getActivity()).updateDatabase();
                break;
        }
    }

}

