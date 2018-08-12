package app.fakharany.com.orangetask.Model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClass {


    companion object {
        var retrofit: Retrofit? = null

        fun getRetro(): Retrofit? {

            if (retrofit == null) {

                retrofit = Retrofit.Builder().baseUrl("https://demo8044805.mockable.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(getOkHttpClient()).build()
            }
            return retrofit
        }

        fun getOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder().connectTimeout(1000, TimeUnit.MILLISECONDS)
                    .readTimeout(1000, TimeUnit.MILLISECONDS).build()
        }
    }
}