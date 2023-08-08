package cl.awakelab.ejercicioindividual8modulo6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelab.ejercicioindividual8modulo6.data.Repositorio
import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaDatabase
import cl.awakelab.ejercicioindividual8modulo6.data.remote.ApiRetrofit
import kotlinx.coroutines.launch

class RazaViewModel(application: Application): AndroidViewModel(application) {

    private val repositorio: Repositorio

    init {
        val api = ApiRetrofit.getRetrofitRaza()
        val razaDatabase = RazaDatabase.getDatabase(application).getRazaDao()
        repositorio = Repositorio(api, razaDatabase)
    }

    fun getAllRazas() = viewModelScope.launch {
        repositorio.getRazas()
    }

}