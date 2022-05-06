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

    fun getPokemon(id: Int) = liveData {
        try {
            val character = ApiService.apiService.getPokemon(id)
            pokemonDao.insertAll(character)
            emitSource(
                pokemonDao.getById(id).map {
                    it
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

    fun getAllPokemon() = liveData {
        val disposable = emitSource(
            pokemonDao.getAll().map {
                Result.loading(it)
            }
        )
        try {
            // get fresh data from Internet
            val characters = ApiService.apiService.getAllPokemon()
            disposable.dispose()
            pokemonDao.insertAll(*characters.toTypedArray())
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
