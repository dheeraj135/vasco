package vasco;

import java.util.*;
// import java.util.List;
// import java.util.PriorityQueue;

class LRUCache extends Cache {
    static int X = 5;
    public static void freeUp() {
        PriorityQueue<Context> contextList = Context.contextList;
        List<Context> contexts = new ArrayList(contextList);
        
        Collections.sort(contexts, new Comparator<Context>() {
            @Override
			public int compare(Context u, Context v) {
				return v.latestHit.compareTo(u.latestHit);
			}
        });
        int canBeFreed = (int)(0.4 * contexts.size()) - Context.numFreed;
        for (Context c: contextList) {
            if (c.isFreed() || c.isBeingReAnalysed()) continue;
            if (c.getWorklistCount() >0) continue;

            if (c.reAnalysisCount > X) continue;
            if (canBeFreed > 0) {
                c.freeContext();
                canBeFreed --;
            }
            else break;
        }
    }
}

class LFUCache extends Cache {
    static int X = 5;
    public static void freeUp() {
        PriorityQueue<Context> contextList = Context.contextList;
        List<Context> contexts = new ArrayList(contextList);
        
        Collections.sort(contexts, new Comparator<Context>() {
            @Override
			public int compare(Context u, Context v) {
				return v.hitCount.compareTo(u.hitCount);
			}
        });
        int canBeFreed = (int)(0.4 * contexts.size()) - Context.numFreed;
        for (Context c: contextList) {
            if (c.isFreed() || c.isBeingReAnalysed()) continue;
            if (c.getWorklistCount() >0) continue;

            if (c.reAnalysisCount > X) continue;
            if (canBeFreed > 0) {
                c.freeContext();
                canBeFreed --;
            }
            else break;
        }
    }
}

public class Cache {

    static int cacheType = 1;
    public static void freeUp() {
        if (cacheType == 0)
            LRUCache.freeUp();
        else
            LFUCache.freeUp();
    }
}