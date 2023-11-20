package jp.ac.it_college.std.s22007.pokemonapi.title

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import jp.ac.it_college.std.s22007.pokemonapi.R
import jp.ac.it_college.std.s22007.pokemonapi.ui.theme.PokemonAPITheme

@Composable
fun TitleScene(modifier: Modifier = Modifier, onTitleClick: () -> Unit = {}) {
    Surface(modifier) {
        // 念のため、縦に並べられるように。
        Column(
            modifier = Modifier
                .fillMaxSize()
                // 通常クリックできないUIについては、Modifier.clickable を指定するとクリック可能になる。
                .clickable(onClick = onTitleClick),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // タイトル
            Text(
                text = stringResource(id = R.string.app_name),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(vertical = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun TitleScenePreview() {
    PokemonAPITheme {
        TitleScene(Modifier.fillMaxSize())
    }
}