package gempa.kampusdeveloper.api;

import android.content.Context;
import android.support.compat.BuildConfig;

import java.util.concurrent.TimeUnit;

import gempa.kampusdeveloper.model.Data;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Dodi Rivaldi on 12/10/2016.
 */

public interface ApiInterface {
    String ENDPOINT = "http://ibacor.com/api/";
    String API_BMKG = "bmkg?";
    String GEMPA = "view=gempa";


    @GET(API_BMKG+GEMPA)
    Call<Data>
    getDataGempa();

    class Factory {

        public static ApiInterface create(Context context) {

            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.readTimeout(30, TimeUnit.SECONDS);
            builder.connectTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(60, TimeUnit.SECONDS);

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                builder.addInterceptor(interceptor);
            }

            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache cache = new Cache(context.getCacheDir(), cacheSize);
            builder.cache(cache);

            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiInterface.ENDPOINT)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            return retrofit.create(ApiInterface.class);
        }
    }

}
