package com.thr33scompany.tre.shoppingwithfriends.MVP;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBarActivity;

import com.thr33scompany.tre.shoppingwithfriends.Friends.AddFriendsHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.Registry.AddRegistryItemFragment;
import com.thr33scompany.tre.shoppingwithfriends.Friends.FriendDetail;
import com.thr33scompany.tre.shoppingwithfriends.Friends.FriendsHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.LoginAndRegistration.LoggedinHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.LoginAndRegistration.LoginHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.R;
import com.thr33scompany.tre.shoppingwithfriends.LoginAndRegistration.RegistrationHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.Registry.RegistryHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.Registry.SaleReportHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.WelcomeHolderFragment;

/**'
 * Interacts with Fragments for display
 * Created by Tre' on 2/26/2015.
 */
@SuppressLint("Registered")
public class ViewHolder extends ActionBarActivity {
    //Instantiation of fragments for ShowFragment methods
    private LoginHolderFragment mLogInHolderFragment;
    private WelcomeHolderFragment mWelcomeHolderFragment;
    private RegistrationHolderFragment mRegistrationHolderFragment;
    private LoggedinHolderFragment mLoggedinHolderFragment;
    private FriendsHolderFragment mFriendsHolderFragment;
    private AddFriendsHolderFragment mAddFriendsHolderFragment;
    private FriendDetail mFriendDetail;
    private RegistryHolderFragment mRegistryHolderFragment;
    private AddRegistryItemFragment mAddRegistryItemFragment;
    private SaleReportHolderFragment mSaleReportHolderFragment;



    /**
     * Method to display Login Fragment: fragment_Login
     */
    public void showLoginFragment() {
        mLogInHolderFragment = new LoginHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mLogInHolderFragment)
                .commit();
    }

    /**
     * Method to display Registration Fragment: fragment_registration
     */
    public void showRegistrationFragment() {
        mRegistrationHolderFragment = new RegistrationHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mRegistrationHolderFragment)
                .commit();
    }

    /**
     * Method to display Main Fragment: fragment_main
     */
    public void showMainFragment() {
        mWelcomeHolderFragment = new WelcomeHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mWelcomeHolderFragment)
                .commit();
    }

    /**
     * Method to display Logged in Fragment: fragment_loggedinhome
     */
    public void showLoggedinFragment() {
        mLoggedinHolderFragment = new LoggedinHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mLoggedinHolderFragment)
                .commit();
        getSupportFragmentManager().beginTransaction()
                .remove(mLogInHolderFragment)
                .commit();
    }
    /**
     * Method to display Friends Fragment: fragment_friendshome
     */
    public void showFriendsFragment() {
        mFriendsHolderFragment = new FriendsHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mFriendsHolderFragment)
                .commit();
    }

    /**
     * Method to display Add Friend Fragment: fragment_add_friend
     */
    public void showAddFriendFragment() {
        mAddFriendsHolderFragment = new AddFriendsHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mAddFriendsHolderFragment)
                .commit();
    }

    public void showAddRegistryItemFragment() {
        mAddRegistryItemFragment = new AddRegistryItemFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mAddRegistryItemFragment)
                .commit();
    }

    public void showRegistryHolderFragment() {
        mRegistryHolderFragment = new RegistryHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mRegistryHolderFragment)
                .commit();
    }

    public void showFriendDetailFragment() {
        mFriendDetail = new FriendDetail();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mFriendDetail)
                .commit();
    }

    public void showSaleReportHolderFragment() {
        mSaleReportHolderFragment = new SaleReportHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mSaleReportHolderFragment)
                .commit();
    }
}
