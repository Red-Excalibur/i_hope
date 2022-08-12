package com.project001.ui.mainScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.project001.data.remote.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@Composable
fun ShowMain  (
    viewModel: MainScreenViewModel= hiltViewModel()
){
    val animes = viewModel.data.collectAsState()

    val context = LocalContext.current



      Spacer(modifier = Modifier.height(10.dp))
      LazyColumn(
          modifier = Modifier.fillMaxSize()
      ){
          items(animes.value){anime ->
              MyCard(data = anime)

          }
      }

}

@Composable
fun MyCard(data:Data){

     Row(
         modifier = Modifier
             .fillMaxWidth()
             .padding(8.dp)
     ) {
         Image(
             painter = rememberAsyncImagePainter(data.anime_img),
             contentDescription = null,
             modifier = Modifier.size(150.dp)
         )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = " the anime name id : ${data.anime_id}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = " the anime name is :")
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = " ${data.anime_name}",
                fontSize = 18.sp,
                color = Color.Red,
                modifier = Modifier.fillMaxWidth()

            )
        }
     }
}

@Preview
@Composable
fun DefaultPreview(){
    ShowMain()
}