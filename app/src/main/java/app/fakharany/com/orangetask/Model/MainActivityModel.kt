package app.fakharany.com.orangetask.Model

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import okhttp3.Response
import retrofit2.Call

class MainActivityModel {

    interface MainActivityModelListener {
        fun getCategories(result: String)

    }


    public fun getListOfCategoriesByRetrofit(mainActivityModelListener: MainActivityModelListener) {

        var apiInterface: ApiInterface? = ApiClass.getRetro()?.create(ApiInterface::class.java)


        var response: Call<Response> = apiInterface!!.getCategories()

        response.enqueue(object : retrofit2.Callback<Response> {
            override fun onFailure(call: Call<Response>?, t: Throwable?) {
                t!!.printStackTrace()
            }

            override fun onResponse(call: Call<Response>?, response: retrofit2.Response<Response>?) {
                //  mainActivityModelListener.getCategories(response!!.body() as app.fakharany.com.orangetask.POJO.Response)


            }

        })

    }

    fun getListByVolley(mainActivityModelListener: MainActivityModelListener, context: Context) {

        var request = StringRequest(Request.Method.GET, "https://demo8044805.mockable.io/senders", { result ->

            mainActivityModelListener.getCategories(result)

        }, { error -> error.printStackTrace() })


        var requestQueue: RequestQueue = Volley.newRequestQueue(context)
        requestQueue.add(request)
    }

}