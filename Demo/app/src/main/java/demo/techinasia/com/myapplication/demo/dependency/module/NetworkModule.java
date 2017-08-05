package demo.techinasia.com.myapplication.demo.dependency.module;

import android.os.Build;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import demo.techinasia.com.myapplication.demo.qualifier.ApplicationScope;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by fandygotama on 4/2/17.
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
@Module
public class NetworkModule {

    private final String mBaseUrl;
    private final String mConsumerId;

    public NetworkModule(final @NonNull String baseUrl, final @NonNull String consumerId) {
        mBaseUrl = baseUrl;
        mConsumerId = consumerId;
    }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder requestBuilder = chain.request().newBuilder()
                        .addHeader("EBAY-SOA-CONSUMER-ID", mConsumerId);

                return chain.proceed(requestBuilder.build());
            }
        });

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.addInterceptor(interceptor);


        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(mBaseUrl)
               .addConverterFactory(JacksonConverterFactory.create())
               .client(client)
               .build();

        return retrofit;
    }
}
