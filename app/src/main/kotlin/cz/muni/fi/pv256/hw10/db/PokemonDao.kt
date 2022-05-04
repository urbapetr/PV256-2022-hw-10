package cz.muni.fi.pv256.hw10.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import cz.muni.fi.pv256.hw10.data.Pokemon

interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun getAll(): LiveData<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE id LIKE :id")
    fun getById(id: Int): LiveData<Pokemon>

    @Insert(onConflict = REPLACE)
    suspend fun insertAll(vararg character: Pokemon)

    @Delete
    suspend fun delete(character: Pokemon)
}
