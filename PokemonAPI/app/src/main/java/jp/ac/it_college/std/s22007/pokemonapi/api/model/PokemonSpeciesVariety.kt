package jp.ac.it_college.std.s22007.pokemonapi.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonSpeciesVariety(
    @SerialName("is_default") val isDefault: Boolean,
    val pokemon: NamedAPIResource
)
