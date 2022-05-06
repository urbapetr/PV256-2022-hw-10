package cz.muni.fi.pv256.hw10.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity
data class NamedApiResource(
    @PrimaryKey val name: String,
    val url: String,
) : Parcelable
