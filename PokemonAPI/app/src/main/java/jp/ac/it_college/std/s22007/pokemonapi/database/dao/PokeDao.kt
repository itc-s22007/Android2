package jp.ac.it_college.std.s22007.pokemonapi.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import jp.ac.it_college.std.s22007.pokemonapi.database.entity.Poke

@Dao
interface PokeDao {
    @Query("SELECT * FROM poke WHERE generation = :generation")
    fun findByGeneration(generation: Int): List<Poke>

    @Insert
    fun insert(poke: Poke)

    @Insert
    fun insertAll(pokeList: List<Poke>)

    @Query("DELETE FROM poke WHERE generation = :generation")
    fun deleteByGeneration(generation: Int)
}