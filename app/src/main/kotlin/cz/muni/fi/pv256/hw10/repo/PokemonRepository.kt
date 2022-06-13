package cz.muni.fi.pv256.hw10.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import cz.muni.fi.pv256.hw10.api.ApiService
import cz.muni.fi.pv256.hw10.db.PokemonDatabase

class PokemonRepository(context: Context) {
    companion object {
        private val TAG = PokemonRepository::class.java.simpleName
    }

    private val pokemonDao = PokemonDatabase.getInstance(context).pokemonDao()

    fun getPokemon(name: String) = liveData {
        val disposable = emitSource(
            pokemonDao.getByName(name).map {
                Result.loading(it)
            }
        )
        try {
            val pokemon = ApiService.apiService.getPokemon(name)
            disposable.dispose()
            pokemonDao.insertAllPokemon(listOf(pokemon))
            emitSource(
                pokemonDao.getByName(name).map {
                    Result.success(it)
                }
            )
        } catch (e: Exception) {
            Log.e(TAG, "Getting pokemon from the Internet failed", e)
            emitSource(
                pokemonDao.getByName(name).map {
                    Result.failure(e, it)
                }
            )
        }
    }

    fun getNamedApiResourceList() = liveData {
        val disposable = emitSource(
            pokemonDao.getAllNames().map {
                Result.loading(it)
            }
        )
        try {
            val namedApiResourceList = ApiService.apiService.getNamedApiResourceList().results
            disposable.dispose()
            pokemonDao.insertAllNamedApi(namedApiResourceList)
            emitSource(
                pokemonDao.getAllNames().map {
                    Result.success(it)
                }
            )
        } catch (e: Exception) {
            Log.e(TAG, "Getting data from the Internet failed", e)
            emitSource(
                pokemonDao.getAllNames().map {
                    Result.failure(e, it)
                }
            )
        }
    }
}
