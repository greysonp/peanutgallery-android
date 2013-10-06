package com.hackmit.hierogifics;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
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
        link.setText("http://www.reddit.com/");
        link.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.reddit.com"));
                startActivity(intent);

            }
        });
        link.setClickable(true);
        link.setGravity(1);
        link.setPadding(0, 80, 120, 0);
        link.setTextSize(18);       
        //link.setTextAppearance(context, resid);
        ll.addView(link);
        
        // For each comment....
        TextView comment = new TextView(getActivity());
        comment.setText("I LOVE Spider-Man!");
        comment.setPadding(150, 40, 25, 150);
        comment.setTextColor(Color.parseColor("#FFFFFF"));
        comment.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        comment.setBackground(getResources().getDrawable(R.drawable.toast_frame));
        
        
        ll.addView(comment);
        
        TextView comment2 = new TextView(getActivity());
        comment2.setText("Dog");
        comment2.setPadding(150, 40, 25, 150);
        comment2.setTextColor(Color.parseColor("#FFFFFF"));
        comment2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        comment2.setBackground(getResources().getDrawable(R.drawable.toast_frame));
        ll.addView(comment2);
        
        TextView comment3 = new TextView(getActivity());
        comment3.setText("hello!");
        comment3.setPadding(150, 40, 25, 150);
        comment3.setTextColor(Color.parseColor("#FFFFFF"));
        comment3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        comment3.setBackground(getResources().getDrawable(R.drawable.toast_frame));
        ll.addView(comment3);
        
        TextView comment4 = new TextView(getActivity());
        comment4.setText("Hello!");
        comment4.setPadding(150, 40, 25, 150);
        comment4.setTextColor(Color.parseColor("#FFFFFF"));
        comment4.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        comment4.setBackground(getResources().getDrawable(R.drawable.toast_frame));
        ll.addView(comment4);
        
        
        TextView comment5 = new TextView(getActivity());
        comment5.setText("Hello!");
        comment5.setPadding(150, 40, 25, 150);
        comment5.setTextColor(Color.parseColor("#FFFFFF"));
        comment5.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        comment5.setBackground(getResources().getDrawable(R.drawable.toast_frame));
        ll.addView(comment5);
        
        TextView comment6 = new TextView(getActivity());
        comment6.setText("Tester");
        comment6.setPadding(150, 40, 25, 150);
        comment6.setTextColor(Color.parseColor("#FFFFFF"));
        comment6.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        comment6.setBackground(getResources().getDrawable(R.drawable.toast_frame));
        ll.addView(comment6);
        
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
