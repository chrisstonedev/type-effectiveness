package net.cjstone.pocketmonstertypeeffectiveness

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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

        val intent = Intent(this@MainActivity, EffectivenessActivity::class.java)
        intent.putExtra("type", t)
        startActivity(intent)
    }
}
