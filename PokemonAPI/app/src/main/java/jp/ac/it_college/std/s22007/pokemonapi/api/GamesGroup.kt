package jp.ac.it_college.std.s22007.pokemonapi.api

import io.ktor.client.call.body
import jp.ac.it_college.std.s22007.pokemonapi.api.model.Generation

object GamesGroup {
    suspend fun getGeneration(gen: Int): Generation{
        return Client.get("/generation/$gen/").body()
    }
}