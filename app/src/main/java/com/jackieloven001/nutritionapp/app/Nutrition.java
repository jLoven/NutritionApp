package com.jackieloven001.nutritionapp.app;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.*;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class Nutrition {
    private String gender; private int age; private int weightkg; private int heightcm;
    private double proteinReq;private int baseMeta;
    private ArrayList<String> breakfastfoods ;
    private int breakfastindex = 0;
    private int lunchindex = 0;
    private int vegindex = 0;
    private final static String breakfoods = "Breadfruit\n" +
            "Porridge\n" +
            "Hash (food) \n" +
            "Egg (food)\n" +
            "Full breakfast\n" +
            "Youtiao\n" +
            "Yogurt\n" +
            "English muffin\n" +
            "Cream pie\n" +
            "Soy milk \n" +
            "Grits\n" +
            "Oatmeal\n" +
            "Barley honey \n" +
            "Toast\n" +
            "Popover\n" +
            "Ham\n" +
            "Salmon (food)\n" +
            "Bagel \n" +
            "Orange juice \n" +
            "Banana \n" +
            "Chicken curry\n" +
            "Boiled egg \n" +
            "Bacon\n" +
            "Fruit\n" +
            "Shrimp (food) \n" +
            "Pancake\n" +
            "Raisin bread\n" +
            "Maple syrup \n" +
            "French toast\n" +
            "Portuguese sweet bread\n" +
            "Fried egg\n" +
            "Scrapple\n" +
            "Fried bread\n" +
            "Cereal bar\n" +
            "Scrambled eggs\n" +
            "Honey \n" +
            "Waffle\n" +
            "Lox \n" +
            "Bacon sandwich\n" +
            "Popcorn cereal\n" +
            "Croissant\n" +
            "Bing (bread)\n" +
            "Toaster Strudel\n" +
            "Breakfast burrito \n" +
            "Baked beans \n" +
            "Bacon, egg and cheese sandwich \n" +
            "Toaster pastry\n" +
            "Poached egg\n" +
            "Pain aux raisins\n" +
            "Breakfast sausage \n" +
            "Sausage\n" +
            "Pudding-Irish\n" +
            "Potato cake\n" +
            "Breakfast cereal\n" +
            "Creamed eggs on toast \n" +
            "Griddle scone\n" +
            "Fruit pudding\n" +
            "Pastry\n" +
            "Tomato omelette\n" +
            "Scone\n" +
            "Potato scone\n" +
            "Egg sandwich\n" +
            "Cinnamon roll\n" +
            "Palm syrup\n" +
            "Strudel \n" +
            "Breakfast sandwich \n" +
            "Pain au chocolat\n" +
            "Egg in the basket\n" +
            "Biscuits and gravy \n" +
            "Sticky bun \n" +
            "Hash browns \n" +
            "Chocolate sandwich\n" +
            "Black Pudding\n" +
            "Eggs Benedict\n" +
            "Slinger \n" +
            "Peanut butter \n" +
            "Omelette \n" +
            "Indian omelette \n" +
            "Breakfast roll \n";
    private final static String lfoods = "Grilled Steak\n" +
            "Chicken Cacciatore\n" +
            "Pan fried Tilapia\n" +
            "Black Bean Soup\n" +
            "Steamed Shrimp\n" +
            "Crock Pot Salsa Chicken\n" +
            "Teriyaki Grilled Chicken\n" +
            "My Homemade Vegetable Soup\n" +
            "Crock Pot Santa Fe Chicken  (Skinnytaste)\n" +
            "Chicken Parmesan\n" +
            "Spaghetti\n" +
            "Shrimp Creole\n" +
            "Dutch Puff (A Delightful Home)\n" +
            "Scrambled Eggs\n" +
            "Spaghetti Pie (Cooks.com)\n" +
            "Black Bean Salad\n" +
            "Sauteed Shrimp\n" +
            "Slow-Cooker Saucy Swiss Steak (Kraft)\n" +
            "Lasagna Roll Ups\n" +
            "Asian Flank Steak Skewers (Skinnytaste)\n" +
            "Baked Ham\n" +
            "Grilled Burgers\n" +
            "Shrimp & Grits (My Recipes)\n" +
            "Beef Enchiladas\n" +
            "Crock Pot Pulled Pork\n" +
            "Meatloaf\n" +
            "Stuffed Shells (Kraft)\n" +
            "New Orleans Chicken Salad\n" +
            "Candied Chicken (Dinner is Ready)\n" +
            "Cajun Chicken Wraps\n" +
            "Honey Lime Chicken (Dinner is Ready)\n" +
            "Chicken Spaghetti\n" +
            "Roast Chicken\n" +
            "Red Beans & Rice\n" +
            "Chicken Noodle Soup\n" +
            "Boiled Shrimp\n" +
            "Fried Shrimp\n" +
            "Macaroni & Cheese\n" +
            "Stuffed Baked Potatoes\n" +
            "Sloppy Joes\n" +
            "Tortilla Pie\n" +
            "Beef Stew\n" +
            "Navajo Tacos (Dinner is Ready)\n" +
            "Four Cheese Baked Penne (Food Network)\n" +
            "Beefy Spanish Rice (Dinner is Ready)\n" +
            "Grilled Chicken Burritos\n" +
            "Chicken & Dumplings\n" +
            "Lasagna with Italian Sausage\n" +
            "Grilled Chicken Salad\n" +
            "Berry Topped Waffles\n" +
            "Meatball Calzones\n" +
            "Crock Pot Italian Roast Beef\n" +
            "Chicken Curry (My Recipes)\n" +
            "Macaroni Pie\n" +
            "Chicken & Wild Rice Casserole\n" +
            "Grilled Cheese Sandwiches\n" +
            "Hot Dogs\n" +
            "Omelets\n" +
            "Chicken Quesadillas\n" +
            "Vegetarian Pasta E Fagioli (Food.com)\n" +
            "Mexican Lasagna\n" +
            "Turkey Sliders\n" +
            "Potato Soup\n" +
            "Spicy Black Eyed Pea Soup\n" +
            "Homemade Chicken Strips\n" +
            "Homemade Bubble Crust Pizza\n" +
            "Sweet Chicky Nuggets (My Name Is Snickerdoodle)\n" +
            "Crawfish Etouffee\n" +
            "Jerk Flavored Pork Tenderloin\n" +
            "Chicken Souvlaki (Allrecipes)\n" +
            "Chili\n" +
            "Veggie Lasagna\n" +
            "Chicken Pot Pie\n" +
            "Southwestern Cheese Panini (Eating Well)\n" +
            "Pepper Steak\n" +
            "Roasted Tomato-and-Feta Shrimp (My Recipes)\n" +
            "Shrimp Tacos\n" +
            "Muffalettas\n" +
            "Pancakes (Allrecipes)\n" +
            "Grilled Ham & Cheese Sandwiches\n" +
            "Fish Tacos\n" +
            "Veggie Pizza\n" +
            "Pepperoni Pizza\n" +
            "Greek-Style Chicken & Pasta\n" +
            "Bacon, Lettuce & Tomato Sandwiches\n" +
            "Taco Salad\n" +
            "Meatball Subs\n" +
            "Reubens\n" +
            "Lightened Hot Browns (My Recipes)\n" +
            "Grilled Pork Chops\n" +
            "Cheese Pizza\n" +
            "Corkscrew Chicken (Dinner is Ready)\n" +
            "Beef Tacos\n" +
            "Chili Dogs\n" +
            "Jambalaya\n" +
            "Clam Sauce & Linguine \n" +
            "Pasta Alfredo\n";
    private final static String vfoods="Sweet potato\n" +
            "Spinach\n" +
            "Butternut squash\n" +
            "Collard greens\n" +
            "Endive\n" +
            "Peppers\n" +
            "Red Pepper\n" +
            "Carrot\n" +
            "Broccoli\n" +
            "Carrots\n" +
            "Bok choy \n" +
            "Mustard greens\n" +
            "Brussels sprouts\n" +
            "Lettuce \n" +
            "Chard\n" +
            "Fiddleheads\n" +
            "Peas\n" +
            "Potato\n" +
            "Turnip\n" +
            "Cabbage\n" +
            "Asparagus\n" +
            "Rhubarb\n" +
            "Okra\n" +
            "Radish\n" +
            "Lentils\n" +
            "Green beans\n" +
            "Soy beans\n" +
            "Artichoke\n" +
            "Amaranth\n" +
            "Green Onion\n" +
            "Bean sprouts\n" +
            "Tomato\n" +
            "Cauliflower\n" +
            "Garlic\n" +
            "Shallot\n" +
            "Onion\n" +
            "Kidney beans\n" +
            "Pinto beans\n" +
            "Yam\n" +
            "Parsley\n" +
            "Ginger\n" +
            "Celery\n" +
            "Frisee\n" +
            "Chives\n" +
            "Mushrooms\n" +
            "Green pepper\n" +
            "Parsnip\n" +
            "Runner beans\n" +
            "Eggplant\n" +
            "Lima beans or Butter bean\n" +
            "Black-eyed peas\n" +
            "Corn\n" +
            "Beet\n" +
            "Corn salad\n" +
            "Calabrese\n" +
            "Chickpeas\n" +
            "Nettles\n";
    private ArrayList<String> lunchfoods ;
    private ArrayList<String> vegtfoods ;
    private ArrayList<String> blackList ;
    private ArrayList<String> whiteList ;
    private ArrayList<String> reqlist;
    private ArrayList<JSONObject> whiteListJSON;
    private ArrayList<JSONObject> required;
    private ArrayList<dayFood> days;
    public Nutrition(String gender, int age, int weightkg, int heightcm)
    {
        breakfastfoods = new ArrayList<String>();
        String[] temp = breakfoods.split("\n");
        for(String i :temp)
        breakfastfoods.add(i);
        lunchfoods = new ArrayList<String>();
        temp = lfoods.split("\n");
        for(String i :temp)
            lunchfoods.add(i);
        vegtfoods = new ArrayList<String>();
        temp = vfoods.split("\n");
        for(String i :temp)
            vegtfoods.add(i);
        blackList = new ArrayList<String>();
        whiteList = new ArrayList<String>();
        reqlist = new ArrayList<String>();
        whiteListJSON = new ArrayList<JSONObject>();
        required = new ArrayList<JSONObject>();
        days = new ArrayList<dayFood>();
        this.gender = gender;
        this.age = age;
        this.weightkg=weightkg;
        this.heightcm=heightcm;
        baseMeta = baseMeta();
        proteinReq = getProteinReq();

    }
    public ArrayList<dayFood> results()
    {
        return days;
    }
    public String classify(String s)
    {
        int distanceToBreakfast = jsonTest.distance(s, "breakfast");
        int distanceToLunch = jsonTest.distance(s, "food");
        int distanceToDessert = jsonTest.distance(s, "dessert");
        //System.out.println("Breakfast distance: " + distanceToBreakfast + " distance lunch: " + distanceToLunch + " distance to desert " + distanceToDessert);
        if(distanceToBreakfast<distanceToLunch)
        {
            if(distanceToBreakfast<distanceToDessert)
            {
                //System.out.println("FINALLY BREAKFAST");
                return "breakfast";
            }
            else if (distanceToDessert<distanceToLunch)
                return "dessert";
        }
        else if (distanceToLunch<distanceToDessert)
            return "lunch";

        return "dessert";

    }
    public double getListCal(ArrayList<JSONObject> j) throws Exception
    {
        double calorieTotal = 0;
        for(JSONObject i :j)
            try{
                calorieTotal+=((Double) i.get("nf_calories")).doubleValue();
            }catch(Exception e)
            {
                calorieTotal+=((Integer) i.get("nf_calories")).intValue();
            }

        return calorieTotal;
    }
    public double getListCarbs(ArrayList<JSONObject> j) throws Exception
    {
        double calorieTotal = 0;
        for(JSONObject i :j)
            try{
                calorieTotal+=((Double) i.get("nf_total_carbohydrate")).doubleValue();
            }catch(Exception e)
            {
                calorieTotal+=((Integer) i.get("nf_total_carbohydrate")).intValue();
            }

        return calorieTotal;
    }
    //public boolean inList(ArrayList<Integer>, int  )
    public String[] getMeal(ArrayList<JSONObject> list1, String type) throws Exception
    {
        ArrayList<JSONObject> meal = new ArrayList<JSONObject>();
        ArrayList<JSONObject> list = (ArrayList<JSONObject>) list1.clone();
        ArrayList<JSONObject> secondary  = (ArrayList<JSONObject>) required.clone();
        for(int i = 0; i<secondary.size(); i++)
        {
            if(!classify((String) secondary.get(i).get("item_name")).equals(type))
            {
                secondary.remove(i); i--;
            }
        }
        Random gen = new Random();
        if(secondary.size()>0){
            int index = gen.nextInt(secondary.size());
            meal.add(secondary.get(index));}
        double calCap = baseMeta/3;
        //System.out.println("Calorie Cap: " + calCap);
        //System.out.println("Calories for:"  + getListCal(meal));
        if(getListCal(meal)<calCap&&getListCarbs(meal)<130.0/3.0)
        {
            int cont = 1;
            while(cont==1)
            {
                cont = 0;
                //System.out.println(list.size());
                for(int i = 0; i<list.size(); i++)
                {
                    //System.out.println("I'm fucking here!");
                    double cal = 0;
                    double carbs =0;
                    try{
                        cal = getListCal(meal)+(Double)(list.get(i).get("nf_calories"));
                    }catch(Exception e)
                    {
                        cal = getListCal(meal)+(Integer)(list.get(i).get("nf_calories"));
                    }
                    try{
                        carbs = getListCarbs(meal)+(Double)list.get(i).get("nf_total_carbohydrate");
                    }catch(Exception e)
                    {
                        carbs = getListCarbs(meal)+(Integer)list.get(i).get("nf_total_carbohydrate");
                    }
                    //System.out.println("Attempted Calories: " + cal);
                    if (cal<calCap&& carbs <130.0/3.0)
                    {
                        meal.add(list.get(i));
                        list.remove(i);
                        i--;
                        cont = 1;
                    }
                }

            }
        }
        String[] out = new String[meal.size()];
        for(int i = 0; i<out.length; i++)
        {
            out[i]=(String) meal.get(i).get("item_name");
        }
        return out;
    }
    public void pushFood(String name, boolean choice) throws Exception
    {
        if(!choice)
            blackList.add(name);
        else if (whiteList.size()>reqlist.size()*5)
        {
            Random gen = new Random();
            ArrayList<JSONObject> bklist = new ArrayList<JSONObject>();
            ArrayList<JSONObject> lunchlist = new ArrayList<JSONObject>();
            ArrayList<JSONObject> dinnerlist = new ArrayList<JSONObject>();
            for(int i = 0; i<whiteList.size(); i++)
            {
                String classified = classify(whiteList.get(i));
                if (classified.equals("breakfast"))
                {
                    bklist.add(whiteListJSON.get(i));
                }else if (classified.equals("lunch"))
                {
                    if(gen.nextBoolean())
                        lunchlist.add(whiteListJSON.get(i));
                    else
                        dinnerlist.add(whiteListJSON.get(i));
                }
            }
            dayFood food = new dayFood("1");
            System.out.println(" bklist length" + bklist.size());
            food.breakfast=getMeal(bklist,"breakfast");
            food.lunch=getMeal(lunchlist,"lunch");
            food.dinner=getMeal(dinnerlist,"dessert");
            days.add(food);

            //TODO Add rhine classification of whiteListJSON and whiteList
        }
        else
        {
            whiteList.add(name);
            whiteListJSON.add(jsonTest.getTopOfListData(name));
        }
    }
    public String pullFood()
    {
        Random generator = new Random();
        int number = generator.nextInt(3);
        if(number==0)
        {
            breakfastindex++;
            return breakfastfoods.get(breakfastindex-1);
        }else if (number ==1)
        {
            lunchindex++;
            return lunchfoods.get(lunchindex-1);
        }else
        {
            vegindex++;
            return vegtfoods.get(vegindex-1);
        }

    }
    public int baseMeta()
    {
        if (gender.equals("F"))
        {
            return (int) (10 * weightkg + 6.25 * heightcm - 5 * age - 161);
        }
        else
        {
            return (int) (10 * weightkg + 6.25 * heightcm - 5 * age + 5);
        }
    }
    public void addReq(String s)
    {
        reqlist.add(s);
        required.add(jsonTest.getTopOfListData(s));
    }

    public void addBlack(String s)
    {
        blackList.add(s);
    }
    public void addWhite(String s)
    {
        whiteList.add(s);
        whiteListJSON.add(jsonTest.getTopOfListData(s));
    }
    public double getProteinReq()
    {
        if (age<=8)
        {
            if(age<=3)
            {
                return 0.87*weightkg;
            }
            return 0.76*weightkg;
        }
        if(age<=13)
        {
            return 0.76*weightkg;
        }
        else if (age<=18)
        {
            if(gender.equals("M"))
                return 0.73*weightkg;
            else return 0.71*weightkg;
        }
        return 0.66*weightkg;

    }
    public static ArrayList<String> listMembers(String filename)
    {
        ArrayList<String> out = new ArrayList<String>();
        //try{
            // Open the file that is the first
            // command line parameter
            /*InputStream fstream = resources.getAssets().open(filename);
            // Get the object of DataInputStream
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
                out.add(strLine);
            }
            //Close the input stream
            fstream.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }*/
        Scanner reader = null;
        try {
            reader = new Scanner(new File(filename));
        } catch (Exception e) {
            //Log.d("damn", "FAIL");
        }
        if(reader != null)
            Load(reader);

        return out;
    }
    private static void Load(Scanner reader) {
        while (reader.hasNext()) {
            String result = reader.next();
            if (result == "KEY") {   // may be  result.equalsignorecase
                while (result != "KEYEND") {
                    int index = reader.nextInt();
                    //Log.d("Index", String.valueOf(index));
                }
            }
        }
        reader.close();
    }
    public static String readIO(String prompt)
    {
        System.out.print(prompt);

        //  open up standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String userName = null;

        //  read the username from the command-line; need to use try/catch with the
        //  readLine() method
        try {
            userName = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        return userName;
    }
    /*public static void main(String[] args)
    {
        Nutrition n = new Nutrition("M", 18, 80, 175);
        boolean cont = true;
        while(cont)
        {
            String in = readIO("Add a Requirement:");
            n.addReq(in);
            in = readIO("Do you want to add more?");
            if(!in.equals("y"))
                cont = false;
        }
        cont = true;
        while(cont)
        {
            String foodname = n.pullFood();
            String in = readIO("Do you want " + foodname + " ? ");
            if(in.equals("y"))
            {
                n.pushFood(foodname, true);
            }
            else n.pushFood(foodname,  false);
            if(n.results().size()>0)
                System.out.println(n.results().get(0));
        }
    }*/
}
