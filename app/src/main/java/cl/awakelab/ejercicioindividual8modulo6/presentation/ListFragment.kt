package cl.awakelab.ejercicioindividual8modulo6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelab.ejercicioindividual8modulo6.R
import cl.awakelab.ejercicioindividual8modulo6.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentListBinding
    val razaViewModel: RazaViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        razaViewModel.getAllRazas()
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterRazas()
        binding.recyclerViewRazas.adapter = adapter
        razaViewModel.razaLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

    }

}