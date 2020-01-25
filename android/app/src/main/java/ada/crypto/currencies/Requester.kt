package ada.crypto.currencies

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class Requester {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.15.15:5000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun fetchHome(

        successCallback: (List<Currency>) -> Unit,
        failureCallback: (Throwable) -> Unit

    ) {
        val service = retrofit.create(CryptoCurrencyService::class.java)
        val call = service.home()

        call.enqueue(object : Callback<HomePayload?> {

            override fun onFailure(call: Call<HomePayload?>, t: Throwable) {
                failureCallback(t)
            }

            override fun onResponse(call: Call<HomePayload?>, response: Response<HomePayload?>) {
                val body = response.body()

                if (body == null) {
                    failureCallback(Exception("Failed to read the body"))
                    return
                }

                val currencies = body.currencies?.filterNotNull() ?: emptyList()
                successCallback(currencies)
            }

        })
    }

}