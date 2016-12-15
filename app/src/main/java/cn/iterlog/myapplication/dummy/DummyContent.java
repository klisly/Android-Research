package cn.iterlog.myapplication.dummy;

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
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        addItem(new DummyItem(String.valueOf(1), "Activity生命周期理解", "主要分成如下几个部分：" +
                "1、Activity的正常生命周期分析；不同情况下，Activity的调用过程：从Home键前台退到后台，按Back键退出，启动新的Activity，启动AlertDialog，启动Fragment，Fragment"));
        addItem(new DummyItem(String.valueOf(2), "Activity转场动画", ""));
        addItem(new DummyItem(String.valueOf(3), "Widget", ""));
        addItem(new DummyItem(String.valueOf(4), "Custom View ", ""));
        addItem(new DummyItem(String.valueOf(5), "Notification", ""));
        addItem(new DummyItem(String.valueOf(6), "Service", ""));
        addItem(new DummyItem(String.valueOf(7), "Common", ""));

    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(1), "Item "+position, "Android 知识解析");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
