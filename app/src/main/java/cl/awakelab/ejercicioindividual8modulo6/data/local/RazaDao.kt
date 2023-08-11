package cl.awakelab.ejercicioindividual8modulo6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaEntity

@Dao
interface RazaDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insertRaza(raza: RazaEntity)

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insertRazaDetalle(razaDetalle: RazaDetalleEntity)

    @Query("select * from tabla_razas order by raza asc")
    fun selectRazas(): LiveData<List<RazaEntity>>

    @Query("select * from tabla_razas_detalle where raza like :id")
    fun selectRazaDetalle(id: String): LiveData<List<RazaDetalleEntity>>

}

