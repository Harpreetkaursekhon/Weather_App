package com.utu.weatherapp.Utils

import com.utu.weatherapp.data.Model.CurrentCity
import com.utu.weatherapp.data.Model.ThreeDays

sealed class MelbourneThreeState  {
    object Loading : MelbourneThreeState()
    class Success(val data: ThreeDays):MelbourneThreeState()
    class Failure(val msg:Throwable):MelbourneThreeState()
    object Empty : MelbourneThreeState()
}

sealed class PerthThreeState  {
    object Loading : PerthThreeState()
    class Success(val data: ThreeDays):PerthThreeState()
    class Failure(val msg:Throwable):PerthThreeState()
    object Empty : PerthThreeState()
}

sealed class HobartThreeState  {
    object Loading : HobartThreeState()
    class Success(val data: ThreeDays):HobartThreeState()
    class Failure(val msg:Throwable):HobartThreeState()
    object Empty : HobartThreeState()
}

sealed class SydneyThreeState  {
    object Loading : SydneyThreeState()
    class Success(val data: ThreeDays):SydneyThreeState()
    class Failure(val msg:Throwable):SydneyThreeState()
    object Empty : SydneyThreeState()
}