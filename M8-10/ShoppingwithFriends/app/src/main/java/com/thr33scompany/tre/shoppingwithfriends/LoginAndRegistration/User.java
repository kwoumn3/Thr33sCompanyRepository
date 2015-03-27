package com.thr33scompany.tre.shoppingwithfriends.LoginAndRegistration;

/**
 * Created by Tre' on 2/6/2015.
 * Class to store user data
 * Default constructor used to instantiate
 */
public class User {

    private String username;
    private String email;
    private String password;
    private final String friendsList;

    /**
     * Default constructor, instantiates username, email, password and friendsList
     */
    User() {
        this.username = "";
        this.email="";
        this.password = "";
        this.friendsList = "";
    }

    /**
     * Informed constructor, instantiates variables to desired value
     * @param username; Login Username input
     * @param email; Login Email input
     * @param password; Login Password input
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

// --Commented out by Inspection START (3/26/2015 10:15 AM):
//    /**
//     * Returns User's username
//     *
//     * @return username
//     */
//    public String getUsername(){
//       return username;
//    }
// --Commented out by Inspection STOP (3/26/2015 10:15 AM)

// --Commented out by Inspection START (3/26/2015 10:16 AM):
//    /**
//     * Returns User's email
//     * @return email
//     */
//    public String getEmail(){
//        return email;
//    }
// --Commented out by Inspection STOP (3/26/2015 10:16 AM)

// --Commented out by Inspection START (3/26/2015 10:16 AM):
//    /**
//     * Returns User's password
//     * @return password
//     */
//    public String getPassword(){
//        return password;
//    }
// --Commented out by Inspection STOP (3/26/2015 10:16 AM)

// --Commented out by Inspection START (3/26/2015 10:16 AM):
//    /**
//     * Returns String of User's friends
//     * @return friendsList
//     */
//    public String getFriends(){
//        return friendsList;
//    }
// --Commented out by Inspection STOP (3/26/2015 10:16 AM)

    /**
     * Sets the User's Username
     * @param newUsername; New Username
     */
    public void setUsername(String newUsername){
        username = newUsername;
    }

    /**
     * Sets the User's Email
     * @param newEmail; New Email
     */
    public void setEmail(String newEmail){
        email = newEmail;
    }

    /**
     * Sets the User's Password
     * @param newPassword; New Password
     */
    public void setPassword(String newPassword){
        password = newPassword;
    }

// --Commented out by Inspection START (3/26/2015 10:16 AM):
//    /**
//     * Adds a friend to the User's FriendsList with ';' delimiters
//     * @param newFriend
//     */
//    public void setFriend(User newFriend){
//        friendsList = friendsList + newFriend + ";";
//    }
// --Commented out by Inspection STOP (3/26/2015 10:16 AM)

}
