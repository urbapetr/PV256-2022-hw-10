package cz.muni.fi.pv256.hw10.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import cz.muni.fi.pv256.hw10.R
import cz.muni.fi.pv256.hw10.data.Pokemon
import cz.muni.fi.pv256.hw10.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val ITEM = "item"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vm: DetailViewModel by viewModels()

        vm.user.observe(
            this,
            {
                if (it is Pokemon) {
                    binding.name.text = it.name
                    binding.baseExperience.text =
                        String.format(getString(R.string.baseExperience), it.baseExperience)
                    binding.height.text = String.format(getString(R.string.height), it.height)
                    binding.isDefault.text =
                        String.format(getString(R.string.isDefault), it.isDefault)
                    binding.order.text = String.format(getString(R.string.order), it.order)
                    binding.weight.text = String.format(getString(R.string.weight), it.weight)

                    if (it.sprites.front_default != null) {
                        binding.img.load(it.sprites.front_default)
                    } else {
                        binding.img.load("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png")
                    }

                    supportActionBar?.apply {
                        setDisplayShowTitleEnabled(true)
                        title = it.name
                    }
                }
            }
        )

        intent.extras?.apply {
            vm.setPokemonName(intent.getStringExtra(ITEM).toString())
        }
    }
}
