package com.umitytsr.kotlincountries.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.umitytsr.kotlincountries.model.Country

@Database(entities = arrayOf(Country::class), version = 1)
abstract class CountryDataBase : RoomDatabase() {

    abstract fun countryDao() : CountryDao

    //Singleton
    companion object{

        @Volatile private var instance : CountryDataBase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDataBase(context).also {
                instance = it
            }
        }

        private fun makeDataBase(context : Context) = Room.databaseBuilder(
            context.applicationContext,CountryDataBase::class.java,"countrydatabase"
        ).build()
    }
}