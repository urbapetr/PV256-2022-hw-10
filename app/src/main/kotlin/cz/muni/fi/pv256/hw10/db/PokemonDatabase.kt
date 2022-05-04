package cz.muni.fi.pv256.hw10.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cz.muni.fi.pv256.hw10.data.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao():PokemonDao

    companion object {
        fun getInstance(context: Context): PokemonDatabase {
            return Room.databaseBuilder(
                context,
                PokemonDatabase::class.java,
                "Pokemon database"
            ).build()
        }
    }
}
