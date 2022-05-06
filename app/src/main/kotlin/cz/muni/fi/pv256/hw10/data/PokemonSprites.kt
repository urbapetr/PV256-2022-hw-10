package cz.muni.fi.pv256.hw10.data

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity
data class PokemonSprites(
    val backDefault: String? = null,
    val backShiny: String? = null,
    val frontDefault: String? = null,
    val frontShiny: String? = null,
    val backFemale: String? = null,
    val backShinyFemale: String? = null,
    val frontFemale: String? = null,
    val frontShinyFemale: String? = null,
) : Parcelable
