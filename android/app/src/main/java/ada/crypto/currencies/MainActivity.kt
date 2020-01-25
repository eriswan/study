package ada.crypto.currencies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val list by lazy { findViewById<RecyclerView>(R.id.list) }

    private val adapter = CurrencyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        Requester().fetchHome({ currencies ->
            adapter.currencies = currencies
        }, { error ->
            error.printStackTrace()
        })
    }

}
