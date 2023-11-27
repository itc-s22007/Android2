package jp.ac.it_college.std.s22007.pokemonapi.api

import io.ktor.client.call.body
import jp.ac.it_college.std.s22007.pokemonapi.api.model.NamedAPIResource
import jp.ac.it_college.std.s22007.pokemonapi.api.model.Pokemon
import jp.ac.it_college.std.s22007.pokemonapi.api.model.PokemonSpecies

object PokemonGroup {
    suspend fun getPokemonSpecies(id: Int): PokemonSpecies {
        return Client.get("/pokemon-species/$id/").body()
    }

    suspend fun getPokemonSpecies(res: NamedAPIResource): PokemonSpecies {
        if (!res.url.contains("/pokemon-species/")) {
            throw IllegalArgumentException("ポケモンの種族情報用のURLではありません")
        }
        return getPokemonSpecies(
            res.url.trim('/').split('/').last().toInt()
        )
    }

    suspend fun getPokemon(id: Int): Pokemon {
        return Client.get("/pokemon/$id/").body()
    }

    suspend fun getPokemon(res: NamedAPIResource): Pokemon {
        if (!res.url.contains("/pokemon/")) {
            throw IllegalArgumentException("ポケモン詳細用のURLではありません")
        }
        return getPokemon(
            res.url.trim('/').split('/').last().toInt()
        )
    }
}