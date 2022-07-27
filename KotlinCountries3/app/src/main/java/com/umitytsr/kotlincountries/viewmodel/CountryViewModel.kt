package com.umitytsr.kotlincountries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.umitytsr.kotlincountries.model.Country
import com.umitytsr.kotlincountries.service.CountryDataBase
import kotlinx.coroutines.launch
import java.util.*

class CountryViewModel(application: Application) : BaseViewModel(application){

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(uuid: Int){
        launch {
            val dao = CountryDataBase(getApplication()).countryDao()
            val country = dao.getCountry(uuid)
            countryLiveData.value = country
        }


    }
}