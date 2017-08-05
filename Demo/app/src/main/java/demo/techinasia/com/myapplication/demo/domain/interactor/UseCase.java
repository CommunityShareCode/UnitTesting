package demo.techinasia.com.myapplication.demo.domain.interactor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.AsyncTaskLoader;

import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.domain.respository.Repository;

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

public class UseCase<T> extends AsyncTaskLoader<TaskResponse<T>> {

    private final Repository mRepository;
    private Model mRequest;

    public UseCase(@NonNull final Context context, @NonNull final Repository repository) {
        super(context);

        mRepository = repository;
    }

    public void setRequest(@NonNull Model request) {
        mRequest = request;
    }

    @Override
    public TaskResponse<T> loadInBackground() {

        TaskResponse response = new TaskResponse();

        try {
            response.data = mRepository.getRequest(mRequest);
        } catch (Exception e) {
            response.error = e;
        }

        return response;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
