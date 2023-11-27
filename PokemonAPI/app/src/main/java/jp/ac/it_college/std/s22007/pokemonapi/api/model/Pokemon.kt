package jp.ac.it_college.std.s22007.pokemonapi.api.model

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val id: Int,
    val sprites: PokemonSprites
)