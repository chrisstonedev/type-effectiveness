package net.cjstone.pocketmonstertypeeffectiveness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user clicks Normal */
    fun typeClick(view: View) {
        // Do something in response to button click
        val t = view.tag.toString()
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show()
    }
}
