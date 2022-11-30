package com.application.chatapp.presentation.login.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.application.chatapp.R

@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Welcome to BaatChit")
                }
            )
        }
    ) {
        LoginCompose()
    }
}

@Composable
fun LoginCompose() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement  = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.login),
                contentDescription = "login image"
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(10.dp)
            ) {
                Image(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = "google icon"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Login with Google"
                )
            }
        }
    }
}

