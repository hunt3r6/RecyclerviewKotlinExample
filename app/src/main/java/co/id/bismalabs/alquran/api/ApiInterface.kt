package co.id.bismalabs.alquran.api

import co.id.bismalabs.alquran.data.ResponseSurah
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("surah")
    fun getSurah(): Call<ResponseSurah>
}