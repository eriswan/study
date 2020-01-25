package ada.crypto.currencies

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CurrencyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val logo by lazy { view.findViewById<ImageView>(R.id.logo) }
    private val name by lazy { view.findViewById<TextView>(R.id.name) }
    private val value by lazy { view.findViewById<TextView>(R.id.price) }

    fun bind(currency: Currency) {
        name.text = currency.name
        value.text = currency.value

        Picasso.get().cancelRequest(logo)
        Picasso.get().load(currency.imageUrl).into(logo)
    }

}