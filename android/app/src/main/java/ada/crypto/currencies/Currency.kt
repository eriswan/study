package ada.crypto.currencies

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("value") val value: String?,
    @SerializedName("image") val imageUrl: String?

)