package com.nikhil.wahwah

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val mainRepo: MainRepo = MainRepo()

    private val _list: MutableLiveData<List<Data>> = MutableLiveData()
    val liveList: LiveData<List<Data>>
        get() = _list

    fun searchFor(query: String) {
        _list.postValue(mainRepo.getFilteredList(query))
    }

    fun showCompleteList() {
        _list.postValue(mainRepo.dataList)
    }

}