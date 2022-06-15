package cz.muni.fi.pv256.hw10.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity
data class Pokemon(
    @PrimaryKey val id: Int,
    val name: String = "unknown",
    val baseExperience: Int = 0,
    val height: Int = 0,
    val isDefault: Boolean = false,
    val order: Int = 0,
    val weight: Int = 0,
    val sprites: PokemonSprites,
    val url: String = "",
) : Parcelable
