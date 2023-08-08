package cl.awakelab.ejercicioindividual8modulo6.data

import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaDao
import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaEntity
import cl.awakelab.ejercicioindividual8modulo6.data.remote.RazaAPI

class Repositorio(private val razaAPI: RazaAPI, private val razaDAO: RazaDao) {

    suspend fun getRazas() {
        val response = razaAPI.getAllBreeds() // Acá llegan los datos
        if(response.isSuccessful) { // Llegaron los datos?
            val message = response.body()!!.message // Solo sacando la parte del message, sin status
            val keys = message.keys
            keys.forEach {
                var razaEntity = RazaEntity(it)
                razaDAO.insertRaza(razaEntity)
            }

        }
    }

}