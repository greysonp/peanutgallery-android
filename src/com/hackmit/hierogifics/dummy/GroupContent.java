package com.hackmit.hierogifics.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class GroupContent
{

    /**
     * An array of group items.
     */
    public static List<GroupItem> ITEMS = new ArrayList<GroupItem>();

    /**
     * A map of group items, by ID.
     */
    public static Map<String, GroupItem> ITEM_MAP = new HashMap<String, GroupItem>();

    /**
     * NOTE: casting to static for iterations?
     */
    static {
        // Add all groups
        // TODO: change to adding each menu item for group.
        for (int i = 0; i < 2; i++) {
        addItem(new GroupItem(i + "", "Item " + i));

    
        }        
    }

    private static void addItem(GroupItem item)
    {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class GroupItem
    {
        public String id;
        public String content;

        public GroupItem(String id, String content)
        {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString()
        {
            return content;
        }
    }
}
