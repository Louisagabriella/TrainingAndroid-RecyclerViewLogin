package id.co.asyst.gabriella.louisa.recyclerviewlogin.retrofit;

import android.content.Context;

import id.co.asyst.gabriella.louisa.recyclerviewlogin.constant.Constant;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit = null;
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static Retrofit newInstance(Context context) {
        if (retrofit == null) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(logging);

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.KEY_URL_LOGIN)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
