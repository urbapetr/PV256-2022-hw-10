package cz.muni.fi.pv256.hw10.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity
data class Pokemon(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "baseExperience") val baseExperience: Int,
    @ColumnInfo(name = "height") val height: Int,
    @ColumnInfo(name = "isDefault") val isDefault: Boolean,
    @ColumnInfo(name = "order") val order: Int,
    @ColumnInfo(name = "weight") val weight: Int,
    @ColumnInfo(name = "sprites") val sprites: PokemonSprites,
) : Parcelable
