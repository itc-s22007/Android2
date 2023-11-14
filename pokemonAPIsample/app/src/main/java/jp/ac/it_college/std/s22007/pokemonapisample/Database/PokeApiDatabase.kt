package jp.ac.it_college.std.s22007.pokemonapisample.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import jp.ac.it_college.std.s22007.pokemonapisample.Database.dao.PokemonDao
import jp.ac.it_college.std.s22007.pokemonapisample.Database.etity.Pokemon
import kotlinx.coroutines.CoroutineScope

@Database(
    entities = [
        Pokemon::class,
    ],
    version = 1
)
abstract class PokeApiDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao

    companion object {
        @Volatile
        private var INSTANCE: PokeApiDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): PokeApiDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PokeApiDatabase::class.java,
                    "pokeapi_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}