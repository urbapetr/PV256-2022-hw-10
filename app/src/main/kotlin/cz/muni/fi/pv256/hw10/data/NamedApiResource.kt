package cz.muni.fi.pv256.hw10.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class NamedApiResource(
    @PrimaryKey val name: String,
    val url: String,
)
