package com.thr33scompany.tre.shoppingwithfriends.MVP;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.thr33scompany.tre.shoppingwithfriends.Friends.AddFriendsHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.Friends.FriendDetail;
import com.thr33scompany.tre.shoppingwithfriends.Friends.FriendsHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.LoginAndRegistration.LoggedinHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.LoginAndRegistration.LoginHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.LoginAndRegistration.RegistrationHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.Map.MapFragment;
import com.thr33scompany.tre.shoppingwithfriends.R;
import com.thr33scompany.tre.shoppingwithfriends.Registry.AddRegistryItemFragment;
import com.thr33scompany.tre.shoppingwithfriends.Registry.RegistryHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.Registry.SaleReportHolderFragment;
import com.thr33scompany.tre.shoppingwithfriends.WelcomeHolderFragment;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
/**
 * Class that acts as Model
 */
public class MainActivity extends FragmentActivity {
    //Instantiation of fragments for ShowFragment methods
    private LoginHolderFragment mLogInHolderFramgment;
    private WelcomeHolderFragment mWelcomeHolderFramgment;
    private RegistrationHolderFragment mRegistrationHolderFragment;
    private LoggedinHolderFragment mLoggedinHolderFragment;
    private FriendsHolderFragment mFriendsHolderFragment;
    private AddFriendsHolderFragment mAddFriendsHolderFragment;
    private FriendDetail mFriendDetail;
    private RegistryHolderFragment mRegistryHolderFragment;
    private AddRegistryItemFragment mAddRegistryItemFragment;
    private SaleReportHolderFragment mSaleReportHolderFragment;
    private MapFragment mMapFragment;
    //Current User for method calls in other classes
    private String CURRENTUSER;
    //Database Variables
    private ArrayList<String> Items;
    private ArrayList<String> Prices;
    //private ArrayList<String> Reporters;
    private  ArrayList Locations;
    private ParseObject userDatabase;
    private ParseQuery<ParseObject> query;
    private List users;
    private String ObjID="";
    private String ACTIVEFRIEND;

    private ParseObject Report;
    private ParseQuery ReportQuery;
    private List reports;
    private ParseObject saleReportDatabase;
    //INSTANTIATE HOLDERS
    private com.thr33scompany.tre.shoppingwithfriends.MVP.PresenterHolder PresenterHolder;
    private com.thr33scompany.tre.shoppingwithfriends.MVP.ViewHolder ViewHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewHolder = new ViewHolder();
        PresenterHolder = new com.thr33scompany.tre.shoppingwithfriends.MVP.PresenterHolder();
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
        saleReportDatabase = new ParseObject("SaleReports");
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
        ReportQuery = ParseQuery.getQuery("SaleReports");
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
     * Method to display Logged in Fragment: fragment_loggedinhome
     */
    public void showLoggedinFragment() {
            mLoggedinHolderFragment = new LoggedinHolderFragment();
            getSupportFragmentManager().beginTransaction()
            .add(R.id.container, mLoggedinHolderFragment)
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
     * Method to get ViewHolderInstance
     * @return ViewHolder
     */
    public ViewHolder getViewHolderInstance() {
        return ViewHolder;
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
     * Method to show fragment add_registryitem
     */
    public void showAddRegistryItemFragment() {
        mAddRegistryItemFragment = new AddRegistryItemFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mAddRegistryItemFragment)
                .commit();
    }

    /**
     * Method to show fragment registry
     */
    public void showRegistryHolderFragment() {
        mRegistryHolderFragment = new RegistryHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mRegistryHolderFragment)
                .commit();
    }

