package cz.muni.fi.pv256.hw10.data

import androidx.room.TypeConverter

class PokemonSpritesConverters {
    @TypeConverter
    fun stringToSprites(data: String?): PokemonSprites? {
        return data?.let {
            PokemonSprites(
                null,
                null,
                data,
                null,
                null,
                null,
                null,
                null,)
        }
    }

    @TypeConverter
    fun spritesToString(data: PokemonSprites?): String? {
        return data?.frontDefault
    }
}
