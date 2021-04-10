package com.utu.weatherapp.Utils

import android.content.Context
import android.widget.Toast
import com.utu.weatherapp.data.Model.CurrentCity

sealed class MelbourneState  {
    object Loading : MelbourneState()
    class Success(val data:CurrentCity):MelbourneState()
    class Failure(val msg:Throwable):MelbourneState()
    object Empty : MelbourneState()
}


sealed class HobartState  {
    object Loading : HobartState()
    class Success(val data:CurrentCity):HobartState()
    class Failure(val msg:Throwable):HobartState()
    object Empty : HobartState()
}


sealed class PerthState  {
    object Loading : PerthState()
    class Success(val data:CurrentCity):PerthState()
    class Failure(val msg:Throwable):PerthState()
    object Empty : PerthState()
}


sealed class SydneyState  {
    object Loading : SydneyState()
    class Success(val data:CurrentCity):SydneyState()
    class Failure(val msg:Throwable):SydneyState()
    object Empty : SydneyState()
}


object Util{

     fun convertKelvinToCelsius(kelvin: Double): Float {
        return (kelvin - 273.15).toFloat()
    }

    fun toast(msg:String,context: Context)
    {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }
}