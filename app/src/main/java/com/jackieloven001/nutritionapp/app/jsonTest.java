package com.jackieloven001.nutritionapp.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class jsonTest {

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = ReadBigStringIn(rd);;
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
    public static String ReadBigStringIn(BufferedReader buffIn) throws IOException {
        StringBuilder everything = new StringBuilder();
        String line;
        while( (line = buffIn.readLine()) != null) {
            everything.append(line);
        }
        return everything.toString();
    }
    public static String urlBuild(String[] list)
    {
        String url = "https://api.nutritionix.com/v1_1/search/";
        for(String s : list)
        {
            url = url + s + "&";
        }
        url = url + "?results=0:5&fields=item_name,brand_name,nf_ingredient_statement,nf_water_grams,nf_calories,nf_calories_from_fat,nf_total_fat,nf_saturated_fat,nf_monounsaturated_fat,nf_polyunsaturated_fat,nf_trans_fatty_acid,nf_cholestrol,nf_sodium,nf_total_carbohydrate,nf_dietary_fiber,nf_sugars,nf_protein,nf_vitamin_a_dv,nf_vitamin_c_dv,nf_calcium_dv,nf_iron_dv&appId=22684fe1&appKey=38d63429fd77318ac626e6b000b181cf";

        return url;
    }

    public static String urlBuild(String list)
    {
        String url = "https://api.nutritionix.com/v1_1/search/";
        url = url + list + "&";
        url = url + "?results=0:5&fields=item_name,brand_name,nf_ingredient_statement,nf_water_grams,nf_calories,nf_calories_from_fat,nf_total_fat,nf_saturated_fat,nf_monounsaturated_fat,nf_polyunsaturated_fat,nf_trans_fatty_acid,nf_cholestrol,nf_sodium,nf_total_carbohydrate,nf_dietary_fiber,nf_sugars,nf_protein,nf_vitamin_a_dv,nf_vitamin_c_dv,nf_calcium_dv,nf_iron_dv&appId=22684fe1&appKey=38d63429fd77318ac626e6b000b181cf";

        return url;
    }
    public static int distance(String a, String b)
    {
        //api.rhine.io/‹api_key›/distance/‹entity›/‹entity›
        String url = "http://api.rhine.io:8080/sdf0b913e4b07b5243b7f527/distance/";
        url  = url + a + "/";
        url = url + b;
        try {
            JSONObject dist =  new JSONObject(sendGet(url));
            return (int) dist.getInt("distance");
        } catch (Exception e) {
        }
        return 0;

    }
    private final static String USER_AGENT = "Mozilla/5.0";
    private static String sendGet(String url) throws Exception {

        //String url = "http://www.google.com/";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        return response.toString();

    }
    public static JSONObject getTopOfListData(String[] query)
    {
        String url = urlBuild(query);
        JSONObject j=null;
        try {
            j = readJsonFromUrl(url);
            JSONArray j1 = j.getJSONArray("hits");
            if(j1.length()>0)
            {
                JSONObject a = (JSONObject) j1.get(0);
                JSONObject b = (JSONObject) a.get("fields");
                return b;}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static JSONObject getTopOfListData(String query)
    {
        String[] quer = query.split(" ");
        String url = urlBuild(quer);
        JSONObject j=null;
        try {
            j = readJsonFromUrl(url);
            JSONArray j1 = j.getJSONArray("hits");
            if(j1.length()>0)
            {
                JSONObject a = (JSONObject) j1.get(0);
                JSONObject b = (JSONObject) a.get("fields");
                return b;}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] list = {"lettuce"};
        String url = urlBuild(list);
        JSONObject j=null;
        try {
            j = readJsonFromUrl(url);
            JSONArray j1 = j.getJSONArray("hits");
            JSONObject a = (JSONObject) j1.get(2);
            JSONObject b = (JSONObject) a.get("fields");
            System.out.println(((Double) b.get("nf_calories")).doubleValue()*3);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

