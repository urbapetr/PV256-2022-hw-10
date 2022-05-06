package cz.muni.fi.pv256.hw10.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cz.muni.fi.pv256.hw10.data.NamedApiResource
import cz.muni.fi.pv256.hw10.data.PokemonSpritesConverters

@Database(entities = [NamedApiResource::class], version = 3)
@TypeConverters(PokemonSpritesConverters::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao

    companion object {
        fun getInstance(context: Context): PokemonDatabase {
            return Room.databaseBuilder(
                context,
                PokemonDatabase::class.java,
                "Pokemon database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
