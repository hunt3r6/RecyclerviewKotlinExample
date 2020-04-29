package co.id.bismalabs.alquran.data


import com.google.gson.annotations.SerializedName

data class ResponseSurah(
    val code: Int,
    val status: String,
    @SerializedName("data")
    val listSurah: List<Surah>
) {
    data class Surah(
        val number: Int,
        val name: String,
        val englishName: String,
        val englishNameTranslation: String,
        val numberOfAyahs: Int,
        val revelationType: String
    )
}