package com.thr33scompany.tre.shoppingwithfriends;

import java.util.ArrayList;

import com.parse.ParseObject;
import com.parse.ParseUser;
/**
 * Created by Tre' on 2/6/2015.
 * Class to store user data
 * Default constructer used to instantiate
 */
public class User {

    private String username;
    private String email;
    private String password;
    private String friendsList;

    /**
     * Default constructer, instantiates username, email, password and friendsList
     */
    User() {
        this.username = "";
        this.email="";
        this.password = "";
        this.friendsList = "";
    }

    /**
     * Informed constructer, instantiates variables to desired value
     * @param username
     * @param email
     * @param password
     */
    User(String username, String email, String password) {
        this.username = username;
        this.email=email;
        this.password = password;
        this.friendsList = "";
    }

    @Override
    public String toString(){
        return username + " " + email + " " + password + " " + friendsList;
    }

    /**
     * Returns User's username
     *
     * @return username
     */
    public String getUsername(){
       return username;
    }

    /**
     * Returns User's email
     * @return email
     */
    public String getEmail(){
        return email;
    }

    /**
     * Returns User's password
     * @return password
     */
    public String getPassword(){
        return password;
    }

    /**
     * Returns String of User's friends
     * @return friendsList
     */
    public String getFriends(){
        return friendsList;
    }

    /**
     * Sets the User's Username
     * @param newUsername
     */
    public void setUsername(String newUsername){
        username = newUsername;
    }

    /**
     * Sets the User's Email
     * @param newEmail
     */
    public void setEmail(String newEmail){
        email = newEmail;
    }

    /**
     * Sets the User's Password
     * @param newPassword
     */
    public void setPassword(String newPassword){
        password = newPassword;
    }

    /**
     * Adds a friend to the User's FriendsList with ';' delimiters
     * @param newFriend
     */
    public void setFriend(User newFriend){
        friendsList = friendsList + newFriend + ";";
    }

}
