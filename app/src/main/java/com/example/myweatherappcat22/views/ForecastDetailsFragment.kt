package com.example.myweatherappcat22.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myweatherappcat22.R
import com.example.myweatherappcat22.databinding.FragmentForecastDetailsBinding
import com.example.myweatherappcat22.model.Forecast
import com.example.myweatherappcat22.utils.fFeel
import com.example.myweatherappcat22.utils.fTemp
import com.example.myweatherappcat22.utils.hour

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [ForecastDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForecastDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy{
        FragmentForecastDetailsBinding.inflate(layoutInflater)
    }

    var forecast: Forecast?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
         forecast=it?.getParcelable("details")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment"
        // TITTLE: ${Events[param1].title}

        binding.time.text=("Feel:${forecast?.hour()}").toString()
        binding.feelLike.text=("Feel:${forecast?.main?.fFeel()}").toString()
        binding.grndLevel.text=("Ground Lvl:${forecast?.main?.grndLevel}").toString()
        binding.humidity.text=("Humidity:${forecast?.main?.humidity}").toString()
        binding.desc.text=("Description:${forecast?.weather?.get(0)?.description}").toString()
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FforecastDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ForecastDetailsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}