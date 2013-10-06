package com.hackmit.hierogifics;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
    private String url = "";
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
        
    }

    
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        /*
        View rootView = inflater.inflate(R.layout.fragment_link_detail,
                container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.group_detail))
                    .setText(mItem.content);
        }
        
        */
        
        
        ScrollView sv = new ScrollView(getActivity());
        
        LinearLayout ll = new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        
        
        TextView link = new TextView(getActivity());
        link.setText("LINK will go here");
        link.setClickable(true);
        link.setGravity(1);
        link.setPadding(0, 80, 120, 0);
        link.setTextSize(18);
        //link.setTextAppearance(context, resid);
        ll.addView(link);
        
        // For each comment....
        TextView comment = new TextView(getActivity());
        comment.setText("VERY LONG fasd;falwej;gaewligkewglihkal;wfjwaek;fhlwahg;waehgew;algjalw;ekj l;jlja;lefhw k Comment block");
        comment.setPadding(150, 25, 25, 150);
        
        comment.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        comment.setBackground(getResources().getDrawable(R.drawable.toast_frame));
        
        
        ll.addView(comment);
        
        TextView comment2 = new TextView(getActivity());
        comment2.setText("SECONDLONG fasd;falwej;gaewligkewglihkal;wfjwaek;fhlwahg;waehgew;algjalw;ekj l;jlja;lefhw k Comment block");
        comment2.setPadding(30, 10, 10, 50);
        ll.addView(comment2);
        
        /*
         for each(comment in comment array) 
           create new text view
           
         */
        /*
        EditText newComment = new EditText(getActivity());
        newComment.setText("Write a message");
        ll.addView(newComment);
        Button b = new Button(getActivity());
        b.setText("Submit");
        ll.addView(b);
        */
        //getActivity().setContentView(sv);
        sv.invalidate(); 
        sv.requestLayout(); 
        
        return sv;
    }
    
}
