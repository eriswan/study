package ada.crypto.currencies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val txt by lazy { findViewById<TextView>(R.id.txt) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Requester().fetchHome({ currencies ->
            txt.text = currencies.toString()
        }, { error ->
            txt.text = error.message
            error.printStackTrace()
        })
    }

}
