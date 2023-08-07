package cl.awakelab.ejercicioindividual8modulo6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
*
* [x] Permisos de internet
* [x] Dependencias y features: Coil, Retrofit, navigation, ViewModel, viewBinding
* [] 2 pantallas: Listado y detalle
* [] Listado: RecyclewView + ViewHolder + Adapter
* [] Detalle: RecyclerView + ViewHolder + Adapter
* [] Data local y remote
* [] Remote
* [] Local
*
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
