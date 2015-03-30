package com.thr33scompany.tre.shoppingwithfriends;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.thr33scompany.tre.shoppingwithfriends.MVP.MainActivity;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void checkRemoveFriend() {

        MainActivity check = new MainActivity();
        check.addFriend("Gabe");
        check.addFriend("Frank");
        check.addFriend("Bob");

        assertEquals("GabeFrankBob", check.getFriends());

        check.removeFriend("Gabe");
        bool 
        boolean bool = true;
        //
        if (check.getFriends().contains("Gabe")) {
            bool = false;
        }
        assertEquals(bool, true);

        if (check.getFriends().length() != "Frank".length() + "Bob".length()) {
            bool = false;
        }

        assertEquals(bool, true);
        assertEquals(check.getFriends(), "FrankBob");

        check.removeFriend("Billy");
        if (check.getFriends().length() != "Frank".length() + "Bob".length()) {
            bool = false;
        }
        assertEquals(bool, true);
        assert
    }

}