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
    
    // Other needed fields.
    //private final String groupName = "";
    //private final String groupName = "";
    //private final String groupName = "";    
    //private final String groupName = "";
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
    /*
    @Override
    public void onResume() {
        super.onResume();
        uiHelper.onResume();
        isResumed = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
        isResumed = false;
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }
    
    private void showFragment(int fragmentIndex, boolean addToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        for (int i = 0; i < fragments.length; i++) {
            if (i == fragmentIndex) {
                transaction.show(fragments[i]);
            } else {
                transaction.hide(fragments[i]);
            }
        }
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
    
    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        // Only make changes if the activity is visible
        if (isResumed) {
            FragmentManager manager = getSupportFragmentManager();
            // Get the number of entries in the back stack
            int backStackSize = manager.getBackStackEntryCount();
            // Clear the back stack
            for (int i = 0; i < backStackSize; i++) {
                manager.popBackStack();
            }
            if (state.isOpened()) {
                // If the session state is open:
                // Show the authenticated fragment
                showFragment(SELECTION, false);
            } else if (state.isClosed()) {
                // If the session state is closed:
                // Show the login fragment
                showFragment(SPLASH, false);
            }
        }
    }
    
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        Session session = Session.getActiveSession();

        if (session != null && session.isOpened()) {
            // if the session is already open,
            // try to show the selection fragment
            showFragment(SELECTION, false);
        } else {
            // otherwise present the splash screen
            // and ask the person to login.
            showFragment(SPLASH, false);
        }
    }
    
    private UiLifecycleHelper uiHelper;
    private Session.StatusCallback callback = 
        new Session.StatusCallback() {
        @Override
        public void call(Session session, 
                SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };
    */
}
