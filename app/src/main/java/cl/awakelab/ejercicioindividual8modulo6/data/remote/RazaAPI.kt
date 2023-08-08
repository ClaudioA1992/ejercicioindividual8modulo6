package cl.awakelab.ejercicioindividual8modulo6.data.remote

import androidx.lifecycle.LiveData
import retrofit2.Response
import retrofit2.http.GET

interface RazaAPI {

    @GET("list/all")
    fun getAllBreeds(): Response<List<Raza>>

}