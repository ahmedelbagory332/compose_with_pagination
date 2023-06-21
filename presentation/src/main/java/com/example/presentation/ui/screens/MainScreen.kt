package com.example.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.presentation.theme.darkWhite
import com.example.presentation.ui.component.TopBar
import com.example.presentation.ui.widget.GenreList


@SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

   Scaffold(
       topBar = {
           TopBar(
               title = "Home Screen",
               menu = {

               }
           )
       }
   ) {
       Column(
           modifier = Modifier
               .background(darkWhite)
               .fillMaxWidth()
               .fillMaxHeight()
       ) {

           GenreList()

       }
   }


}