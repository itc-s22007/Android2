package jp.ac.it_college.std.s22007.pokemonapisample.Database.repository

import androidx.annotation.WorkerThread
import jp.ac.it_college.std.s22007.pokemonapisample.Database.dao.PokemonDao
import jp.ac.it_college.std.s22007.pokemonapisample.Database.etity.Pokemon

class PokemonRepository(private val pokemonDao: PokemonDao) {
    fun findPokemonByGeneration(generation: Int): List<Pokemon> =
        pokemonDao.findByGeneration(generation)

    @WorkerThread
    suspend fun register(pokemon: List<Pokemon>) {
        pokemon.map(pokemonDao::insert)
    }
}