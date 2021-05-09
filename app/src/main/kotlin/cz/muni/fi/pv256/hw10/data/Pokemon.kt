package cz.muni.fi.pv256.hw10.data

data class Pokemon(
    val id: Int,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val sprites: PokemonSprites,
)
