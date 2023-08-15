package cl.awakelab.ejercicioindividual8modulo6.data

import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {

        // Given, dado este valor
        val url = "dato-url"
        val id = "dato-id"
        // When, hago esto
        val resultadoDeTransformación = url.toEntity(id)
        // Then, hago esto
        assertEquals(id, resultadoDeTransformación.raza)
        assertEquals(url, resultadoDeTransformación.imagen)


    }

    @Test
    fun toRazaEntity() {
    }


}