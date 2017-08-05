package demo.techinasia.com.myapplication.demo.presentation.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.domain.interactor.TaskResponse;
import demo.techinasia.com.myapplication.demo.domain.interactor.UseCase;
import demo.techinasia.com.myapplication.demo.presentation.view.GetTopSellingProductView;
import demo.techinasia.com.myapplication.demo.presentation.view.View;

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

public class GetTopSellingProductPresenterImpl implements GetTopSellingProductPresenter<Model>, LoaderManager.LoaderCallbacks<TaskResponse<ProductRecommendation>> {

    private final UseCase mUseCase;
    private final LoaderManager mLoaderManager;

    private final int mLoaderId;

    private GetTopSellingProductView mView;

    public GetTopSellingProductPresenterImpl(@NonNull final UseCase useCase, @NonNull final LoaderManager loaderManager, final int loaderId) {
        mUseCase = useCase;
        mLoaderManager = loaderManager;
        mLoaderId = loaderId;
    }

    @Override
    public Loader<TaskResponse<ProductRecommendation>> onCreateLoader(int id, Bundle args) {
        return mUseCase;
    }

    @Override
    public void onLoadFinished(Loader<TaskResponse<ProductRecommendation>> loader, TaskResponse<ProductRecommendation> data) {
        try {
            mLoaderManager.destroyLoader(mLoaderId);
        } catch (IllegalStateException e) {

        }

        if (mView != null) {
            mView.hideLoading();

            if (data.error != null) {
                mView.onProductNotAvailable();
            } else {
                mView.onProductAvailable(data.data);
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<TaskResponse<ProductRecommendation>> loader) {
        // Do Nothing
    }

    @Override
    public void attachView(@NonNull GetTopSellingProductView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void getProducts(Model request) {
        if (mLoaderManager.getLoader(mLoaderId) != null && mLoaderManager.getLoader(mLoaderId).isStarted()) {
            return;
        }

        if (mView != null) mView.showLoading();

        mUseCase.setRequest(request);
        mLoaderManager.restartLoader(mLoaderId, null, this);
    }
}
