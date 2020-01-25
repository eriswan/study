package ada.crypto.currencies

import com.google.gson.annotations.SerializedName

data class HomePayload(

    @SerializedName("currencies") val currencies: List<Currency?>?

)