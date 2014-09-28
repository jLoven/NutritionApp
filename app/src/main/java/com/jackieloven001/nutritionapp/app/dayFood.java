package com.jackieloven001.nutritionapp.app;


/**
 * Created by Jackie Loven on 9/28/14.
 */
public class dayFood {

    public String[] breakfast;
    public String[] lunch;
    public String[] dinner;
    public String date;
    public dayFood(String date)
    {
        this.date = date;
    }
    public String toString()
    {
        String s = "b: ";
        for(String i: breakfast)
        {
            s = s + "||" + i;
        }
        s  = s + "\nl:";
        for(String i: lunch)
        {
            s = s +"||" +  i;
        }
        s  = s + "\nd:";
        for(String i: dinner)
        {
            s = s +"||" +  i;
        }
        s  = s + "\n";
        return s;
    }
}
