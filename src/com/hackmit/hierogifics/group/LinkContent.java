package com.hackmit.hierogifics.group;

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
public class LinkContent
{

    /**
     * An array of group items.
     */
    public static List<LinkItem> ITEMS = new ArrayList<LinkItem>();

    /**
     * A map of group items, by ID.
     */
    public static Map<String, LinkItem> ITEM_MAP = new HashMap<String, LinkItem>();

    /**
     * NOTE: casting to static for iterations?
     */
    static {
        // Add all links
        // TODO: change to adding each menu item for each link.
        for (int i = 0; i < 2; i++) {
        addItem(new LinkItem(i + "", "Link item " + i));

    
        }        
    }

    private static void addItem(LinkItem item)
    {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class LinkItem
    {
        public String id;
        public String content;

        public LinkItem(String id, String content)
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
