package cz.muni.fi.pv256.hw10.data

data class NamedApiResourceList(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedApiResource>
)