    /**
     * Method to show fragment Friend Detail
     */
    public void showFriendDetailFragment() {
        mFriendDetail = new FriendDetail();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mFriendDetail)
                .commit();
    }

    /**
     * Method to show fragment_salereport
     */
    public void showSaleReportHolderFragment() {
        mSaleReportHolderFragment = new SaleReportHolderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mSaleReportHolderFragment)
                .commit();
    }

    /**
     * Method to show Map Fragment: activity_map
     */
    public void showMapFragment() {
        if (mMapFragment == null) {
            mMapFragment = new MapFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mMapFragment).commit();
        }
        else {
            getSupportFragmentManager().beginTransaction()
                    .show(mMapFragment)
                    .commit();
        }
        //getSupportFragmentManager().beginTransaction().show(mMapFragment);
        /*
        if (mMapFragment == null) {
            mMapFragment = new MapFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mMapFragment)
                    .commit();
        }
/*
        if(mMapFragment != null && mMapFragment.isAdded()) {
            mMapFragment.show();
        } else {

        else {
            mMapFragment.show();
            mMapFragment.onHiddenChanged(true);
            mMapFragment.getView();
            Log.d("Test" ,"" + mMapFragment.isVisible());
        }
        */
        }

        //Intent i = new Intent(getApplicationContext(), MapFragment.class);
        //startActivity(i);
        //SupportMapFragment supportMapFragment = new SupportMapFragment();


    //}

    /**
     * Method to hide Ma Fragment
     */
    public void hideMapFragment() {
        getSupportFragmentManager().beginTransaction()
                .hide(mMapFragment)
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
     * @param inputUsername Username of user Logging in
     * @return Username
     */
    public String getUsername (String inputUsername) {
        String Username = "Available";
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
                    //Log.d("Test", "YOSHI DID IT " + query.get(ObjID).getString("Username"));
                }
                else if (query.get(ObjID).getString("Username").compareTo(inputUsername) == 0) {
                    //Log.d("Register", query.get(ObjID).getString("Username"));
                    Username = query.get(ObjID).getString("Username");
                }
                else {
                    //Log.d("Test", "DIDDY DID IT " + query.get(ObjID).getString("Username"));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Username;
    }

    /**
     * Function to get password, matches against database
     * @param inputUsername; Username of user Logging in
     * @return Password
     */
    public String getPassword (String inputUsername) {
        String Password = "";
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
                //Log.d("Test2", "User " + (i+1) + " " + ((ParseObject) users.get(i)).getString("Username"));
                //((ParseObject) users.get(i)).getString()
                //Log.d("Test", "OBJ ID 0 " + query.find().get(0).getObjectId());
                //Log.d("Register", i + " " + users.get(i).toString().split(" ")[0]);
                if(query.get(ObjID).getString("Username") == null) {
                    //Log.d("Test2", "YOSHI2 DID IT " + query.get(ObjID).getString("Username"));
                }
                else if (query.get(ObjID).getString("Username").compareTo(inputUsername) == 0) {
                    //Log.d("Register2", query.get(ObjID).getString("Username"));
                    Password = query.get(ObjID).getString("Password");
                }
                else {
                    // Log.d("Test2", "DIDDY2 DID IT " + query.get(ObjID).getString("Password"));
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
     * @param inputUsername Username of user Logging in (WILL EXCLUDE THIS USER IN STRING)
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
                    //Log.d("Register3", query.get(ObjID).getString("Username"));
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

    /**
     * Gets an array list of sale report info
     * @return Reports
     */
    public ArrayList getSaleReportInfo() {
        @SuppressWarnings("unchecked") ArrayList<ArrayList> Reports = new ArrayList<>();

        Reports.add(Items);
        Reports.add(Prices);
        Reports.add(Locations);
        //Reports.add(Reporters);

        return Reports;
    }

    /**
     * Checks the registry against current sale reports
     * @return Notify; regitry contents
     */
    public String registryCheck () {
        String Notify="";

        //Log.d("Report","hi");
        Items = new ArrayList();
        Prices = new ArrayList();
        //Reporters = new ArrayList();
        Locations = new ArrayList();
        try {
            String Registry = query.get(getFriendID(CURRENTUSER)).getString("Registry");

            reports = ReportQuery.find();
            for(int i=0; i < reports.size(); i++) {
                //ObjID = query.find().get(i).getObjectId();
                Report = (ParseObject) reports.get(i);
                ObjID = Report.getObjectId();

                // Log.d("Report", " reports " + reports);
                //Log.d("Report", " ID " + i +" " +  ObjID);
                //Log.d("Test", "size " + users.size());
                //Log.d("Test", "size query " + query.find().size());
                //Log.d("Test", "OBJ ID " + query.find().get(1).getObjectId());
                //Log.d("Test", "OBJ ID " + query.find().get(i).getObjectId());
                //Log.d("Test2", "User " + (i+1) + " " + ((ParseObject) users.get(i)).getString(inputUsername));
                //((ParseObject) users.get(i)).getString()
                //Log.d("Test", "OBJ ID 0 " + query.find().get(0).getObjectId());
                //Log.d("Register", i + " " + users.get(i).toString().split(" ")[0]);
                //Log.d("Report", "SaleReport and Registry " + ReportQuery.get(ObjID).getString("SaleReport") + query.get(getFriendID(CURRENTUSER)).getString("Registry"));
                //Log.d("Report", "SaleReport and Registry " +  query.get(getFriendID(CURRENTUSER)).getString("Registry") + "$$$$" + ReportQuery.get(ObjID).getString("SaleReport").split("-")[0]);
                //Log.d("Report", query.get(getFriendID(CURRENTUSER)).getString("Registry").contains(ReportQuery.get(ObjID).getString("SaleReport").split("-")[0]) + "");
                //Log.d("Report",query.get(getFriendID(CURRENTUSER)).getString("Registry"));

                String SaleReportItemName = ReportQuery.get(ObjID).getString("SaleReport").split("-")[0];
                String SaleReportItemPrice = ReportQuery.get(ObjID).getString("SaleReport").split("-")[1];
                String SaleReportItemLocation = ReportQuery.get(ObjID).getString("SaleReport").split("-")[2];
                //String SaleReporterID = ReportQuery.get(ObjID).getString("SaleReporter");
                //String SaleReporter = query.get(SaleReporterID).getString("Username");

                Items.add(SaleReportItemName);
                Prices.add(SaleReportItemPrice);
                //Reporters.add(SaleReporter);
                Locations.add(SaleReportItemLocation);
                //Log.d("Report", Registry );
                //Log.d("Report", SaleReportItemName );
                if (Registry != null) {
                    if (Registry.contains(SaleReportItemName)) {
                        //Log.d("Report", "hi" );
                        for (int k = 0; k < Registry.split(";").length; k++) {
                            //Log.d("Report", " TempReport " + tempReport + " $$$$ " + tempReport.compareToIgnoreCase(Registry.split(";")[k]));
                            /*
                            Log.d("Report", "Neopets-5".compareTo("Neopets-100") + " Test");
                            Log.d("Report", "Neopets-100".compareTo("Neopets-5") + " Test");
                            Log.d("Report", "Neopets-100".compareTo("Neopets-500") + " Test");
                            Log.d("Report", "Neopets-500".compareTo("Neopets-100") + " Test");
                            Log.d("Report", "100".compareTo("5") + " Test");
                            Log.d("Report", "100".compareTo("500") + " Test");
                            */
                            //Log.d("Report", SaleReportItemName);
                            if (Float.parseFloat(SaleReportItemPrice) < Float.parseFloat(Registry.split(";")[k].split("-")[1]) && !Notify.contains(SaleReportItemName + " Sale: " + SaleReportItemPrice + "$ @ " + SaleReportItemLocation + "; \n")) {
                                Log.d("Report", Notify.contains(SaleReportItemName + " Sale: " + SaleReportItemPrice + " @ " + SaleReportItemLocation + "; \n") + "");
                                Notify += SaleReportItemName + " Sale: " + SaleReportItemPrice + "$ @ " + SaleReportItemLocation + "; \n";
                            }
                        }
                    } else {
                        //Log.d("Report", "bye" );
                    }

                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("Report", "Notify "+ Notify );
        return Notify;
    }

    /**
     * Adds an item to the database under registry
     * @param itemName; Name of item to be added
     * @param threshold; Price of item to be added
     */
    public void addToRegistry (String itemName, String threshold) {
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
                    if (query.get(CurrentUserID).getString("Registry") != null) {
                        query.get(CurrentUserID).put("Registry", query.get(CurrentUserID).getString("Registry") + itemName +"-" + threshold + ";");
                        query.get(CurrentUserID).saveInBackground();
                    }
                    else {
                        query.get(CurrentUserID).put("Registry", itemName +"-" + threshold + ";");
                        query.get(CurrentUserID).saveInBackground();
                    }
                    //Log.d("Register3", query.get(ObjID).fetch().toString());
                    //Log.d("Register3", query.get(ObjID).);
                    //Log.d("Test2", "YOSHI2 DID IT " + query.get(ObjID).getString(inputUsername));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * Removes friend from user's friendslist on database
     * @param ID; Friend's Id
     */
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
    public String getFriends () {
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
     * Method to get registry contents
     * @return Registry; with ";" delimiters
     */
    public String getRegistry () {
        String Registry = "";
        //Log.d("Friendship", User);
        //query = ParseQuery.getQuery("UserDatabase");
        ParseObject userOBJ;
        try {
            //Log.d("Test2", "Users " + users);
            for(int i=0; i < users.size(); i++) {
                //ObjID = query.find().get(i).getObjectId();
                userOBJ = (ParseObject) users.get(i);
                ObjID = userOBJ.getObjectId();
                //Log.d("Report", "UserOBJECT ID " + ObjID);
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
                    Registry = query.get(ObjID).getString("Registry");
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
        return Registry;
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
            saleReportDatabase.fetchInBackground();
            userDatabase.fetchInBackground();

            ReportQuery = new ParseQuery("SaleReports");
            query = new ParseQuery("UserDatabase");

            reports = ReportQuery.find();
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

    */

    /**
     * Method to get Id of user via username from the database
     * @param Username; Username of Id you want
     * @return ObjIDReturn; Id of user if it exists.
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
                    //Log.d("Test", "YOSHI DID IT " + query.get(ObjID).getString("Username"));
                }
                else if (query.get(ObjID).getString("Username").compareTo(Username) == 0) {
                    //Log.d("Register", query.get(ObjID).getString("Username"));
                    ObjIDReturn = ObjID;
                }
                else {
                    //Log.d("Test", "DIDDY DID IT " + query.get(ObjID).getString("Username"));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ObjIDReturn;
    }

    /**
     * Method to set rating for a user via ID and float Value
     */
    public void setRating (String ID, float value) {

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

    /**
     * Way to enable correct detailed view, sets the ID to the front
     * @param ID; User Id to set active
     */
    public void setACTIVEFRIEND (String ID) {
        ACTIVEFRIEND = ID;

    }

    /**
     * Way to get the ID of current active friend in order to perform data operations
     * @return ACTIVEFRIEND
     */
    public String getACTIVEFRIEND () {
        return ACTIVEFRIEND;

    }
}
