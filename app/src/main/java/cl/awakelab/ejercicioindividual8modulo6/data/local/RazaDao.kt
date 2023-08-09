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

    @Query("select * from tabla_razas order by raza asc")
    fun selectRazas(): LiveData<List<RazaEntity>>

}

