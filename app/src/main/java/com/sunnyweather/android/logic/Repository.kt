package com.sunnyweather.android.logic

import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException

object Repository {
    fun searchPlace(query:String)=liveData(Dispatchers.IO){
val result=try{
    val placeSponse=SunnyWeatherNetwork.searchPlace(query)
    if(placeSponse.statue=="ok"){Result.success(placeSponse.place)}
    else Result.failure(RuntimeException(""))
}
catch(e:Exception){Result.failure<List<Place>>(e)}
    emit(result)}
}
