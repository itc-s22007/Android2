package jp.ac.it_college.std.s22007.pokemonapisample.model

import kotlinx.serialization.SerialName
import java.util.jar.Attributes.Name

data class Generation(
    val id: Int,
    val name: String,
    val abilities: List<NamedApiResource>,
    val names: List<Name>,
    @SerialName("main_region") val mainRegion: NamedApiResource,
    val moves: NamedApiResource,
    @SerialName("pokemon_species") val pokemonSpecies: List<NamedApiResource>,
    val types: List<NamedApiResource>,
    @SerialName("version_groups") val versionGroups: List<NamedApiResource>,
)
