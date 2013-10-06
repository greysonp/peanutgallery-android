package com.hackmit.hierogifics;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * An activity representing a list of Groups. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link GroupDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link GroupListFragment} and the item details (if present) is a
 * {@link GroupDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link GroupListFragment.Callbacks} interface to listen for item selections.
 */
public class GroupListActivity extends FragmentActivity implements
        GroupListFragment.Callbacks
{
    static final String appId = "307234779396415";
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    
    private boolean mTwoPane;
    
    private final String REQUEST_URL = "";
    
    private final String GROUP_NAME = "";
    private static final int SPLASH = 0;
    private static final int SELECTION = 1;
    private static final int FRAGMENT_COUNT = SELECTION +1;
    private boolean isResumed = false;
    private Fragment[] fragments = new Fragment[FRAGMENT_COUNT];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_group_list);
       
       
        /*
        FragmentManager fm = getSupportFragmentManager();
        fragments[SPLASH] = fm.findFragmentById(R.id.splashFragment);
        fragments[SELECTION] = fm.findFragmentById(R.id.selectionFragment);

        FragmentTransaction transaction = fm.beginTransaction();
        for(int i = 0; i < fragments.length; i++) {
            transaction.hide(fragments[i]);
        }
        
        transaction.commit();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(savedInstanceState);
        */
        if (findViewById(R.id.group_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((GroupListFragment) getSupportFragmentManager().findFragmentById(
                    R.id.group_list)).setActivateOnItemClick(true);
        }
        
        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link GroupListFragment.Callbacks} indicating that
     * the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id)
    {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(GroupDetailFragment.ARG_ITEM_ID, id);
            GroupDetailFragment fragment = new GroupDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.group_detail_container, fragment).commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, GroupDetailActivity.class);
            detailIntent.putExtra(GroupDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);

        }
    }
}
