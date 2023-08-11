package cl.awakelab.ejercicioindividual8modulo6.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaDao
import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaDetalleEntity
import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaEntity
import cl.awakelab.ejercicioindividual8modulo6.data.remote.RazaAPI

class Repositorio(private val razaAPI: RazaAPI, private val razaDAO: RazaDao) {

    fun obtenerRazasEntities(): LiveData<List<RazaEntity>> = razaDAO.selectRazas()

    fun getDetalleRazaEntity(raza: String): LiveData<List<RazaDetalleEntity>> = razaDAO.selectRazaDetalle(raza)

    suspend fun getRazas() {
        val response = razaAPI.getAllBreeds() // Acá llegan los datos
        if(response.isSuccessful) { // Llegaron los datos?
            val message = response.body()!!.message // Solo sacando la parte del message, sin status
            val keys = message.keys
            keys.forEach {
                var razaEntity = RazaEntity(it)
                razaDAO.insertRaza(razaEntity)
            }
        } else {
            Log.e("Repositorio", response.errorBody().toString())
        }

    }

    suspend fun getDetalleRaza(raza: String) {
        val response = razaAPI.getDetailRace(raza)
        if(response.isSuccessful) {
            val message = response.body()!!.message
            message.forEach {
                val razaDetalle = RazaDetalleEntity(raza, it)
                razaDAO.insertRazaDetalle(razaDetalle)
            }
        } else {
            Log.e("Repositorio", response.errorBody().toString())
        }
    }



}

