package com.thr33scompany.tre.shoppingwithfriends;

import android.app.DownloadManager;
import android.content.Context;
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

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class MainActivity extends ActionBarActivity {
//Instantiation of fragments for ShowFragment methods
    private LoginHolderFragment mLogInHolderFramgment;
    private WelcomeHolderFragment mWelcomeHolderFramgment;
    private ConfirmationHolderFragment mConfirmationHolderFramgment;
    private RegistrationHolderFragment mRegistrationHolderFragment;
    private LoggedinHolderFragment mLoggedinHolderFragment;
    private RegistrationConfirmationHolderFragment mRegistrationConfirmationHolderFragment;
    private FriendsHolderFragment mFriendsHolderFragment;
    private AddFriendsHolderFragment mAddFriendsHolderFragment;
    private FriendDetail mFriendDetail;
//Current User for method calls in other classes
    private String CURRENTUSER;
//Database Variables
    private ParseObject userDatabase;
    private ParseQuery<ParseObject> query;
    private List users;
    public Context mContext;
    String ObjID="";
    private String ACTIVEFRIEND;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = (Context) this;
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
        //Boolean email = isValidEmail("regonoxe@yahoo.com");
        //Log.d("EmailVal", email + "");
        //updateDatabase();
        //ParseQuery<ParseObject> query = ParseQuery.getQuery("UserDatabase");
/*
        try {

            Log.d("query","" + query.getInBackground(ObjID));
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/
        // Specify which class to query
        query = ParseQuery.getQuery("UserDatabase");
        try {
            users = query.find();
            //ObjID = query.find().get(0).getObjectId();

            //String ObjID2 = query.find().get(1).getObjectId();

            Log.d("query", "size " + users.size());
           Log.d("query", "users " + users);
           // Log.d("query", "user 0 " + users.get(0));
            //Log.d("query","Id " + ObjID + "    "+ query.get(ObjID).getString("Username"));
            //Log.d("query", "user 1 " + users.get(1));
            //Log.d("query","Id 2 " + ObjID2 + "    "+ query.get(ObjID2).getString("Username2"));
            //Log.d("query", "to string " + query.find().toString());

        } catch (ParseException e) {
            e.printStackTrace();
        }

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
        getSupportFragmentManager().beginTransaction()
                .remove(mLogInHolderFramgment)
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
    /**
     * Method to display Registration Confirmation Fragment: fragment_confirmation_registration
     */
    public void showRegistrationConfirmationFragment() {
        mRegistrationConfirmationHolderFragment = new RegistrationConfirmationHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mRegistrationConfirmationHolderFragment)
                .commit();
    }

    public void showFriendDetailFragment() {
        mFriendDetail = new FriendDetail();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mFriendDetail)
                .commit();
    }

    /**
     * Method to get userDatabase ParseObject to store data
     * @return userDatabase
     */
    public ParseObject getDatabase() {
        return userDatabase;
    }

    /**
     * Method to get current Parse Query
     * @return query
     */
    public ParseQuery<ParseObject>  getQuery() {
        return query;
    }

    /**
     * Function to get username, matches against database
     * @param inputUsername
     * @return Username
     */
    public String getUsername (String inputUsername) {
        String Username = "Available";
        //query = ParseQuery.getQuery("UserDatabase");
        ParseObject userOBJ;
        try {
            Log.d("Test", "Users " + users);
            for(int i=0; i < users.size(); i++) {
                //ObjID = query.find().get(i).getObjectId();
                userOBJ = (ParseObject) users.get(i);
                ObjID = userOBJ.getObjectId();
                Log.d("Test", "UserOBJECT ID " + ObjID);
                //Log.d("Test", "size " + users.size());
                //Log.d("Test", "size query " + query.find().size());
                //Log.d("Test", "OBJ ID " + query.find().get(1).getObjectId());
                //Log.d("Test", "OBJ ID " + query.find().get(i).getObjectId());
                //Log.d("Test", "User OBJ ID TEST" + (i+1) + " " + ((ParseObject) users.get(i)).getString(ObjID));
                //((ParseObject) users.get(i)).get("Username")
                //((ParseObject) users.get(i)).getString()
                //Log.d("Test", "OBJ ID 0 " + query.find().get(0).getObjectId());
                //Log.d("Register", i + " " + users.get(i).toString().split(" ")[0]);
                if(query.get(ObjID).getString("Username") == null) {
                    Log.d("Test", "YOSHI DID IT " + query.get(ObjID).getString("Username"));
                }
                else if (query.get(ObjID).getString("Username").compareTo(inputUsername) == 0) {
                    Log.d("Register", query.get(ObjID).getString("Username"));
                    Username = query.get(ObjID).getString("Username");
                }
                else {
                    Log.d("Test", "DIDDY DID IT " + query.get(ObjID).getString("Username"));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Username;
    }

    /**
     * Function to get password, matches against database
     * @param inputUsername
     * @return Password
     */
    public String getPassword (String inputUsername) {
        String Password = "";
        //query = ParseQuery.getQuery("UserDatabase");
        ParseObject userOBJ;
        try {
            Log.d("Test2", "Users " + users);
            for(int i=0; i < users.size(); i++) {
                //ObjID = query.find().get(i).getObjectId();
                userOBJ = (ParseObject) users.get(i);
                ObjID = userOBJ.getObjectId();
                Log.d("Test2", "UserOBJECT ID " + ObjID);
                //Log.d("Test", "size " + users.size());
                //Log.d("Test", "size query " + query.find().size());
                //Log.d("Test", "OBJ ID " + query.find().get(1).getObjectId());
                //Log.d("Test", "OBJ ID " + query.find().get(i).getObjectId());
                Log.d("Test2", "User " + (i+1) + " " + ((ParseObject) users.get(i)).getString("Username"));
                //((ParseObject) users.get(i)).getString()
                //Log.d("Test", "OBJ ID 0 " + query.find().get(0).getObjectId());
                //Log.d("Register", i + " " + users.get(i).toString().split(" ")[0]);
                if(query.get(ObjID).getString("Username") == null) {
                    Log.d("Test2", "YOSHI2 DID IT " + query.get(ObjID).getString("Username"));
                }
                else if (query.get(ObjID).getString("Username").compareTo(inputUsername) == 0) {
                    Log.d("Register2", query.get(ObjID).getString("Username"));
                    Password = query.get(ObjID).getString("Password");
                }
                else {
                    Log.d("Test2", "DIDDY2 DID IT " + query.get(ObjID).getString("Password"));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Password;
    }

    /**
     *
     * Method to get a string version of all users, minus current logged in user with ';' delimiters
     * @param inputUsername
     * @return Users
     */
    public String getUsers (String inputUsername) {
        String Users = "";
        //query = ParseQuery.getQuery("UserDatabase");
        ParseObject userOBJ;
        try {
            //Log.d("Test2", "Users " + users);
            for(int i=0; i < users.size(); i++) {
                //ObjID = query.find().get(i).getObjectId();
                userOBJ = (ParseObject) users.get(i);
                ObjID = userOBJ.getObjectId();
                //Log.d("Test2", "UserOBJECT ID " + ObjID);
                //Log.d("Test", "size " + users.size());
                //Log.d("Test", "size query " + query.find().size());
                //Log.d("Test", "OBJ ID " + query.find().get(1).getObjectId());
                //Log.d("Test", "OBJ ID " + query.find().get(i).getObjectId());
                //Log.d("Test2", "User " + (i+1) + " " + ((ParseObject) users.get(i)).getString(inputUsername));
                //((ParseObject) users.get(i)).getString()
                //Log.d("Test", "OBJ ID 0 " + query.find().get(0).getObjectId());
                //Log.d("Register", i + " " + users.get(i).toString().split(" ")[0]);
                if(query.get(ObjID).getString("Username") == null) {
                    //Log.d("Register3", query.get(ObjID).fetch().toString());
                    //Log.d("Register3", query.get(ObjID).);
                    //Log.d("Test2", "YOSHI2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
                else if (query.get(ObjID).getString("Username").compareTo(inputUsername) == 0) {
                    //Log.d("Register3", query.get(ObjID).getString(inputUsername));
                    //Users+= query.get(ObjID).getString(inputUsername).split(" ")[0] +";";
                    //Password = query.get(ObjID).getString(inputUsername).split(" ")[2];
                }
                else {
                    Log.d("Register3", query.get(ObjID).getString("Username"));
                    Users+= query.get(ObjID).getString("Username") +";";
                    //Log.d("Test2", "DIDDY2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Users;
    }

    /**
     * Method to addFriend for logged in user to the database
     */
    public void addFriend (String name) {
        String CurrentUserID = "";
        //Log.d("Friendship", name);
        //query = ParseQuery.getQuery("UserDatabase");
        ParseObject userOBJ;
        try {
            //Log.d("Test2", "Users " + users);
            for(int i=0; i < users.size(); i++) {
                //ObjID = query.find().get(i).getObjectId();
                userOBJ = (ParseObject) users.get(i);
                ObjID = userOBJ.getObjectId();
                //Log.d("Test2", "UserOBJECT ID " + ObjID);
                //Log.d("Test", "size " + users.size());
                //Log.d("Test", "size query " + query.find().size());
                //Log.d("Test", "OBJ ID " + query.find().get(1).getObjectId());
                //Log.d("Test", "OBJ ID " + query.find().get(i).getObjectId());
                //Log.d("Test2", "User " + (i+1) + " " + ((ParseObject) users.get(i)).getString(inputUsername));
                //((ParseObject) users.get(i)).getString()
                //Log.d("Test", "OBJ ID 0 " + query.find().get(0).getObjectId());
                //Log.d("Register", i + " " + users.get(i).toString().split(" ")[0]);
                if(query.get(ObjID).getString("Username").compareTo(CURRENTUSER) == 0) {
                    CurrentUserID = ObjID;
                    //Log.d("Friendship", ObjID);
                    if (query.get(CurrentUserID).getString("Friends") != null) {
                        query.get(CurrentUserID).put("Friends", query.get(CurrentUserID).getString("Friends") + name + ";");
                        query.get(CurrentUserID).saveInBackground();
                    }
                    else {
                        query.get(CurrentUserID).put("Friends", name + ";");
                        query.get(CurrentUserID).saveInBackground();
                    }
                    //Log.d("Register3", query.get(ObjID).fetch().toString());
                    //Log.d("Register3", query.get(ObjID).);
                    //Log.d("Test2", "YOSHI2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
                else if (query.get(ObjID).getString("Username").compareTo(name) == 0) {

                    //Log.d("Register3", query.get(ObjID).getString(inputUsername));
                    //Users+= query.get(ObjID).getString(inputUsername).split(" ")[0] +";";
                    //Password = query.get(ObjID).getString(inputUsername).split(" ")[2];
                }
                else {
                    //Log.d("Register3", query.get(ObjID).getString("Username"));
                    //Users+= query.get(ObjID).getString("Username") +";";
                    //Log.d("Test2", "DIDDY2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //return Users;
    }

    public void removeFriend (String ID) {
        String CurrentUserID = "";

        //query = ParseQuery.getQuery("UserDatabase");
        ParseObject userOBJ;
        try {
            String name = query.get(ID).getString("Username");
            Log.d("Delete", name);
            //Log.d("Test2", "Users " + users);
            for(int i=0; i < users.size(); i++) {
                //ObjID = query.find().get(i).getObjectId();
                userOBJ = (ParseObject) users.get(i);
                ObjID = userOBJ.getObjectId();
                //Log.d("Test2", "UserOBJECT ID " + ObjID);
                //Log.d("Test", "size " + users.size());
                //Log.d("Test", "size query " + query.find().size());
                //Log.d("Test", "OBJ ID " + query.find().get(1).getObjectId());
                //Log.d("Test", "OBJ ID " + query.find().get(i).getObjectId());
                //Log.d("Test2", "User " + (i+1) + " " + ((ParseObject) users.get(i)).getString(inputUsername));
                //((ParseObject) users.get(i)).getString()
                //Log.d("Test", "OBJ ID 0 " + query.find().get(0).getObjectId());
                //Log.d("Register", i + " " + users.get(i).toString().split(" ")[0]);
                if(query.get(ObjID).getString("Username").compareTo(CURRENTUSER) == 0) {
                    CurrentUserID = ObjID;
                    Log.d("Delete", ObjID);
                    if (query.get(CurrentUserID).getString("Friends") != null) {
                        query.get(CurrentUserID).put("Friends", query.get(CurrentUserID).getString("Friends").replace(name+";",""));
                        query.get(CurrentUserID).saveInBackground();
                    }
                    else {

                    }
                    //Log.d("Register3", query.get(ObjID).fetch().toString());
                    //Log.d("Register3", query.get(ObjID).);
                    //Log.d("Test2", "YOSHI2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
                else if (query.get(ObjID).getString("Username").compareTo(name) == 0) {

                    //Log.d("Register3", query.get(ObjID).getString(inputUsername));
                    //Users+= query.get(ObjID).getString(inputUsername).split(" ")[0] +";";
                    //Password = query.get(ObjID).getString(inputUsername).split(" ")[2];
                }
                else {
                    //Log.d("Register3", query.get(ObjID).getString("Username"));
                    //Users+= query.get(ObjID).getString("Username") +";";
                    //Log.d("Test2", "DIDDY2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //return Users;
    }
    /**
     * Method to get a string version of current friends from database with ';' delimiters
     */
    public String getFriends (String User) {
        String Friends = "";
        //Log.d("Friendship", User);
        //query = ParseQuery.getQuery("UserDatabase");
        ParseObject userOBJ;
        try {
            //Log.d("Test2", "Users " + users);
            for(int i=0; i < users.size(); i++) {
                //ObjID = query.find().get(i).getObjectId();
                userOBJ = (ParseObject) users.get(i);
                ObjID = userOBJ.getObjectId();
                //Log.d("Test2", "UserOBJECT ID " + ObjID);
                //Log.d("Test", "size " + users.size());
                //Log.d("Test", "size query " + query.find().size());
                //Log.d("Test", "OBJ ID " + query.find().get(1).getObjectId());
                //Log.d("Test", "OBJ ID " + query.find().get(i).getObjectId());
                //Log.d("Test2", "User " + (i+1) + " " + ((ParseObject) users.get(i)).getString(inputUsername));
                //((ParseObject) users.get(i)).getString()
                //Log.d("Test", "OBJ ID 0 " + query.find().get(0).getObjectId());
                //Log.d("Register", i + " " + users.get(i).toString().split(" ")[0]);
                if(query.get(ObjID).getString("Username").compareTo(CURRENTUSER) == 0) {
                    //CurrentUserID = ObjID;
                    Friends = query.get(ObjID).getString("Friends");
                    //Log.d("Friendship", ObjID);
                    //query.get(CurrentUserID).put("Friends",query.get(CurrentUserID).getString("Friends") + name + ";");
                    //query.get(CurrentUserID).saveInBackground();
                    //Log.d("Register3", query.get(ObjID).fetch().toString());
                    //Log.d("Register3", query.get(ObjID).);
                    //Log.d("Test2", "YOSHI2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
                else {
                    //Log.d("Register3", query.get(ObjID).getString("Username"));
                    //Users+= query.get(ObjID).getString("Username") +";";
                    //Log.d("Test2", "DIDDY2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Friends;
    }
    /**
     * Method to set current user after login
     */
    public void setCURRENTUSER (String userName) {
        CURRENTUSER = userName;

    }

    /**
     * Method to update database, so that additions are reflected in query and such.
     */
    public void updateDatabase () {
        try {
            userDatabase.fetchInBackground();
            query = new ParseQuery("UserDatabase");
            users = query.find();
            Log.d("userDatabase", users.size() + " SIZE");
        } catch (ParseException e) {
            Log.d("userDatabase", "ERROR" + e.toString());
        }
    }

    /**
     * Method to get current user as string
     * @return CURRENTUSER
     */
    public String getCURRENTUSER () {
        return CURRENTUSER;

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
    *
    */
    public String getFriendID (String Username) {
        String ObjIDReturn = "NONE";
        //query = ParseQuery.getQuery("UserDatabase");
        ParseObject userOBJ;
        try {
            //Log.d("Test", "Users " + users);
            for(int i=0; i < users.size(); i++) {
                //ObjID = query.find().get(i).getObjectId();
                userOBJ = (ParseObject) users.get(i);
                ObjID = userOBJ.getObjectId();
                //Log.d("Test", "UserOBJECT ID " + ObjID);
                //Log.d("Test", "size " + users.size());
                //Log.d("Test", "size query " + query.find().size());
                //Log.d("Test", "OBJ ID " + query.find().get(1).getObjectId());
                //Log.d("Test", "OBJ ID " + query.find().get(i).getObjectId());
                //Log.d("Test", "User OBJ ID TEST" + (i+1) + " " + ((ParseObject) users.get(i)).getString(ObjID));
                //((ParseObject) users.get(i)).get("Username")
                //((ParseObject) users.get(i)).getString()
                //Log.d("Test", "OBJ ID 0 " + query.find().get(0).getObjectId());
                //Log.d("Register", i + " " + users.get(i).toString().split(" ")[0]);
                if(query.get(ObjID).getString("Username") == null) {
                    Log.d("Test", "YOSHI DID IT " + query.get(ObjID).getString("Username"));
                }
                else if (query.get(ObjID).getString("Username").compareTo(Username) == 0) {
                    //Log.d("Register", query.get(ObjID).getString("Username"));
                    ObjIDReturn = ObjID;
                }
                else {
                    Log.d("Test", "DIDDY DID IT " + query.get(ObjID).getString("Username"));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ObjIDReturn;
    }

    /**
     * Method to addFriend for logged in user to the database
     */
    public void setRating (String ID, float value) {
        String CurrentUserID = "";

        //query = ParseQuery.getQuery("UserDatabase");
        ParseObject userOBJ;
        try {
            String name = query.get(ID).getString("Username");
            Log.d("Friendship", name + " " + value);
            //Log.d("Test2", "Users " + users);
            for(int i=0; i < users.size(); i++) {
                //ObjID = query.find().get(i).getObjectId();
                userOBJ = (ParseObject) users.get(i);
                ObjID = userOBJ.getObjectId();
                //Log.d("Test2", "UserOBJECT ID " + ObjID);
                //Log.d("Test", "size " + users.size());
                //Log.d("Test", "size query " + query.find().size());
                //Log.d("Test", "OBJ ID " + query.find().get(1).getObjectId());
                //Log.d("Test", "OBJ ID " + query.find().get(i).getObjectId());
                //Log.d("Test2", "User " + (i+1) + " " + ((ParseObject) users.get(i)).getString(inputUsername));
                //((ParseObject) users.get(i)).getString()
                //Log.d("Test", "OBJ ID 0 " + query.find().get(0).getObjectId());
                //Log.d("Register", i + " " + users.get(i).toString().split(" ")[0]);
                if(query.get(ObjID).getString("Username").compareTo(CURRENTUSER) == 0) {
                    /*
                    CurrentUserID = ObjID;
                    Log.d("Friendship", ObjID);
                    if (query.get(CurrentUserID).getString("Friends") != null) {
                        query.get(CurrentUserID).put("Friends", query.get(CurrentUserID).getString("Friends") + name + ";");
                        query.get(CurrentUserID).saveInBackground();
                    }
                    else {
                        query.get(CurrentUserID).put("Friends", name + ";");
                        query.get(CurrentUserID).saveInBackground();
                    }
                    */
                    //Log.d("Register3", query.get(ObjID).fetch().toString());
                    //Log.d("Register3", query.get(ObjID).);
                    //Log.d("Test2", "YOSHI2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
                else if (query.get(ObjID).getString("Username").compareTo(name) == 0) {
                    query.get(ObjID).put("Rating", value);
                    query.get(ObjID).saveInBackground();
                    //Log.d("Register3", query.get(ObjID).getString(inputUsername));
                    //Users+= query.get(ObjID).getString(inputUsername).split(" ")[0] +";";
                    //Password = query.get(ObjID).getString(inputUsername).split(" ")[2];
                }
                else {
                    //Log.d("Register3", query.get(ObjID).getString("Username"));
                    //Users+= query.get(ObjID).getString("Username") +";";
                    //Log.d("Test2", "DIDDY2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //return Users;
    }

    public void setACTIVEFRIEND (String ID) {
        ACTIVEFRIEND = ID;

    }

    public String getACTIVEFRIEND () {
        return ACTIVEFRIEND;

    }
    /**
     * Reg_ex check on emails.
     * @param target
     * @return boolean
     */
    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
