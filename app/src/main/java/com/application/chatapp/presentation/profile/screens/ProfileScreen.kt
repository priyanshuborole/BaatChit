package com.application.chatapp.presentation.profile.screens

import android.graphics.Paint.Style
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.chatapp.R
import com.application.chatapp.model.Gender
import com.application.chatapp.presentation.ui.theme.primaryColor


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
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            modifier = Modifier
                .size(100.dp)
                .border(1.dp, primaryColor, CircleShape),
            shape = CircleShape,
            elevation = 10.dp,
        ){
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .wrapContentWidth(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.camera_icon),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "Camera Icon"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Add Image",
                    color = primaryColor
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        var name by remember{
            mutableStateOf("")
        }
        var email by remember{
            mutableStateOf("")
        }
        var bio by remember{
            mutableStateOf("")
        }
        var gender by remember{
            mutableStateOf("")
        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = { nameValue ->
                name = nameValue
            },
            leadingIcon = {
                Icon(Icons.Filled.Person, contentDescription = "Name icon")
            },
            label = {
                Text(text = "Name")
            },
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { emailValue ->
                email = emailValue
            },
            leadingIcon = {
                Icon(Icons.Filled.Email, contentDescription = "Email icon")
            },
            label = {
                Text(text = "Email")
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = bio,
            onValueChange = { bioValue ->
                bio = bioValue
            },
            leadingIcon = {
                Icon(Icons.Filled.Info, contentDescription = "Bio icon")
            },
            label = {
                Text(text = "Bio")
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            //TODO make extension function for color
            .background(Color(0x14962EB3))
            .padding(10.dp)){
            Column(
                modifier = Modifier.wrapContentSize(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Gender", modifier = Modifier.align(Alignment.Start), fontSize = 20.sp)
               Gender.values().forEach {
                   Row() {
                       RadioButton(
                           selected = gender == it.toString(),
                           onClick = { gender = it.toString() },
                           colors = RadioButtonDefaults.colors(
                               selectedColor = primaryColor
                           )
                       )
                       Text(
                           text = it.toString(),
                           modifier = Modifier.align(Alignment.CenterVertically)
                       )
                   }
               }
            }
        }
    }
}