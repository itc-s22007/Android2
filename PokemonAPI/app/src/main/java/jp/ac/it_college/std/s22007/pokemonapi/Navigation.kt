package jp.ac.it_college.std.s22007.pokemonapi

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.navArgument
import jp.ac.it_college.std.s22007.pokemonapi.generation.SelectGenerationScene
import jp.ac.it_college.std.s22007.pokemonapi.model.PokeQuiz
import jp.ac.it_college.std.s22007.pokemonapi.result.ResultScene
import jp.ac.it_college.std.s22007.pokemonapi.title.TitleScene
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.ac.it_college.std.s22007.pokemonapi.quiz.QuizScene

object Destinations {
    const val TITLE = "title"
    const val GENERATION = "generation_select"
    const val QUIZ = "quiz/{order}"
    const val RESULT = "result"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeNavigation(
    navController: NavHostController = rememberNavController(),
) {
    var titleText by remember { mutableStateOf("") }
    var quizData by remember { mutableStateOf(listOf<PokeQuiz>()) }
    var score by remember { mutableIntStateOf(0) }

    Scaffold(
        // 上部のバー
        topBar = {
            TopAppBar(title = {
                Text(text = titleText)
            })
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Destinations.TITLE,
            modifier = Modifier.padding(it)
        ) {
            // composable関数でデスティネーションを登録していく。
            composable(Destinations.TITLE) {
                // タイトル画面
                titleText = stringResource(id = R.string.who)
                TitleScene(
                    onTitleClick = {
                        navController.navigate(Destinations.GENERATION)
                    }
                )
            }

            composable(Destinations.GENERATION) {
                // 世代選択画面
                score = 0
                titleText = stringResource(id = R.string.please_select_generation)
                SelectGenerationScene(onGenerationSelected = { gen ->
                    quizData = generateQuizData(gen)
                    navController.navigate("quiz/0"){
                        popUpTo(Destinations.GENERATION)
                    }
                })
            }

            composable(
                Destinations.QUIZ,
                arguments = listOf(navArgument("order") { type = NavType.IntType })
            ) {
                titleText = ""
                val order = it.arguments?.getInt("order") ?: 0
                QuizScene(quizData[order]){
                    score += if (it) 1 else 0

                    val next = order + 1
                    if (quizData.size > next){
                        navController.navigate("quiz/$next"){
                            popUpTo(Destinations.GENERATION)
                        }
                    }else{
                        navController.navigate(Destinations.RESULT){
                            popUpTo(Destinations.GENERATION)
                        }
                    }

                }
            }

            composable(Destinations.RESULT) {
                titleText = ""
                ResultScene(
                    result = score,
                    onClickGenerationButton = {
                        navController.popBackStack()
                    },
                    onClickTitleButton = {
                        navController.popBackStack(Destinations.TITLE, false)
                    }
                )

            }
        }
    }
}

fun generateQuizData(generation: Int): List<PokeQuiz> {
    return listOf(
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/906.png",
            choices = listOf("ニャオハ", "ホゲータ", "クワッス", "グルトン").shuffled(),
            correct = "ニャオハ"
        ),
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/909.png",
            choices = listOf("ニャオハ", "ホゲータ", "クワッス", "グルトン").shuffled(),
            correct = "ホゲータ"
        ),
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/912.png",
            choices = listOf("ニャオハ", "ホゲータ", "クワッス", "グルトン").shuffled(),
            correct = "クワッス"
        ),
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/915.png",
            choices = listOf("ニャオハ", "ホゲータ", "クワッス", "グルトン").shuffled(),
            correct = "グルトン"
        ),
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/921.png",
            choices = listOf("偽カチュウ", "エモンガ", "デデンネ", "ワンパチ").shuffled(),
            correct = "偽カチュウ"
        ),
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/924.png",
            choices = listOf("ルルロロ", "デルビル", "ワッカネズミ", "イッカネズミ").shuffled(),
            correct = "ワッカネズミ"
        ),
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/926.png",
            choices = listOf("ピカチュウ", "パピモッチ", "ポチエナ", "ウパー").shuffled(),
            correct = "パピモッチ"
        ),
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/948.png",
            choices = listOf("ノノクラゲ", "メノクラゲ", "リククラゲ", "ドククラゲ").shuffled(),
            correct = "ノノクラゲ"
        ),
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/100.png",
            choices = listOf("ビリリダマ", "マルマイン", "ムンナ", "ユニラン").shuffled(),
            correct = "ビリリダマ"
        ),
        PokeQuiz(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/964.png",
            choices = listOf("ナミイルカ", "イルカマン", "コダック", "カイオーガ").shuffled(),
            correct = "イルカマン"
        ),
    ).shuffled()
}