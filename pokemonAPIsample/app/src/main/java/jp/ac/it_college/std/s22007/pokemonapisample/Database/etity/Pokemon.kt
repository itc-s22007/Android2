package jp.ac.it_college.std.s22007.pokemonapisample.Database.etity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey val id: Int,
    val generation: Int,
    val name: String,
    @ColumnInfo(name = "main_texture_url") val mainTextureUrl: String,
)