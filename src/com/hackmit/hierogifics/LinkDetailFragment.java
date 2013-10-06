package com.hackmit.hierogifics;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.hackmit.hierogifics.group.GroupContent;

public class LinkDetailFragment extends Fragment
{
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
    public LinkDetailFragment()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            //THIS NEEDS TO LOAD SOMETHING
            
            
        }
        /*
        ScrollView sv = new ScrollView(getActivity());
        LinearLayout ll = new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        
        
        TextView link = new TextView(getActivity());
        link.setText("LINK will go here");
        ll.addView(link);
        
        EditText newComment = new EditText(getActivity());
        newComment.setText("Write a message");
        ll.addView(newComment);
        Button b = new Button(getActivity());
        b.setText("Submit");
        ll.addView(b);
        getActivity().setContentView(sv);       */ 
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_link_detail,
                container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.group_detail))
                    .setText(mItem.content);
        }

        return rootView;
    }
    
}
