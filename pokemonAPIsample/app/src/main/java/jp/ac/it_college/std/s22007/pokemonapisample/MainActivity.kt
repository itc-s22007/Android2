package jp.ac.it_college.std.s22007.pokemonapisample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.ac.it_college.std.s22007.pokemonapisample.Database.PokeApiDatabase
import jp.ac.it_college.std.s22007.pokemonapisample.Database.etity.Pokemon
import jp.ac.it_college.std.s22007.pokemonapisample.api.Games
import jp.ac.it_college.std.s22007.pokemonapisample.ui.theme.PokemonAPIsampleTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonAPIsampleTheme {
                MainScene(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MainScene(modifier: Modifier = Modifier) {
    var resultText by remember {
        mutableStateOf("結果表示")
    }
    // Composable な関数内でコルーチンを使用するためのコルーチンスコープ
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Surface(modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedButton(
                modifier = Modifier.padding(vertical = 8.dp),
                onClick = {
                    scope.launch {
                        resultText = Games.getGenerations().toString()
                        initializeDatabase(context)
                    }
                }
            ) {
                Text(text = "API Test")
            }
            Surface(
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Text(text = resultText)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScenePreview() {
    PokemonAPIsampleTheme {
        MainScene(Modifier.fillMaxSize())
    }
}

private suspend fun initializeDatabase(context: Context) {
    withContext(Dispatchers.IO) {
        val dao = PokeApiDatabase.getDatabase(context, this).pokemonDao()
        dao.insert(
            Pokemon(
                25,
                1,
                "ピカチュウ",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"
            )
        )
    }

}