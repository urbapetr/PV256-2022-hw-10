package cz.muni.fi.pv256.hw10.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NamedApiResourceList(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedApiResource>
)
