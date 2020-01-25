package ada.crypto.currencies

import retrofit2.Call
import retrofit2.http.GET

interface CryptoCurrencyService {

    @GET("home")
    fun home(): Call<HomePayload?>

}