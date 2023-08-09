package cl.awakelab.ejercicioindividual8modulo6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.ejercicioindividual8modulo6.data.local.RazaEntity
import cl.awakelab.ejercicioindividual8modulo6.databinding.ItemRazaBinding

class AdapterRazas: RecyclerView.Adapter<AdapterRazas.ItemRazaViewHolder>() {

    lateinit var binding: ItemRazaBinding
    private var listItemRazas = mutableListOf<RazaEntity>()

    class ItemRazaViewHolder(var viewBinding: ItemRazaBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(raza: RazaEntity) {
            viewBinding.textViewRaza.text = raza.raza
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRazaViewHolder {
        binding = ItemRazaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemRazaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemRazas.size
    }

    override fun onBindViewHolder(holder: ItemRazaViewHolder, position: Int) {
        val raza = listItemRazas[position]
        holder.bind(raza)
    }

    fun setData(razas: List<RazaEntity>) {
        this.listItemRazas.clear()
        this.listItemRazas.addAll(razas)
        notifyDataSetChanged()
    }

}