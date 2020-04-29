package co.id.bismalabs.alquran

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.bismalabs.alquran.adapter.SurahAdapter
import co.id.bismalabs.alquran.api.Api
import co.id.bismalabs.alquran.data.ResponseSurah
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private var listSurah = ArrayList<ResponseSurah.Surah>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSurah.also {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(this)
        }

        val api = Api().getService()
        api.getSurah().enqueue(object : Callback<ResponseSurah> {
            override fun onFailure(call: Call<ResponseSurah>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseSurah>, response: Response<ResponseSurah>) {
                listSurah = response.body()?.listSurah as ArrayList<ResponseSurah.Surah>
                val surahAdapter = SurahAdapter(listSurah)
                rvSurah.adapter = surahAdapter
                surahAdapter.setOnItemClickCallback(object : SurahAdapter.OnItemClickCallback {
                    override fun onItemClicked(surah: ResponseSurah.Surah) {
                        Toast.makeText(
                            this@MainActivity,
                            "Kamu memilih ${surah.englishName}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
            }
        })

    }
}
