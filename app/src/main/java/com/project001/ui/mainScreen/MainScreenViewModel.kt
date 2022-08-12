package com.project001.ui.mainScreen

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project001.contextt
import com.project001.data.remote.Data
import com.project001.domain.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
 private val repository:AnimeRepository
)  :ViewModel(){


    private val _data = MutableStateFlow<List<Data>>(emptyList())
    val data : StateFlow<List<Data>> = _data

init {
    getData()
}

       fun getData() {
           viewModelScope.launch(Dispatchers.IO) {

               val response =
                   try {
                              viewModelScope.launch(Dispatchers.Main) {
                               Toast.makeText(contextt,"we tried",Toast.LENGTH_SHORT).show()}
                            delay(1000)
                            repository.getAnimes()

                   } catch (e: IOException){
                       viewModelScope.launch(Dispatchers.Main) {
                           Toast.makeText(contextt,"Io exception",Toast.LENGTH_SHORT).show()
                       }
                       return@launch
                   }catch (e: HttpException){
                       viewModelScope.launch(Dispatchers.Main) {
                           Toast.makeText(contextt,"Http Exception",Toast.LENGTH_SHORT).show()
                       }
                       return@launch
                   }
               if(response.isSuccessful   /* && response.body()!=null*/) {
                   if( response.body()== null){
                       viewModelScope.launch(Dispatchers.Main) {
                           Toast.makeText(contextt,"body is null",Toast.LENGTH_SHORT).show()
                       }
                   }

                   viewModelScope.launch(Dispatchers.Main) {
                       Toast.makeText(contextt, "it was successful", Toast.LENGTH_SHORT).show()
                   }
                   delay(1000)
                   _data.value = response.body()?.data !!

                   delay(2000)


           }else {
                   viewModelScope.launch(Dispatchers.Main){
                       Toast.makeText(contextt,"it was not successful",Toast.LENGTH_SHORT).show()
                   }

               }
           }
           }


}