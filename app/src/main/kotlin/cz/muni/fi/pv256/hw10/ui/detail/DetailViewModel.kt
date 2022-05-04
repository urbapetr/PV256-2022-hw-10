package cz.muni.fi.pv256.hw10.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import cz.muni.fi.pv256.hw10.repo.PokemonRepository

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PokemonRepository(application)

    private val id: MutableLiveData<Int> = MutableLiveData()
    val user = id.switchMap { id ->
        repository.getPokemon(id)
    }

    fun setCharacterId(characterId: Int) {
        id.value = characterId
    }
}
