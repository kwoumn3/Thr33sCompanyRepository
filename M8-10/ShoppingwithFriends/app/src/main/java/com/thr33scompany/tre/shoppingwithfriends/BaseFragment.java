package com.thr33scompany.tre.shoppingwithfriends;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Abstract Fragment for other Fragments
 * Created by Tre' on 3/21/2015.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    public abstract View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState);
    public abstract void onClick(View v);
}
