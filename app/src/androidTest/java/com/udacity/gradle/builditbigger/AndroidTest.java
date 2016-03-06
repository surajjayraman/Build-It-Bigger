package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import com.example.JokeSupplier;

import java.util.concurrent.ExecutionException;

/**
 * Created by Suraj on 28-02-2016.
 */

public class AndroidTest extends AndroidTestCase {
    public void testGetJoke() {
        String mString = (new JokeSupplier()).getAJoke();
        Log.d("Test joke supplier lib", mString);
        assertNotNull("Not getting any joke from the lib!", mString);

        try {
            String joke = new EndPointsAsycTask(this.getContext(), null, true).execute("give me the joke").get();
            assertNotNull("Not getting any joke from the lib!", joke);
            assertTrue("Exception in Async!", !joke.startsWith("EXCEPTION"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
