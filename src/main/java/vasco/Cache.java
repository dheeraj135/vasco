package vasco;

import java.util.*;
// import java.util.List;
// import java.util.PriorityQueue;

class LRUCache extends Cache {
    public static void freeUp(boolean force) {
        PriorityQueue<Context> contextList = Context.contextList;
        List<Context> contexts = new ArrayList(contextList);
        
        Collections.sort(contexts, new Comparator<Context>() {
            @Override
			public int compare(Context u, Context v) {
				return u.latestHit.compareTo(v.latestHit);
			}
        });
        freeSorted(force, contexts);
        // for (Context x: contexts)
        //     System.out.println("Context: "+x.getMethod()+" "+x.getEntryValue()+" "+x.latestHit);
        
    }
}

class LFUCache extends Cache {
    public static void freeUp(boolean force) {
        PriorityQueue<Context> contextList = Context.contextList;
        List<Context> contexts = new ArrayList(contextList);
        
        Collections.sort(contexts, new Comparator<Context>() {
            @Override
			public int compare(Context u, Context v) {
				return u.hitCount.compareTo(v.hitCount);
			}
        });
        freeSorted(force, contexts);
    }
}

public class Cache {

    static int cacheType = 0;
    static int X = 5;
    static int XForce = 10;

    static double freePer = 0.4;
    static double freePerForce = 0.7;

    public static void freeUp() {
        if (cacheType == 0)
            LRUCache.freeUp(false);
        else
            LFUCache.freeUp(false);
    }

    public static void freeUp(boolean force) {
        if (cacheType == 0)
            LRUCache.freeUp(force);
        else
            LFUCache.freeUp(force);
    }

    protected static void freeSorted(boolean force, List<Context> contexts) {
        double percentage = freePer;
        if (force)
            percentage = freePerForce;
        int canBeFreed = (int)(percentage * contexts.size()) - Context.numFreed;
        for (Context c: contexts) {
            if (c.isFreed() || c.isBeingReAnalysed() || !c.isAnalysed() ) continue;
            if (c.getWorklistCount() >0) continue;
            if (force) {
                if (c.reAnalysisCount > XForce) continue;
            }
            else {
                if (c.reAnalysisCount > X) continue;
            }
            if (canBeFreed > 0) {
                c.freeContext();
                canBeFreed --;
            }
            else break;
        }
    }
}