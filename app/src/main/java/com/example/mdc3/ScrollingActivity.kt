package com.example.mdc3

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mdc3.databinding.ActivityScrollingBinding
import com.example.mdc3.databinding.ContentScrollingBinding
import com.google.android.material.bottomappbar.BottomAppBar

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            if (binding.bottomAppBar.fabAlignmentMode == (BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)){
                binding.bottomAppBar.fabAlignmentMode = (BottomAppBar.FAB_ALIGNMENT_MODE_END)
            }else{
                binding.bottomAppBar.fabAlignmentMode = (BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
            }
        }
        //snackbar para mostrar mensaje como un toas el set anchor hace que se posicione por arriba del fab
        binding.bottomAppBar.setOnClickListener {
            Snackbar.make(binding.root, R.string.message_action_success, Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .show()
        }

        binding.content.btnBuy.setOnClickListener { binding.content.cardAd.visibility= View.GONE }

        binding.content.btnSkip.setOnClickListener {
            Snackbar.make(it, R.string.card_buying, Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .setAction(R.string.card_to_go) {
                    Toast.makeText(this, R.string.card_historial, Toast.LENGTH_LONG).show()
                }
                .show()
        }
        //primero se le carga el contexto, despues la url de lo que queremos cargar y finalmente donde lo va a mostrar
        Glide.with(this)
            .load("data:image/jpeg;base64,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")
            .centerCrop() //amplia y centra la imagen
            .diskCacheStrategy(DiskCacheStrategy.ALL) // optimizamos la cache para que gurde la imagen
            .into(binding.content.imgCover)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}