package com.utu.weatherapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utu.weatherapp.Repository.Repository
import com.utu.weatherapp.Utils.HobartState
import com.utu.weatherapp.Utils.MelbourneState
import com.utu.weatherapp.Utils.PerthState
import com.utu.weatherapp.Utils.SydneyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val repository: Repository) : ViewModel(){

    private val _melbourneCityState:MutableStateFlow<MelbourneState> = MutableStateFlow(MelbourneState.Empty)
    val melbourneCityState:StateFlow<MelbourneState> = _melbourneCityState


    private val _hobartCityState:MutableStateFlow<HobartState> = MutableStateFlow(HobartState.Empty)
    val hobartCityState:StateFlow<HobartState> = _hobartCityState


    private val _perthCityState:MutableStateFlow<PerthState> = MutableStateFlow(PerthState.Empty)
    val perthCityState:StateFlow<PerthState> = _perthCityState

    private val _sydneyCityState:MutableStateFlow<SydneyState> = MutableStateFlow(SydneyState.Empty)
    val sydneyCityState:StateFlow<SydneyState> = _sydneyCityState


    fun getMelbourneData() = viewModelScope.launch {
        _melbourneCityState.value = MelbourneState.Loading
        repository.getMelbourneData("melbourne")
                .catch { e->
                    _melbourneCityState.value = MelbourneState.Failure(e)
                }.collect { response->
                    _melbourneCityState.value = MelbourneState.Success(response)
                }
    }


    fun getHobartData() = viewModelScope.launch {
        _hobartCityState.value = HobartState.Loading
        repository.getHobartData("hobart")
                .catch { e->
                    _hobartCityState.value = HobartState.Failure(e)
                }.collect { response->
                    _hobartCityState.value = HobartState.Success(response)
                }
    }


    fun getPerthData() = viewModelScope.launch {
        _perthCityState.value = PerthState.Loading
        repository.getPerthData("perth")
                .catch { e->
                    _perthCityState.value = PerthState.Failure(e)
                }.collect { response->
                    _perthCityState.value = PerthState.Success(response)
                }
    }

    fun getSydneyData() = viewModelScope.launch {
        _sydneyCityState.value = SydneyState.Loading
        repository.getSydneyData("sydney")
                .catch { e->
                    _sydneyCityState.value = SydneyState.Failure(e)
                }.collect { response->
                    _sydneyCityState.value = SydneyState.Success(response)
                }
    }
}