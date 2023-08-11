package cl.awakelab.ejercicioindividual8modulo6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelab.ejercicioindividual8modulo6.databinding.FragmentDetailBinding
import coil.load
import com.google.gson.Gson
import com.google.gson.GsonBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private val razaViewModel: RazaViewModel by activityViewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("raza")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(LayoutInflater.from(activity))
        razaViewModel.getDetalleRaza(param1!!)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterDetalle()
        binding.recyclerViewRaces.adapter = adapter
        razaViewModel.detalleLiveData(param1.toString()).observe(viewLifecycleOwner) {
            adapter.setDataDetalle(it)
        }
    }


}