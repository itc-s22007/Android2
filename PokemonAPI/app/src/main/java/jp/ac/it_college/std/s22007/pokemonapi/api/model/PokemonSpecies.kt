package jp.ac.it_college.std.s22007.pokemonapi.api.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpecies(
    val id: Int,
    val names: List<Name>,
    val varieties: List<PokemonSpeciesVariety>
)
