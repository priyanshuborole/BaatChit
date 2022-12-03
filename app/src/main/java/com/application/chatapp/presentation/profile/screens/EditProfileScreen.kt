package com.application.chatapp.presentation.profile.screens

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.application.chatapp.R
import com.application.chatapp.model.Gender
import com.application.chatapp.presentation.ui.theme.primaryColor
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Profile")
                }
            )
        }
    ) {
        EditProfileComposable()
    }
}

@Composable
fun EditProfileComposable() {
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
        var mDate by remember {
            mutableStateOf("")
        }
        var pickedDate by remember {
            mutableStateOf(LocalDate.now())
        }
        val formattedDate by remember {
            derivedStateOf {
                DateTimeFormatter
                    .ofPattern("dd/MM/yyyy")
                    .format(pickedDate)
            }
        }
        val dateDialogState = rememberMaterialDialogState()
        val mContext = LocalContext.current
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
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { dateDialogState.show() }),
            value = formattedDate,
            onValueChange = {
            },
            leadingIcon = {
                Icon(Icons.Filled.DateRange, contentDescription = "Date icon")
            },
            label = {
                Text(text = "Date of Birth")
            },
        )
        MaterialDialog(
            dialogState = dateDialogState,
            buttons = {
                positiveButton(text = "Ok") {
                    Toast.makeText(
                        mContext,
                        "Clicked ok",
                        Toast.LENGTH_LONG
                    ).show()
                }
                negativeButton(text = "Cancel")
            }
        ) {
            datepicker(
                initialDate = LocalDate.now(),
                title = "Pick a date",
                allowedDateValidator = {
                    it.dayOfMonth % 2 == 1
                }
            ) {
                pickedDate = it
            }
        }
    }
}

fun DatePicker(mDate: MutableState<String>, mContext: Context){
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mCalendar = Calendar.getInstance()
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, mYear, mMonth, mDay
    )
    mDatePickerDialog.show()
}