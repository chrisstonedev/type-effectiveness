package net.cjstone.pocketmonstertypeeffectiveness

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EffectivenessActivity : AppCompatActivity() {

    private lateinit var effectivenessViewModel: EffectivenessViewModel

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_effectiveness)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = EffectivenessListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        effectivenessViewModel = ViewModelProvider(this).get(EffectivenessViewModel::class.java)
        effectivenessViewModel.allEffectiveness.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.setWords(it) }
        })
    }
}
