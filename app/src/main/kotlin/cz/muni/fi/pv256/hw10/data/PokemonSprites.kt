package cz.muni.fi.pv256.hw10.data

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PokemonSprites(
    val backDefault: String?,
    val backShiny: String?,
    val frontDefault: String?,
    val frontShiny: String?,
    val backFemale: String?,
    val backShinyFemale: String?,
    val frontFemale: String?,
    val frontShinyFemale: String?,
) : Parcelable
