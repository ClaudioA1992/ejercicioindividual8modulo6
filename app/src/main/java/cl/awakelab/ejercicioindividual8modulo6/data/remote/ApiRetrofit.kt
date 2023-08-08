package cl.awakelab.ejercicioindividual8modulo6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiRetrofit {

    companion object {
        private const val URL_BASE = "https://dog.ceo/api/breeds/"
        fun getRetrofitRaza(): RazaAPI {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(RazaAPI::class.java)
        }
    }

}