package jp.ac.it_college.std.s22007.pokemonapi.model

import android.media.Image

data class PokeQuiz(
    val imageUrl: String,
    val choices: List<String>,
    val correct: String
)
