package cz.muni.fi.pv256.hw10.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import cz.muni.fi.pv256.hw10.R
import cz.muni.fi.pv256.hw10.databinding.ActivityDetailBinding
import cz.muni.fi.pv256.hw10.repo.Result

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

        vm.pokemon.observe(
            this
        ) { result ->
            result?.let { pokemon ->
                when (result.state) {
                    Result.State.SUCCESS -> {
                        binding.name.text = pokemon.value?.name
                        binding.baseExperience.text =
                            String.format(
                                getString(R.string.baseExperience),
                                pokemon.value?.baseExperience
                            )
                        binding.height.text =
                            String.format(getString(R.string.height), pokemon.value?.height)
                        binding.isDefault.text =
                            String.format(getString(R.string.isDefault), pokemon.value?.isDefault)
                        binding.order.text =
                            String.format(getString(R.string.order), pokemon.value?.order)
                        binding.weight.text =
                            String.format(getString(R.string.weight), pokemon.value?.weight)

                        if (pokemon.value?.sprites?.frontDefault != null) {
                            binding.img.load(pokemon.value.sprites.frontDefault)
                        } else {
                            binding.img.load("https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/1024px-No_image_available.svg.png")
                        }

                        supportActionBar?.apply {
                            setDisplayShowTitleEnabled(true)
                            title = pokemon.value?.name
                        }
                    }
                }
            }
        }

        intent.extras?.apply {
            vm.setPokemonName(intent.getStringExtra(ITEM).toString())
        }
    }
}
