package jp.ac.it_college.std.s22007.ktorsample.modle

import android.view.accessibility.AccessibilityManager.AudioDescriptionRequestedChangeListener
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherInfo(
    @SerialName("coord")
    val coordinates: CoordInates,
    val weather: List<Weather>,
    @SerialName("name")
    val cityName: String
)
 @Serializable
data class CoordInates(
    @SerialName("lon")
    val longitude: Double,

    @SerialName("lat")
    val latitude: Double,
)

@Serializable
data class Weather(
    val id: Int,

    @SerialName("main")
    val group: String,
    val description: String,
    val icon: String,
)

