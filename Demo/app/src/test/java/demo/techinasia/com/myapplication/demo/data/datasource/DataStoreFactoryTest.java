package demo.techinasia.com.myapplication.demo.data.datasource;

import android.support.annotation.NonNull;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dagger.Lazy;
import demo.techinasia.com.myapplication.demo.data.model.Model;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

/**
 * Created by fandygotama on 8/5/17.
 * With special thanks to (Alphabetical Order):
 * - Aldy Chrissandy (Indonesia),
 * - Antoni Tirta Riady (Indonesia),
 * - Arman Hendra Harnanda (Indonesia),
 * - Jessa Cahilig (Philippines),
 * - Remerico Cruz (Philippines),
 * - Steven Lewi (Indonesia),
 * For being great teams and excellent collaborators, and
 * also to Rendra Toro for being our Manager.
 * OLX SEA MOBILE APPS TEAM 2016, YOU GUYS ARE AWESOME!!
 */

public class DataStoreFactoryTest {

    @Mock
    Cache mMockCache;

    @Mock
    Lazy<DataStore> mMockDataStore;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCloudDataStore() {
        final CloudDataStore mockCloudDataStore = mock(CloudDataStore.class);

        DataStoreFactory dataStoreFactory = spy(new DataStoreFactory(mMockDataStore, mMockCache) {
            @Override
            protected DataStore createDiskDataStore(@NonNull Cache cache) {
                return null;
            }

            @Override
            protected DataStore createCloudDataStore(@NonNull Lazy cloudDataStore) {
                return mockCloudDataStore;
            }
        });

        doReturn(false).when(dataStoreFactory).isCacheAvailable(null);

        DataStore dataStore = dataStoreFactory.getDataStore(null);

        Assert.assertEquals(dataStore, mockCloudDataStore);
    }

    @Test
    public void testCreateDiskDataStore() {
        final DataStore mockDiskDataStore = mock(DataStore.class);

        DataStoreFactory dataStoreFactory = spy(new DataStoreFactory(mMockDataStore, mMockCache) {
            @Override
            protected DataStore createDiskDataStore(@NonNull Cache cache) {
                return mockDiskDataStore;
            }

            @Override
            protected DataStore createCloudDataStore(@NonNull Lazy cloudDataStore) {
                return null;
            }
        });

        doReturn(true).when(dataStoreFactory).isCacheAvailable(null);

        DataStore dataStore = dataStoreFactory.getDataStore(null);

        Assert.assertEquals(dataStore, mockDiskDataStore);
    }

    @Test
    public void testCacheAvailabilityIfDataIsCachedAndNotExpired() {
        final DataStoreFactory dataStoreFactory = getDataStoreFactory();

        doReturn(true).when(mMockCache).isCached(any(Model.class));
        doReturn(false).when(mMockCache).isExpired(any(Model.class));

        final boolean isCacheAvailable = dataStoreFactory.isCacheAvailable(mock(Model.class));

        Assert.assertEquals(true, isCacheAvailable);
    }

    @Test
    public void testCacheAvailabilityIfDataIsCachedButExpired() {
        final DataStoreFactory dataStoreFactory = getDataStoreFactory();

        doReturn(true).when(mMockCache).isCached(any(Model.class));
        doReturn(true).when(mMockCache).isExpired(any(Model.class));

        final boolean isCacheAvailable = dataStoreFactory.isCacheAvailable(mock(Model.class));

        Assert.assertEquals(false, isCacheAvailable);
    }

    @Test
    public void testCacheAvailabilityIfDataIsNotCached() {
        final DataStoreFactory dataStoreFactory = getDataStoreFactory();

        doReturn(false).when(mMockCache).isCached(any(Model.class));
        doReturn(false).when(mMockCache).isExpired(any(Model.class));

        final boolean isCacheAvailable = dataStoreFactory.isCacheAvailable(mock(Model.class));

        Assert.assertEquals(false, isCacheAvailable);
    }

    public DataStoreFactory getDataStoreFactory() {
        return spy(new DataStoreFactory(mMockDataStore, mMockCache) {
            @Override
            protected DataStore createDiskDataStore(@NonNull Cache cache) {
                return null;
            }

            @Override
            protected DataStore createCloudDataStore(@NonNull Lazy cloudDataStore) {
                return super.createCloudDataStore(cloudDataStore);
            }
        });
    }
}
