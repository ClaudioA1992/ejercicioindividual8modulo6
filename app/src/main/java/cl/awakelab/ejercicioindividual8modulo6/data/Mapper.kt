package cl.awakelab.ejercicioindividual8modulo6.data

import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaDetalleEntity
import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaEntity

fun String.toEntity(id: String): RazaDetalleEntity = RazaDetalleEntity(id, this)

fun String.toRazaEntity(): RazaEntity = RazaEntity(this)