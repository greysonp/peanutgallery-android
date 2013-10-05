package com.hackmit.hierogifics;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.hackmit.hierogifics.group.GroupContent;

/**
 * A fragment representing a single Group detail screen. This fragment is either
 * contained in a {@link GroupListActivity} in two-pane mode (on tablets) or a
 * {@link GroupDetailActivity} on handsets.
 */
public class GroupDetailFragment extends ListFragment
{
    private static final String STATE_ACTIVATED_POSITION = "activated_position";
    private int mActivatedPosition = ListView.INVALID_POSITION;
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private GroupContent.GroupItem mItem;

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

        ArrayList <Page> pageList = new ArrayList<Page>();
        //make pages here from incoming data...
        pageList.add(new Page());
        //notify dataset changed!!
        //ListAdapter adapter = new SimpleAdapter(this, pageList, R.layout.page_item_list, 
         //       new String [] {R.id.page_title, R.id.page_url, R.id.page_date, R.id.last_lauthor, R.id.last_fauthor
          //                     R.id.current_lauthor, R.id.current_fauthor}, 
           //     new int [] {R.id.page_name, R.id.page_, R.id.last_comment_id, R.id.current_comment_id});   
        setListAdapter(new ArrayAdapter<Page>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1, pageList));
        /*
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            
            //load content from ARG_ITEM_ID
            mItem = GroupContent.ITEM_MAP.get(getArguments().getString(
                    ARG_ITEM_ID));
        } */
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
    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_group_detail,
                container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.group_detail))
                    .setText(mItem.content);
        }

        return rootView;
    }
    */
    class Page {
        int id;
        String title;
        String url;
        String date; // for now?        
        int commentCount; //number of comments
        Author aPage;
        
        Page() {
            
        }
        Page(int i, String title, String url, String date, int cNum, Author a) {
            
        }
               
        //last comment {}
        class LastComment{
            String body;
            String date; // for now
            Author aComment;
            LastComment() {
                
            }
        }
        class Author {
            int id;
            String firstname;
            String lastname;
            Author() {
                
            }
        }
              
    }
    
}
