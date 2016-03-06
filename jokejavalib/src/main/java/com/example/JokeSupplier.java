package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeSupplier {
    private List<String> jokes=new ArrayList<String>();

    public JokeSupplier(){
        jokes.add(0, "A skeleton walks into a bar, orders a beer, and a mop");
        jokes.add(1,"They say that the first Black Hole was discovered in 1916, but marriage has been around a lot longer than that.");
        jokes.add(2,"The colors Red, White and Blue represent freedom -  Until they're flashing behind you.");
        jokes.add(3,"I hate people who say 'Age is just a number' — Age is clearly a word.");
        jokes.add(4,"Now-a-Days People Need a Stable Internet Connection More Than The Stable Relationships.");
    }

    public String getAJoke(){
        Random random=new Random();
        return jokes.get(random.nextInt(5));
    }
}
