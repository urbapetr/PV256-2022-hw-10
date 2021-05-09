package cz.muni.fi.pv256.hw10.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cz.muni.fi.pv256.hw10.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
