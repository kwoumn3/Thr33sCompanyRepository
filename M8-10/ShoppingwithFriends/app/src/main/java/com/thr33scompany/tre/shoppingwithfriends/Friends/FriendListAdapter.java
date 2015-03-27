package com.thr33scompany.tre.shoppingwithfriends.Friends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.thr33scompany.tre.shoppingwithfriends.R;

import java.util.List;

/**
 * Created by Tre' on 2/18/2015.
 * Custom ArrayAdapter to be used with displaying userlist and friendslist
 */

public class FriendListAdapter extends ArrayAdapter<String> {
    public FriendListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View cView, ViewGroup parent) {
        View convertView = cView;
        if(convertView == null) {
            //LayoutInflater inflater= (LayoutInflater) getContext().SystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_frienditem,parent,false);
        }
        String item = getItem(position);

        //LinearLayout graphFrame = (LinearLayout) convertView.findViewById(R.id.ll_graph);
        TextView friendName = (TextView) convertView.findViewById(R.id.friendName);
        friendName.setText(item);

        return convertView;
    }
}
