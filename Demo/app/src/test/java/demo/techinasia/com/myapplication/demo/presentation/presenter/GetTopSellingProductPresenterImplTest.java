package demo.techinasia.com.myapplication.demo.presentation.presenter;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.data.model.ProductRecommendation;
import demo.techinasia.com.myapplication.demo.domain.interactor.TaskResponse;
import demo.techinasia.com.myapplication.demo.domain.interactor.UseCase;
import demo.techinasia.com.myapplication.demo.presentation.view.GetTopSellingProductView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

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

public class GetTopSellingProductPresenterImplTest {

    private static final int ANY_LOADER_ID = 1;

    @Mock
    UseCase mMockUseCase;

    @Mock
    LoaderManager mMockLoaderManager;

    private GetTopSellingProductPresenterImpl mPresenter;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        mPresenter = new GetTopSellingProductPresenterImpl(mMockUseCase, mMockLoaderManager, ANY_LOADER_ID);
    }

    @Test
    public void testOnCreateLoader() {
        final int anyInt = 1;

        final Bundle mockBundle = mock(Bundle.class);

        Loader useCase = mPresenter.onCreateLoader(anyInt, mockBundle);

        Assert.assertEquals(mMockUseCase, useCase);
    }

    @Test
    public void testCloseLoaderOnLoadFinished() {
        final Loader mockLoader = mock(Loader.class);
        final TaskResponse mockTaskResponse = mock(TaskResponse.class);

        mPresenter.onLoadFinished(mockLoader, mockTaskResponse);

        verify(mMockLoaderManager).destroyLoader(eq(ANY_LOADER_ID));
    }

    @Test
    public void testHideLoadingOnLoadFinished() {
        final Loader mockLoader = mock(Loader.class);
        final TaskResponse mockTaskResponse = mock(TaskResponse.class);
        final GetTopSellingProductView mockView = mock(GetTopSellingProductView.class);

        mPresenter.attachView(mockView);
        mPresenter.onLoadFinished(mockLoader, mockTaskResponse);

        verify(mockView).hideLoading();
    }

    @Test
    public void testGetProductWithUnattachedView() {
        final Loader mockLoader = mock(Loader.class);
        final TaskResponse mockTaskResponse = mock(TaskResponse.class);

        final GetTopSellingProductView mockView = mock(GetTopSellingProductView.class);

        mPresenter.attachView(mockView);
        mPresenter.detachView();

        mPresenter.onLoadFinished(mockLoader, mockTaskResponse);

        verifyNoMoreInteractions(mockView);
    }

    @Test
    public void testGetProductAvailable() {
        final Loader mockLoader = mock(Loader.class);
        final TaskResponse mockTaskResponse = mock(TaskResponse.class);

        mockTaskResponse.error = null;
        mockTaskResponse.data = mock(ProductRecommendation.class);

        final GetTopSellingProductView mockView = mock(GetTopSellingProductView.class);

        mPresenter.attachView(mockView);
        mPresenter.onLoadFinished(mockLoader, mockTaskResponse);

        verify(mockView).onProductAvailable(any(ProductRecommendation.class));
    }

    @Test
    public void testGetProductNotAvailable() {
        final Loader mockLoader = mock(Loader.class);
        final TaskResponse mockTaskResponse = mock(TaskResponse.class);

        mockTaskResponse.error = mock(IOException.class);

        final GetTopSellingProductView mockView = mock(GetTopSellingProductView.class);

        mPresenter.attachView(mockView);
        mPresenter.onLoadFinished(mockLoader, mockTaskResponse);

        verify(mockView).onProductNotAvailable();
    }

    @Test
    public void testGetProductsWhenLoaderIsNotRunning() {
        final Model mockRequest = mock(Model.class);
        final GetTopSellingProductView mockView = mock(GetTopSellingProductView.class);

        mPresenter.attachView(mockView);
        mPresenter.getProducts(mockRequest);

        verify(mockView).showLoading();

        verify(mMockUseCase).setRequest(eq(mockRequest));
        verify(mMockLoaderManager).restartLoader(eq(ANY_LOADER_ID), (Bundle) isNull(), eq(mPresenter));
    }

    @Test
    public void testGetProductsWhenLoaderIsRunning() {
        final Loader mockLoader = mock(Loader.class);
        final Model mockRequest = mock(Model.class);
        final GetTopSellingProductView mockView = mock(GetTopSellingProductView.class);

        doReturn(mockLoader).when(mMockLoaderManager).getLoader(eq(ANY_LOADER_ID));
        doReturn(true).when(mockLoader).isStarted();

        mPresenter.attachView(mockView);
        mPresenter.getProducts(mockRequest);

        verifyNoMoreInteractions(mockView, mMockUseCase);
    }
}
