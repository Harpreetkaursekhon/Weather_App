package com.utu.weatherapp.data.Model.ui.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.utu.weatherapp.Utils.MelbourneState
import com.utu.weatherapp.Utils.MelbourneThreeState
import com.utu.weatherapp.Utils.Util
import com.utu.weatherapp.Utils.Util.convertKelvinToCelsius
import com.utu.weatherapp.Utils.Util.toast
import com.utu.weatherapp.ViewModel.MainViewModel
import com.utu.weatherapp.ViewModel.ThreeDaysViewModel
import com.utu.weatherapp.databinding.FragmentCurrentCityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MelbourneFragment : Fragment() {
    private val mainViewModel:MainViewModel by viewModels()
    private lateinit var binding: FragmentCurrentCityBinding
    private  val threeDaysViewModel: ThreeDaysViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
      binding = FragmentCurrentCityBinding.inflate(layoutInflater,container, false)
        observerMelbourneData()
        observerMelbourneThreeDaysData()
        return binding.root
    }

    private fun observerMelbourneThreeDaysData() {
        threeDaysViewModel.getMelbourneThreeDaysData()
        lifecycleScope.launchWhenStarted {
            threeDaysViewModel.melbourneThreeDaysState.collect {
                when(it)
                {
                    is MelbourneThreeState.Loading->{
                        binding.oneDay.text="..."
                        binding.oneDayTemp.text="..."
                        binding.twoDay.text="..."
                        binding.twoDayTemp.text="..."
                        binding.threeDay.text="..."
                        binding.threeDayTemp.text="..."

                    }
                    is MelbourneThreeState.Success -> {
                        binding.oneDay.text = it.data.list[6].dt_txt
                        binding.twoDay.text = it.data.list[14].dt_txt
                        binding.threeDay.text = it.data.list[23].dt_txt

                        binding.oneDayTemp.text=convertKelvinToCelsius(it.data.list[6].main.temp).toString().substringBefore(".") + "°C"
                        binding.twoDayTemp.text=convertKelvinToCelsius(it.data.list[14].main.temp).toString().substringBefore(".") + "°C"
                        binding.threeDayTemp.text=convertKelvinToCelsius(it.data.list[23].main.temp).toString().substringBefore(".") + "°C"
                    }
                    is MelbourneThreeState.Failure->{
                        toast("${it.msg}",requireContext())
                    }
                    is MelbourneThreeState.Empty->{

                    }
                }
            }
        }
    }

    private fun observerMelbourneData() {
        mainViewModel.getMelbourneData()
        lifecycleScope.launchWhenStarted {
            mainViewModel.melbourneCityState.collect {it->
                when(it)
                {
                    is MelbourneState.Loading->{
                        binding.textviewweather.text="Melbourne"
                        binding.tvTemperature.text="Loading..."
                        binding.tvTempMinMax.text="Loading..."
                        binding.tvTempType.text="Loading..."
                    }
                    is MelbourneState.Success -> {
                        binding.textviewweather.text = it.data.name
                        val temp = convertKelvinToCelsius(it.data.main.temp).toString()

                        val maxTemp = convertKelvinToCelsius(it.data.main.temp_max).toString().substringBefore(".") + "°"
//
                        val minTemp = convertKelvinToCelsius(it.data.main.temp_min).toString().substringBefore(".") + "°"
                        binding.tvTemperature.text = "$temp"
                        binding.tvTempMinMax.text = "$maxTemp / $minTemp"
                        binding.tvTempType.text = it.data.weather[0].description
                    }
                    is MelbourneState.Failure -> {
                        Log.d("main", "observerMelbourneData: ${it.msg}")
                    }
                }
            }

        }
    }


}