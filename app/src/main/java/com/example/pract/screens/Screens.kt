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
    val bool = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Column(modifier = Modifier.fillMaxSize(), Arrangement.SpaceEvenly) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(
                "Модель Мальтуса", fontSize = 18.sp
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {


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
                yearend.value,
                { yearend.value = it },
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
                countpeople.value,
                { countpeople.value = it },
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
                    .width(100.dp)
                    .height(maxheight),
                placeholder = {
                    Text(
                        "Коэффициент смерти",
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
            Modifier
                .fillMaxWidth(), Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp),
                onClick = { bool.value += "1" },
            ) {
                Text(text = "Расчитать")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        ) {
            if (bool.value.isNotEmpty()) {
                if (coefficientborn.value.isNotEmpty() and coefficientdie.value.isNotEmpty() and countpeople.value.isNotEmpty() and yearend.value.isNotEmpty() and yearstart.value.isNotEmpty()) {
                    val starting = yearstart.value.toInt()
                    val ending = yearend.value.toInt()
                    var infopeople = countpeople.value.toFloat()
                    val coef = coefficientborn.value.toFloat() - coefficientdie.value.toFloat()
                    val f: MutableList<DataPoint> = mutableListOf()
                    for (i in starting..ending) {
                        f.add(DataPoint(i.toFloat(), infopeople))
                        infopeople = infopeople + (infopeople * coef)
                    }
                    val q: List<List<DataPoint>> = listOf(f.toList())
                    SampleLineGraph(q, 10)
                } else {
                    bool.value = ""
                    Toast.makeText(LocalContext.current, "Заполните все поля", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }
    }
}

@Composable
fun NTwoScreen(navController: NavController) {
    val maxheight = 50.dp
    val maxfontsizeall = 8.sp
    val countprey = remember { mutableStateOf("") }
    val countpredator = remember { mutableStateOf("") }
    val bioprey = remember { mutableStateOf("") }
    val bornpredator = remember { mutableStateOf("") }
    val coefficientdeath = remember { mutableStateOf("") }
    val deathpredator = remember { mutableStateOf("") }
    val bool = remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("Модель Лотки-Вольтерра", fontSize = 18.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TextField(
                    countprey.value,
                    { countprey.value = it },
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
                            "Исходное число жертв",
                            fontSize = maxfontsizeall,
                            textAlign = TextAlign.Center
                        )
                    })
                TextField(
                    bioprey.value,
                    { bioprey.value = it },
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
                            "Биотический потенциал популяции жертв",
                            fontSize = maxfontsizeall,
                            textAlign = TextAlign.Center
                        )
                    })
                TextField(
                    coefficientdeath.value,
                    { coefficientdeath.value = it },
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
                            "Коэффициент гибели за счёт встречи жертвы с хищником",
                            fontSize = maxfontsizeall,
                            textAlign = TextAlign.Center
                        )
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TextField(
                    countpredator.value,
                    { countpredator.value = it },
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
                            "Исходное число хищников",
                            fontSize = maxfontsizeall,
                            textAlign = TextAlign.Center
                        )
                    })
                TextField(
                    bornpredator.value,
                    { bornpredator.value = it },
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
                            "Удельный коэффициент рождаемости «хищника»",
                            fontSize = maxfontsizeall,
                            textAlign = TextAlign.Center
                        )
                    })
                TextField(
                    deathpredator.value,
                    { deathpredator.value = it },
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
                            "Удельный коэффициент естественной смертности «хищника»",
                            fontSize = maxfontsizeall,
                            textAlign = TextAlign.Center
                        )
                    })
            }
            Row(
                Modifier
                    .fillMaxWidth(), Arrangement.SpaceEvenly
            ) {
                Button(
                    modifier = Modifier
                        .width(200.dp)
                        .height(40.dp),
                    onClick = { bool.value += "1" },
                ) {
                    Text(text = "Расчитать")
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {
                if (bool.value.isNotEmpty()) {
                    if (countprey.value.isNotEmpty() and countpredator.value.isNotEmpty() and bornpredator.value.isNotEmpty() and bioprey.value.isNotEmpty() and deathpredator.value.isNotEmpty() and coefficientdeath.value.isNotEmpty()) {
                        var preys = countprey.value.toFloat()
                        val listpreys: MutableList<Float> = mutableListOf(preys)
                        var predators = countpredator.value.toFloat()
                        val listpredators: MutableList<Float> = mutableListOf(predators)
                        while ((preys != 0f) and (predators != 0f)) {
                            if ((bioprey.value.toFloat() - coefficientdeath.value.toFloat() * predators) * preys + preys > 0) {
                                preys += (bioprey.value.toFloat() - coefficientdeath.value.toFloat() * predators) * preys
                                listpreys.add(preys)
                            } else {
                                preys = 0f
                                listpreys.add(preys)
                            }
                            if ((bornpredator.value.toFloat() * preys - coefficientdeath.value.toFloat()) * predators + predators > 0) {
                                predators += (bornpredator.value.toFloat() * preys - coefficientdeath.value.toFloat()) * predators
                                listpreys.add(predators)
                            } else {
                                predators = 0f
                                listpreys.add(predators)
                            }

                        }
                        DrawTable(listpreys, listpredators)
                    } else {
                        bool.value = ""
                        Toast.makeText(
                            LocalContext.current,
                            "Заполните все поля",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                }
            }

        }
    }
}


@Composable
fun NThreeScreen(navController: NavController) {
    Text("Решение матричной игры 3х3 методом итераций")
}

@Composable
fun NFourScreen(navController: NavController) {
    Text("Выбор оптимального решения с помощью дерева решений")
}