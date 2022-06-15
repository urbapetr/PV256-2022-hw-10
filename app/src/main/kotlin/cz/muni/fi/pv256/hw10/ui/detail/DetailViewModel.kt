package cz.muni.fi.pv256.hw10.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import cz.muni.fi.pv256.hw10.repo.PokemonRepository

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PokemonRepository(application)

    private val name: MutableLiveData<String> = MutableLiveData()
    val pokemon = name.switchMap { name ->
        repository.getPokemon(name)
    }

    fun setPokemonName(pokemonName: String) {
        name.value = pokemonName
    }
}
