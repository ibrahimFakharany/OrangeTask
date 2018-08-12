package app.fakharany.com.orangetask.Model

import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("senders")
    fun getCategories(): Call<Response>


}