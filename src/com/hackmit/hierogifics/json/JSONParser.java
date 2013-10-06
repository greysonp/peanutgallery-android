package com.hackmit.hierogifics.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class JSONParser extends AsyncTask <String, Void, ArrayList<HashMap<String, String>>>
{   
    public interface JSONParserCallback {         
        void showList(ArrayList<HashMap<String, String>> result);     
    } 
    
    private JSONParserCallback mCallback;
    public JSONParser(JSONParserCallback callback) {
        mCallback =  callback;
    }    
    /* See (wherever)*/
    static InputStream is = null;
    JSONObject jObj = null;
    static String json = "";
   
    /*
     * Default...
     */
    public JSONParser(){
        
    }
    public String getStringfromUrl(String url) {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            is = httpEntity.getContent();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");              
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        return json;
    }
    
    public JSONObject getJSONfromUrl(String url) {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            is = httpEntity.getContent();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");              
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jObj;
    }
    
    
    
    @Override
    protected ArrayList<HashMap<String, String>> doInBackground(String... params)
    {
        // TODO Auto-generated method stub
        ArrayList<HashMap<String, String>> groupList = new ArrayList<HashMap<String, String>>();
        try {            
            JSONArray groups = getJSONfromUrl(params[0]).getJSONArray("groups"); // Likely to be incorrect.  TODO: update with new value
            //logic for array here
            for (int i = 0; i < groups.length(); i++) {
                JSONObject g = groups.getJSONObject(i);
                String id = g.getString("id");
                String name = g.getString("name");
                String newShares = g.getString("newShares");
                
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("name", name);
                map.put("newShares", newShares + " new comments.");
                groupList.add(map);
            }
        } catch(JSONException e) {
            
        }
        return groupList;
    }
    
    @Override
    protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
        mCallback.showList(result);
    }
    
}
