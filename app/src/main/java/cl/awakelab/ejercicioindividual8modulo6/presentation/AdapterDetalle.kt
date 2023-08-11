package cl.awakelab.ejercicioindividual8modulo6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaDetalleEntity
import cl.awakelab.ejercicioindividual8modulo6.databinding.ItemDetalleSeleccionBinding
import coil.load

class AdapterDetalle: RecyclerView.Adapter<AdapterDetalle.DetalleViewHolder>() {

    lateinit private var binding: ItemDetalleSeleccionBinding
    private val listaDetalleRaza = mutableListOf<RazaDetalleEntity>()

    class DetalleViewHolder(val detalleBinding: ItemDetalleSeleccionBinding): RecyclerView.ViewHolder(detalleBinding.root) {
        fun bind(raza: RazaDetalleEntity) {
            detalleBinding.imageViewDetalle.load(raza.imagen.toString())
            detalleBinding.textViewDetalleRaza.text = raza.raza
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetalleViewHolder {
        binding = ItemDetalleSeleccionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetalleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listaDetalleRaza.size
    }

    override fun onBindViewHolder(holder: DetalleViewHolder, position: Int) {
        val raza = listaDetalleRaza[position]
        holder.bind(raza)
    }

    fun setDataDetalle(detalle: List<RazaDetalleEntity>) {
        this.listaDetalleRaza.clear()
        this.listaDetalleRaza.addAll(detalle)
        notifyDataSetChanged()
    }

}