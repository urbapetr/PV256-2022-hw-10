package cz.muni.fi.pv256.hw10.data

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity
data class PokemonSprites(
    @Json(name = "back_default")
    val backDefault: String? = null,
    @Json(name = "back_shiny")
    val backShiny: String? = null,
    @Json(name = "front_default")
    val frontDefault: String? = null,
    @Json(name = "front_shiny")
    val frontShiny: String? = null,
    @Json(name = "back_female")
    val backFemale: String? = null,
    @Json(name = "back_shiny_female")
    val backShinyFemale: String? = null,
    @Json(name = "front_female")
    val frontFemale: String? = null,
    @Json(name = "front_shiny_female")
    val frontShinyFemale: String? = null,
) : Parcelable
