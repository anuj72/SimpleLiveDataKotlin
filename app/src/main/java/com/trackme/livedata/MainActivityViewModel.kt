package com.trackme.livedata

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel:ViewModel() {
    var TAG:String=this.javaClass.name
    var myRandomNumber: MutableLiveData<String>? =null

    fun getNumber(): MutableLiveData<String>? {
        Log.i(TAG, "Get number")
        if (myRandomNumber == null) {
            myRandomNumber=MutableLiveData()
            createNumber()
        }
        return myRandomNumber
    }

    public fun createNumber() {
        Log.i(TAG, "Create new number")
        val random = Random()
        myRandomNumber!!.value="Number: " + (random.nextInt(10 - 1) + 1)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "ViewModel Destroyed")
    }
}