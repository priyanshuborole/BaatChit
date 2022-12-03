package com.application.chatapp.presentation.profile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.application.chatapp.R
import com.application.chatapp.presentation.ui.theme.primaryColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Profile")
                }
            )
        }
    ) {
        ProfileComposable()
    }
}

@Composable
fun ProfileComposable() {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Card(
            modifier = Modifier
                .size(100.dp)
                .border(1.dp, primaryColor, CircleShape),
            shape = CircleShape,
            elevation = 10.dp,
        ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_demo),
                    modifier = Modifier,
                    alignment = Alignment.Center,
                    contentDescription = "Camera Icon"
                )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Blandit molest congue, condimentum vestibulum, auctor curabitur aliquam sagittis habitant rutrum ad. Senectus sit nec aenean, magna fringilla rhoncus vivamus lectus. Suscipit congue duis, est velit ultricies phasellus ad. Urna eleifend per, praesent varius, etiam hendrerit habitant eros amet suscipit ante. Ut dui bibendum porttitor, elementum commodo sodales, phasellus maecenas lacus inceptos proin justo. Rutrum aptent quam, eu euismod tempus interdum porta. Odio volutpat donec, ac diam cubilia nisl. Amet ipsum placerat, aliquet pellentesque, per donec vehicula nulla proin tincidunt. Metus interdum primis, placerat hac eros semper.")
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Icon(Icons.Filled.Email, contentDescription = "email" )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "abc@gmail.com")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Icon(Icons.Filled.DateRange, contentDescription = "dob" )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "03/12/2022")
        }

    }
}