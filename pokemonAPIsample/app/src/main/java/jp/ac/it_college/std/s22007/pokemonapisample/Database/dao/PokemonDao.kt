package jp.ac.it_college.std.s22007.pokemonapisample.Database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import jp.ac.it_college.std.s22007.pokemonapisample.Database.etity.Pokemon

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun getAll(): List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE generation = :generation")
    fun findByGeneration(generation: Int): List<Pokemon>

    @Insert
    fun insert(pokemon: Pokemon)

    @Query("DELETE FROM pokemon")
    fun delete()
}