package com.hackmit.hierogifics;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.hackmit.hierogifics.GroupListFragment.Callbacks;
import com.hackmit.hierogifics.group.GroupContent;
import com.hackmit.hierogifics.json.JSONParser;
import com.hackmit.hierogifics.json.JSONParser.JSONParserCallback;

/**
 * A fragment representing a single Group detail screen. This fragment is either
 * contained in a {@link GroupListActivity} in two-pane mode (on tablets) or a
 * {@link GroupDetailActivity} on handsets.
 */
public class GroupDetailFragment extends ListFragment implements JSONParserCallback
{
    private static final String STATE_ACTIVATED_POSITION = "activated_position";
    private int mActivatedPosition = ListView.INVALID_POSITION;
    private String mGroup = ""; 
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    
    private Callbacks mCallbacks = sGroupCallbacks;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GroupDetailFragment()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        mGroup = "523462641001709";
        
        String url = "http://whispering-sierra-9270.herokuapp.com/?getPages=";
        if (mGroup.equals("")) {
            //noGroupsFound();
        } else {
            JSONParser parser = new JSONParser(this);
            try {
                parser.execute(url + mGroup);
            } catch (Exception e) {
                //noGroupsFound();
            }
        }
        
    }

    public interface Callbacks
    {
        /**
         * Callback for when an item has been selected.
         */
        public void onItemSelected(String id);
    }

    /**
     * A dummy implementation of the {@link Callbacks} interface that does
     * nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sGroupCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(String id)
        {
        }
    };
    
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException(
                    "Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }
    
    @Override
    public void onDetach()
    {
        super.onDetach();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sGroupCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position,
            long id)
    {
        super.onListItemClick(listView, view, position, id);

        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        mCallbacks.onItemSelected(GroupContent.ITEMS.get(position).id);
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            // Serialize and persist the activated item position.
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be
     * given the 'activated' state when touched.
     */
    public void setActivateOnItemClick(boolean activateOnItemClick)
    {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        getListView().setChoiceMode(
                activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
                        : ListView.CHOICE_MODE_NONE);
    }

    
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState
                    .getInt(STATE_ACTIVATED_POSITION));
        }
    }
    
    private void setActivatedPosition(int position)
    {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }
    
    
    @Override
    public void showList(JSONObject result)
    {
        ArrayList <HashMap<String, String>> pageList = new ArrayList<HashMap<String, String>>();
        try {
            JSONArray pages = result.getJSONArray("pages");
        
            for (int i = 0; i < pages.length(); i++){
            
            JSONObject p = pages.getJSONObject(i);
            
            String id = p.getString("id");
            String title = p.getString("title");
            String url = p.getString("url");
            String create_date = p.getString("date");
            String numComments = p.getString("numComments");
            //JSONArray last_comment = p.getJSONArray("lastComment");
            //JSONArray author = p.getJSONArray("author");
            //String author_id = author.getString(0);
            //String author_firstname = author.getString(1);
            //String author_lastname = author.getString(2);
            
            //String comment_body = last_comment.getString(0);                        
            //String last_date = last_comment.getString(1);
            //JSONArray last_author = last_comment.getJSONArray(2);
            //String comment_firstname = last_author.getString(0);
            //String comment_lastname = last_author.getString(1);
            
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("title", title);
            map.put("author", "By " + " " + " on " + create_date + ".");
            //map.put("author", "By " + author_firstname + " " + author_lastname + " on " + create_date + ".");
map.put("comment", "");            //map.put("comment", comment_body + "");
map.put("comment_author", "");
            //map.put("comment_author", "By " + comment_firstname + " " + comment_lastname + " on " + last_date + ".");
            map.put("num_comments", numComments + " comments");
            pageList.add(map);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
        //notify dataset changed!!
        ListAdapter adapter = new SimpleAdapter(getActivity(), pageList, R.layout.page_item_list, 
                new String [] {"title", "author", "comment", "comment_author", "num_comments"}, 
                new int [] {R.id.page_name, R.id.author, R.id.comment, R.id.comment_author, R.id.num_comments});   
        setListAdapter(adapter);
    }
    
    void noGroupsFound() {
        ArrayList <HashMap<String, String>> pageList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title", "Nothing found here...");
        map.put("author", "");
        map.put("comment", "");
        map.put("comment_author", "");
        map.put("num_comments", "");
        pageList.add(map);
        ListAdapter adapter = new SimpleAdapter(getActivity(), pageList, R.layout.page_item_list, 
                new String [] {"title", "author", "comment", "comment_author", "num_comments"}, 
                new int [] {R.id.page_name, R.id.author, R.id.comment, R.id.comment_author, R.id.num_comments});   
        setListAdapter(adapter);
    }
    
}
