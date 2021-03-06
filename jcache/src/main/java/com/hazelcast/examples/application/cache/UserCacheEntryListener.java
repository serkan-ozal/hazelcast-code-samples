package com.hazelcast.examples.application.cache;

import com.hazelcast.examples.application.model.User;

import javax.cache.event.CacheEntryCreatedListener;
import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryExpiredListener;
import javax.cache.event.CacheEntryListenerException;
import javax.cache.event.CacheEntryRemovedListener;
import javax.cache.event.CacheEntryUpdatedListener;
import java.util.Iterator;

public class UserCacheEntryListener
        implements CacheEntryCreatedListener<Integer, User>,
                   CacheEntryUpdatedListener<Integer, User>,
                   CacheEntryRemovedListener<Integer, User>,
                   CacheEntryExpiredListener<Integer, User> {

    @Override
    public void onCreated(Iterable<CacheEntryEvent<? extends Integer, ? extends User>> cacheEntryEvents)
            throws CacheEntryListenerException {

        printEvents(cacheEntryEvents);
    }

    @Override
    public void onUpdated(Iterable<CacheEntryEvent<? extends Integer, ? extends User>> cacheEntryEvents)
            throws CacheEntryListenerException {

        printEvents(cacheEntryEvents);
    }

    @Override
    public void onRemoved(Iterable<CacheEntryEvent<? extends Integer, ? extends User>> cacheEntryEvents)
            throws CacheEntryListenerException {

        printEvents(cacheEntryEvents);
    }

    @Override
    public void onExpired(Iterable<CacheEntryEvent<? extends Integer, ? extends User>> cacheEntryEvents)
            throws CacheEntryListenerException {

        printEvents(cacheEntryEvents);
    }

    private void printEvents(Iterable<CacheEntryEvent<? extends Integer, ? extends User>> cacheEntryEvents) {
        Iterator<CacheEntryEvent<? extends Integer, ? extends User>> iterator = cacheEntryEvents.iterator();
        while (iterator.hasNext()) {
            CacheEntryEvent<? extends Integer, ? extends User> event = iterator.next();
            System.out.println(event.getEventType());
        }
    }
}
