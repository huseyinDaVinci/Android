package barin.com.searchtipsapplication.data.net;

import android.support.annotation.Nullable;
import barin.com.searchtipsapplication.data.entity.TipResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Api for getting tips from web services
 */
public class TRestClient {

  public interface TSquareApiInterface {
    @GET("/v2/tips/search") Observable<TipResponse> searchTips(@Query("client_id") String client_id,
        @Query("client_secret") String client_secret, @Query("v") String type,
        @Query("ll") String ll);
  }

  @Nullable public static TSquareApiInterface getTSquareApiInterface(String baseUrl) {
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);

    OkHttpClient okHttpClient = UnSafeOkHttpClient.getUnsafeOkHttpClient();
    Retrofit client = new Retrofit.Builder().baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(PrimitiveConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();

    return client.create(TSquareApiInterface.class);
  }
}
