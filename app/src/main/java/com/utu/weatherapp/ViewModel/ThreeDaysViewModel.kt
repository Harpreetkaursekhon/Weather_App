package com.utu.weatherapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utu.weatherapp.Repository.ThreeDaysRepository
import com.utu.weatherapp.Utils.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThreeDaysViewModel
@Inject constructor(private val threeDaysRepository: ThreeDaysRepository) : ViewModel(){


    private val _sydneyThreeDaysState: MutableStateFlow<SydneyThreeState> = MutableStateFlow(SydneyThreeState.Empty)
    val sydneyThreeDaysState: StateFlow<SydneyThreeState> = _sydneyThreeDaysState


    private val _melbourneThreeDaysState: MutableStateFlow<MelbourneThreeState> = MutableStateFlow(MelbourneThreeState.Empty)
    val melbourneThreeDaysState: StateFlow<MelbourneThreeState> = _melbourneThreeDaysState


    private val _perthThreeDaysState: MutableStateFlow<PerthThreeState> = MutableStateFlow(PerthThreeState.Empty)
    val perthThreeDaysState: StateFlow<PerthThreeState> = _perthThreeDaysState


    private val _hobartThreeDaysState: MutableStateFlow<HobartThreeState> = MutableStateFlow(HobartThreeState.Empty)
    val hobartThreeDaysState: StateFlow<HobartThreeState> = _hobartThreeDaysState


    fun getSydneyThreeDaysData() = viewModelScope.launch {
        _sydneyThreeDaysState.value = SydneyThreeState.Loading
        threeDaysRepository.getSydneyThreeDaysData("sydney")
                .catch { e->
                    _sydneyThreeDaysState.value = SydneyThreeState.Failure(e)
                }.collect { response->
                    _sydneyThreeDaysState.value = SydneyThreeState.Success(response)
                }
    }


    fun getMelbourneThreeDaysData() = viewModelScope.launch {
        _melbourneThreeDaysState.value = MelbourneThreeState.Loading
        threeDaysRepository.getMelbourneThreeDaysData("melbourne")
                .catch { e->
                    _melbourneThreeDaysState.value = MelbourneThreeState.Failure(e)
                }.collect { response->
                    _melbourneThreeDaysState.value = MelbourneThreeState.Success(response)
                }
    }


    fun getPerthThreeDaysData() = viewModelScope.launch {
        _perthThreeDaysState.value = PerthThreeState.Loading
        threeDaysRepository.getPerthThreeDaysData("perth")
                .catch { e->
                    _perthThreeDaysState.value = PerthThreeState.Failure(e)
                }.collect { response->
                    _perthThreeDaysState.value = PerthThreeState.Success(response)
                }
    }


    fun getHobartThreeDaysData() = viewModelScope.launch {
        _hobartThreeDaysState.value = HobartThreeState.Loading
        threeDaysRepository.getHobartThreeDaysData("hobart")
                .catch { e->
                    _hobartThreeDaysState.value = HobartThreeState.Failure(e)
                }.collect { response->
                    _hobartThreeDaysState.value = HobartThreeState.Success(response)
                }
    }

}