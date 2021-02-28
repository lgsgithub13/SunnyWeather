package com.sunnyweather.android.ui.place


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.Transformations.switchMap
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Place

class PlaceViewModel: ViewModel() {
    val placeLiveData=MutableLiveData<String>()
    val place=ArrayList<Place>()
    val searchLiveData= Transformations.switchMap(placeLiveData){ query->Repository.searchPlace(query)}
    fun searchPlace(query:String){placeLiveData.value=query}
}