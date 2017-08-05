package demo.techinasia.com.myapplication.demo.data.datasource;

import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import dagger.Lazy;
import demo.techinasia.com.myapplication.demo.data.model.Model;

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

public abstract class DataStoreFactory<T extends DataStore, E extends Model> {

    private final Cache mCache;
    private final Lazy<DataStore> mDataStore;

    public DataStoreFactory(@NonNull final Lazy<DataStore> dataStore, @Nullable final Cache cache)  {

        mCache = cache;
        mDataStore = dataStore;
    }

    @CallSuper
    public T getDataStore() {
        return getDataStore(null);
    }

    @CallSuper
    public T getDataStore(@Nullable E requestModel) {
        DataStore dataStore;
        if (isCacheAvailable(requestModel)) {
            dataStore = createDiskDataStore(mCache);
        } else {
            dataStore = createCloudDataStore(mDataStore);
        }
        return (T) dataStore;
    }

    protected abstract T createDiskDataStore(@NonNull Cache cache);

    protected DataStore createCloudDataStore(@NonNull Lazy<DataStore> cloudDataStore) {
        return cloudDataStore.get();
    }

    public boolean isCacheAvailable() {
        return isCacheAvailable(null);
    }

    public boolean isCacheAvailable(@Nullable E requestModel) {
        return mCache != null
                && mCache.isCached(requestModel)
                && !mCache.isExpired(requestModel);
    }
}

