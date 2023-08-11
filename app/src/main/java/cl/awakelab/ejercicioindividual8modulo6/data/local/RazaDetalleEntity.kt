package cl.awakelab.ejercicioindividual8modulo6.data.local

import androidx.room.Entity

@Entity(tableName = "tabla_razas_detalle", primaryKeys = ["raza", "imagen"])
data class RazaDetalleEntity(
    val raza: String,
    val imagen: String
)

