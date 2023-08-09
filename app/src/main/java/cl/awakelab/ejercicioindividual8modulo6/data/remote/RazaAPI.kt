package cl.awakelab.ejercicioindividual8modulo6.data.remote

import androidx.lifecycle.LiveData
import retrofit2.Response
import retrofit2.http.GET

interface RazaAPI {

    @GET("breeds/list/all")
    suspend fun getAllBreeds(): Response<Raza>

}