package com.thr33scompany.tre.shoppingwithfriends;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;

public class MainActivity extends ActionBarActivity {

    private LoginHolderFragment mLogInHolderFramgment;
    private WelcomeHolderFragment mWelcomeHolderFramgment;
    private ConfirmationHolderFragment mConfirmationHolderFramgment;
    private RegistrationHolderFragment mRegistrationHolderFragment;
    private LoggedinHolderFragment mLoggedinHolderFragment;
    private RegistrationConfirmationHolderFragment mRegistrationConfirmationHolderFragment;

    private ParseObject userDatabase;

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
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "EAoHP46azYVIsuavbdCDy3IjfUUCLAIXWh9jBPxD", "E8XeIM7kuGnobhg15u83NAU8HHI9cv4Tn3zxIDO8");

        userDatabase = new ParseObject("UserDatabase");
    }

    /**
     * Method to display Login Fragment: fragment_Login
     */
    public void showLoginFragment() {
        mLogInHolderFramgment = new LoginHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mLogInHolderFramgment)
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
        mWelcomeHolderFramgment = new WelcomeHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mWelcomeHolderFramgment)
                .commit();
    }

    /**
     * Method to display Confirmation Fragment for Login: fragment_confirmation
     */
    public void showConfirmationFragment() {
        mConfirmationHolderFramgment = new ConfirmationHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mConfirmationHolderFramgment)
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
    }

    /**
     * Method to display Registration Confirmation Fragment: fragment_confirmation_registration
     */
    public void showRegistrationConfirmationFragment() {
        mRegistrationConfirmationHolderFragment = new RegistrationConfirmationHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mRegistrationConfirmationHolderFragment)
                .commit();
    }

    /**
     * Method to get userDatabase ParseObject to store data
     * @return userDatabase
     */
    public ParseObject getDatabase() {
        return userDatabase;
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
