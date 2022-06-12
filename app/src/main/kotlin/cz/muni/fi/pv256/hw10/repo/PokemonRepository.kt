package cz.muni.fi.pv256.hw10.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import cz.muni.fi.pv256.hw10.api.ApiService
import cz.muni.fi.pv256.hw10.data.NamedApiResource
import cz.muni.fi.pv256.hw10.db.PokemonDatabase

class PokemonRepository(context: Context) {
    companion object {
        private val TAG = PokemonRepository::class.java.simpleName
    }

    private val pokemonDao = PokemonDatabase.getInstance(context).pokemonDao()

    fun getPokemon(name: String) = liveData {
        try {
            val pokemon = ApiService.apiService.getPokemon(name)
            pokemonDao.insertAll(listOf(NamedApiResource(name, "https://pokeapi.co/api/v2/pokemon/".plus(name))))
            emitSource(
                pokemonDao.getByName(name).map {
                    pokemon
                }
            )
        } catch (e: Exception) {
            Log.e(TAG, "Getting pokemon from the Internet failed", e)
        }
    }

    fun getNamedApiResourceList() = liveData {
        val disposable = emitSource(
            pokemonDao.getAll().map {
                Result.loading(it)
            }
        )
        try {
            val namedApiResourceList = ApiService.apiService.getNamedApiResourceList().results
            disposable.dispose()
            pokemonDao.insertAll(namedApiResourceList)
            emitSource(
                pokemonDao.getAll().map {
                    Result.success(it)
                }
            )
        } catch (e: Exception) {
            Log.e(TAG, "Getting data from the Internet failed", e)
            emitSource(
                pokemonDao.getAll().map {
                    Result.failure(e, it)
                }
            )
        }
    }
}
