package com.mishkurov.loggers;

import com.mishkurov.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton_Mishkurov
 */
public class CacheFileEventLogger extends FileEventLogger {
    private final int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String filename, Integer cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>(cacheSize);
    }

    @Override
    public void logEvent(Event msg) {
        if (cache.size() == cacheSize) {
            writeCacheToFile();
            cache.clear();
        }
        cache.add(msg);
    }

    private void writeCacheToFile() {
        for (Event event : cache) {
            super.logEvent(event);
        }
    }

    private void destroy(){
        writeCacheToFile();
    }
}
