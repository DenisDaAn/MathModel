package com.example.pract.screens


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.madrapps.plot.line.DataPoint


sealed class Screen(val route: String) {
    object MainActivity : Screen("main_screen")
    object NOneScreen : Screen("none_screen")
    object NTwoScreen : Screen("ntwo_screen")
    object NThreeScreen : Screen("nthree_screen")
    object NFourScreen : Screen("nfour_screen")
}


@Composable
fun MainActivity(navController: NavController) {
    val heightforall = 45.dp
    val wightforall = 300.dp
    val fontsizeall = 15.sp
    val shapeall = 10.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Математическое моделирование",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 50.dp)
        )
        Button(
            onClick = { navController.navigate(Screen.NOneScreen.route) },
            modifier = Modifier
                .height(heightforall)
                .width(wightforall)
                .clip(shape = RoundedCornerShape(shapeall)),
            contentPadding = PaddingValues(5.dp)
        ) {
            Text(text = "Модель Мальтуса")
        }
        Text(text = "", fontSize = fontsizeall)
        Button(
            onClick = { navController.navigate(Screen.NTwoScreen.route) },
            modifier = Modifier
                .height(heightforall)
                .width(wightforall)
                .clip(shape = RoundedCornerShape(shapeall)),
            contentPadding = PaddingValues(5.dp)
        ) {
            Text(text = "Модель Лотки-Вольтерра")
        }
        Text(text = "", fontSize = fontsizeall)
        Button(
            onClick = { navController.navigate(Screen.NThreeScreen.route) },
            modifier = Modifier
                .height(heightforall)
                .width(wightforall)
                .clip(shape = RoundedCornerShape(shapeall)),
            contentPadding = PaddingValues(5.dp)
        ) {
            Text(text = "Решение матричной игры 3х3")
        }
        Text(text = "", fontSize = fontsizeall)
        Button(
            onClick = { navController.navigate(Screen.NFourScreen.route) },
            modifier = Modifier
                .height(heightforall)
                .width(wightforall)
                .clip(shape = RoundedCornerShape(shapeall)),
            contentPadding = PaddingValues(5.dp)
        ) {
            Text(text = "Выбор с деревом решений")
        }
    }
}

@Composable
fun NOneScreen(navController: NavController) {
    val maxheight = 60.dp
    val countpeople = remember { mutableStateOf("") }
    val yearstart = remember { mutableStateOf("") }
    val yearend = remember { mutableStateOf("") }
    val coefficientborn = remember { mutableStateOf("") }
    val coefficientdie = remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), Arrangement.SpaceEvenly) {
        Text(
            "Модель Мальтуса", textAlign = TextAlign.Center, fontSize = 18.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            val focusManager = LocalFocusManager.current
            TextField(
                countpeople.value,
                { countpeople.value = it },
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center, fontSize = 18.sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.moveFocus(
                        focusDirection = FocusDirection.Next,
                    )
                }),
                singleLine = true,
                modifier = Modifier
                    .width(100.dp)
                    .height(maxheight),
                placeholder = {
                    Text(
                        "Начальный год расчета",
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Green
                )
            )

            TextField(
                yearstart.value,
                { yearstart.value = it },
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center, fontSize = 18.sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.moveFocus(
                        focusDirection = FocusDirection.Next,
                    )
                }), singleLine = true,
                modifier = Modifier
                    .width(100.dp)
                    .height(maxheight),
                placeholder = {
                    Text(
                        "Конечный год расчета",
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )
                }, colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Green
                )
            )
            TextField(
                yearend.value,
                { yearend.value = it },
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center, fontSize = 18.sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .width(100.dp)
                    .height(maxheight),
                placeholder = {
                    Text(
                        "Начальная численность населения",
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Green
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp), horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            TextField(
                coefficientborn.value,
                { coefficientborn.value = it },
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center, fontSize = 18.sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .width(150.dp)
                    .height(maxheight),
                placeholder = {
                    Text(
                        "Коэффициент рождения",
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Green
                )
            )

            TextField(
                coefficientdie.value,
                { coefficientdie.value = it },
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center, fontSize = 18.sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .width(150.dp)
                    .height(maxheight),
                placeholder = {
                    Text(
                        "Коэффициент смерти",
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )
                }, colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Green
                )
            )
        }
        val bool = mutableStateOf(false)
        var f: Array<DataPoint> = arrayOf()
        Row(
            Modifier
                .fillMaxWidth(), Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp),
                onClick = {
                    val starting = yearstart.value.toInt()
                    val limiter = yearend.value.toInt()
                    var infopeople = countpeople.value.toInt()
                    val coef = coefficientborn.value.toInt() - coefficientdie.value.toInt()

                    for(i in starting..limiter){
                        f[i] = DataPoint((i.toString() + "f").toFloat(), (infopeople.toString() + "f").toFloat())
                        infopeople *= coef
                    }
                    bool.value = true
                },
            ) {
                Text(text = "da")

            }
            if (bool.value) {
                val counterstep = f.size
                val q = listOf(
                    f.toList()
                )
                SampleLineGraph(q, counterstep)
            }
        }

    }

}

@Composable
fun NTwoScreen(navController: NavController) {
    Text("Модель Лотки-Вольтерра")

}

@Composable
fun NThreeScreen(navController: NavController) {
    Text("Решение матричной игры 3х3 методом итераций")
}

@Composable
fun NFourScreen(navController: NavController) {
    Text("Выбор оптимального решения с помощью дерева решений")
}


