package jp.ac.it_college.std.s22007.pokemonapi.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poke")
data class Poke(
    @PrimaryKey val id: Long,
    val generation: Int,
    val name: String,
    @ColumnInfo(name = "main_texture_url") val mainTextureUrl: String,
)