package jp.ac.it_college.std.s22007.pokemonapi
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import jp.ac.it_college.std.s22007.pokemonapi.ui.theme.PokemonAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PokemonAPITheme {
                PokeNavigation()
            }
        }
    }
}
