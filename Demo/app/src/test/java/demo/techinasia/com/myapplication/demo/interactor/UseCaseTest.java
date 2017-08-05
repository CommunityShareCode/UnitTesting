package demo.techinasia.com.myapplication.demo.interactor;

import android.content.Context;

import junit.framework.Assert;

import org.junit.Test;

import java.io.IOException;

import demo.techinasia.com.myapplication.demo.data.model.Model;
import demo.techinasia.com.myapplication.demo.domain.interactor.TaskResponse;
import demo.techinasia.com.myapplication.demo.domain.interactor.UseCase;
import demo.techinasia.com.myapplication.demo.domain.respository.Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

public class UseCaseTest {

    @Test
    public void testLoadInBackground() throws Exception {
        final Context mockContext = mock(Context.class);
        final Repository mockRepository = mock(Repository.class);
        final Model mockResponseData = mock(Model.class);

        doReturn(mockResponseData).when(mockRepository).getRequest(any(Model.class));

        final UseCase useCase = new UseCase(mockContext, mockRepository);

        useCase.setRequest(mock(Model.class));

        final TaskResponse taskResponse = useCase.loadInBackground();

        Assert.assertEquals(mockResponseData, taskResponse.data);
        Assert.assertNull(taskResponse.error);
    }

    @Test
    public void testLoadInBackgroundWithError() throws Exception {
        final Context mockContext = mock(Context.class);
        final Repository mockRepository = mock(Repository.class);
        final IOException mockException = mock(IOException.class);

        doThrow(mockException).when(mockRepository).getRequest(any(Model.class));

        final UseCase useCase = new UseCase(mockContext, mockRepository);

        useCase.setRequest(mock(Model.class));

        final TaskResponse taskResponse = useCase.loadInBackground();

        Assert.assertNull(taskResponse.data);
        Assert.assertEquals(mockException, taskResponse.error);
    }
}
