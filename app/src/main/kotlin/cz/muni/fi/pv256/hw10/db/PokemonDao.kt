package cz.muni.fi.pv256.hw10.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import cz.muni.fi.pv256.hw10.data.NamedApiResource
import cz.muni.fi.pv256.hw10.data.Pokemon

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun getAllPokemon(): LiveData<List<Pokemon>>

    @Query("SELECT * FROM namedapiresource")
    fun getAllNames(): LiveData<List<NamedApiResource>>

    @Query("SELECT * FROM pokemon WHERE name LIKE :name")
    fun getByName(name: String): LiveData<Pokemon>

    @Insert(onConflict = REPLACE)
    suspend fun insertAllPokemon(pokemon: List<Pokemon>)

    @Insert(onConflict = REPLACE)
    suspend fun insertAllNamedApi(namedApiResource: List<NamedApiResource>)

    @Delete
    suspend fun delete(pokemon: Pokemon)
}
