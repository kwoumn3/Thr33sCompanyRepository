package com.thr33scompany.tre.shoppingwithfriends.Registry;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.thr33scompany.tre.shoppingwithfriends.BaseFragment;
import com.thr33scompany.tre.shoppingwithfriends.MVP.MainActivity;
import com.thr33scompany.tre.shoppingwithfriends.R;

/**
 * Created by Tre' on 1/30/2015.
 *Holds the click Listeners and logic for the Sale Report fragment
 */
public class SaleReportHolderFragment extends BaseFragment {
    private Button btnSaleReportSave;
    private Button btnSaleReportCancel;

    private EditText saleReportItemName;
    private EditText saleReportPrice;
    private EditText saleReportLocation;

    private TextView saleReportSaveCompleteText;
    private TextView saleReportItemAlreadyAddedText;
    private ParseObject saleReportDatabase;
    private ParseQuery query;
    private String USERID;
    private String userReports;
    private ParseObject userDatabase;
    private int saleReportValue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_reportsales, container, false);
        //INSTANTIATION
        btnSaleReportSave = (Button) view.findViewById(R.id.btnSaleReportSave);
        btnSaleReportSave.setOnClickListener(this);
        btnSaleReportCancel = (Button) view.findViewById(R.id.btnSaleReportCancel);
        btnSaleReportCancel.setOnClickListener(this);

        saleReportItemName = (EditText) view.findViewById(R.id.saleReportItemName);
        saleReportPrice = (EditText) view.findViewById(R.id.saleReportPrice);
        saleReportLocation = (EditText) view.findViewById(R.id.saleReportLocation);

        saleReportSaveCompleteText = (TextView) view.findViewById(R.id.saleReportSaveComplete);
        saleReportItemAlreadyAddedText = (TextView) view.findViewById(R.id.saleReportItemAlreadyAdded);


        query = ((MainActivity) getActivity()).getQuery();
        USERID = ((MainActivity) getActivity()).getFriendID(((MainActivity) getActivity()).getCURRENTUSER());
        try {
             saleReportValue = query.get(USERID).getNumber("SalesReports").intValue();
            userReports = query.get(USERID).getString("Reports");
            if (userReports == null) {
                userReports="";
            }
            userDatabase = ((MainActivity)getActivity()).getDatabase();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return view;
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSaleReportSave:
                saleReportDatabase = new ParseObject("SaleReports");

                try {
                    if (query.get(USERID).getString("Reports") != null) {
                        if (query.get(USERID).getString("Reports").contains(saleReportItemName.getText() + "-" + saleReportPrice.getText() + "-" + saleReportLocation.getText() +";")) {
                            saleReportItemAlreadyAddedText.setVisibility(View.VISIBLE);
                            saleReportSaveCompleteText.setVisibility(View.INVISIBLE);
                        }
                        else {
                            Log.d("Reports",query.get(USERID).getString("Reports"));
                            saleReportItemAlreadyAddedText.setVisibility(View.INVISIBLE);
                            saleReportSaveCompleteText.setVisibility(View.VISIBLE);
                            saleReportDatabase.put("SaleReport", saleReportItemName.getText() + "-" + saleReportPrice.getText() + "-" + saleReportLocation.getText());
                            saleReportDatabase.put("SaleReporter", USERID);
                            query.get(USERID).put("Reports", userReports + saleReportItemName.getText() + "-" + saleReportPrice.getText() + "-" + saleReportLocation.getText() + ";");
                            query.get(USERID).put("SalesReports", saleReportValue++);

                            saleReportDatabase.saveInBackground();
                            query.get(USERID).saveInBackground();
                            saleReportDatabase.fetchInBackground();
                            ((MainActivity) getActivity()).updateDatabase();

                        }
                    }
                    else {
                        saleReportItemAlreadyAddedText.setVisibility(View.INVISIBLE);
                        saleReportSaveCompleteText.setVisibility(View.VISIBLE);
                        saleReportDatabase.put("SaleReport", saleReportItemName.getText() + "-" + saleReportPrice.getText() + "-" + saleReportLocation.getText());
                        saleReportDatabase.put("SaleReporter", USERID);
                        query.get(USERID).put("Reports", userReports + saleReportItemName.getText() + "-" + saleReportPrice.getText() + "-" + saleReportLocation.getText() + ";");
                        query.get(USERID).put("SalesReports", saleReportValue++);

                        saleReportDatabase.saveInBackground();
                        query.get(USERID).saveInBackground();
                        saleReportDatabase.fetchInBackground();
                        ((MainActivity) getActivity()).updateDatabase();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //REGISTRY = ((MainActivity) getActivity()).getRegistry(((MainActivity) getActivity()).getCURRENTUSER());
                //if (REGISTRY != null) {
                //if ((saleReportItemName.getText().toString() + "-" + 100).compareToIgnoreCase((saleReportItemName.getText().toString() + "-" + 1000)) < 0) {
                //saleReportSaveCompleteText.setVisibility(View.INVISIBLE);
                //saleReportItemAlreadyAddedText.setVisibility(View.VISIBLE);


                //}
                /*
                if ((saleReportItemName.getText().toString() + "-" + 100).compareToIgnoreCase((saleReportItemName.getText().toString() + "-" + 1001)) > 0) {
                    //saleReportItemAlreadyAddedText.setVisibility(View.INVISIBLE);
                    //saleReportSaveCompleteText.setVisibility(View.VISIBLE);
                    //(saleReportItemName.getText().toString(), saleReportPrice.getText().toString());
                    //((MainActivity) getActivity()).updateDatabase();
                    Log.d("Report", "Greater Than");
                }
                if ((saleReportItemName.getText().toString() + "-" + 100).compareToIgnoreCase((saleReportItemName.getText().toString() + "-" + 100)) == 0) {
                    //saleReportItemAlreadyAddedText.setVisibility(View.VISIBLE);
                    //saleReportSaveCompleteText.setVisibility(View.VISIBLE);
                    Log.d("Report", "Equal");
                }
        //}
                else {
                    saleReportItemAlreadyAddedText.setVisibility(View.INVISIBLE);
                    saleReportSaveCompleteText.setVisibility(View.VISIBLE);
                    //(saleReportItemName.getText().toString(), saleReportPrice.getText().toString());
                    //((MainActivity) getActivity()).updateDatabase();
                }
                */
                break;


            case R.id.btnSaleReportCancel:
                ((MainActivity)getActivity()).showLoggedinFragment();
                break;

        }
    }
}

