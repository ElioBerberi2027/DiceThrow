package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {

    private val _die1Roll = MutableLiveData<Int>()
    val die1Roll : LiveData<Int> = _die1Roll

    private val _die2Roll = MutableLiveData<Int>()
    val die2Roll : LiveData<Int> = _die2Roll

    fun rollDie(dieSide: Int){
        _die1Roll.value = Random.nextInt(1,dieSide + 1)
    }

    fun rollDie2(dieSide : Int){
        _die2Roll.value = Random.nextInt(1,dieSide + 1)
    }
}