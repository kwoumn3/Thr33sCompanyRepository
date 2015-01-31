package com.thr33scompany.tre.shoppingwithfriends;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;


public class MainActivity extends ActionBarActivity {
    private LoginHolderFragment mLogInHolderFramgment;
    private WelcomeHolderFragment mWelcomeHolderFramgment;
    private ConfirmationHolderFragment mConfirmationHolderFramgment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            mWelcomeHolderFramgment = new WelcomeHolderFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mWelcomeHolderFramgment)
                    .commit();
        }
    }

    public void showLoginFragment() {
        mLogInHolderFramgment = new LoginHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mLogInHolderFramgment)
                .commit();
    }
    public void showMainFragment() {
        mWelcomeHolderFramgment = new WelcomeHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mWelcomeHolderFramgment)
                .commit();
    }
    public void showConfirmationFragment() {
        mConfirmationHolderFramgment = new ConfirmationHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mConfirmationHolderFramgment)
                .commit();
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    */
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
