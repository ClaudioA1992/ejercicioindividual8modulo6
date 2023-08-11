package cl.awakelab.ejercicioindividual8modulo6.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RazaAPI {

    @GET("breeds/list/all")
    suspend fun getAllBreeds(): Response<Raza>

    @GET("breed/{race}/images/")
    suspend fun getDetailRace(@Path("race") race: String): Response<RazaDetalle>

}

