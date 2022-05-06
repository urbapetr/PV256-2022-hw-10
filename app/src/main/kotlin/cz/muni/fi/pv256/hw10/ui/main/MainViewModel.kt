package cz.muni.fi.pv256.hw10.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import cz.muni.fi.pv256.hw10.repo.PokemonRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PokemonRepository(application)

    private val page: MutableLiveData<Int> = MutableLiveData()
    val items = page.switchMap {
        repository.getAllPokemon()
    }

    fun setPage(pageNo: Int) {
        page.value = pageNo
    }
}
