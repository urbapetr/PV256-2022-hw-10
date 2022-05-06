package cz.muni.fi.pv256.hw10.data

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity
data class PokemonSprites(
    val back_default: String? = null,
    val back_shiny: String? = null,
    val front_default: String? = null,
    val front_shiny: String? = null,
    val back_female: String? = null,
    val back_shiny_female: String? = null,
    val front_female: String? = null,
    val front_shiny_female: String? = null,
) : Parcelable
