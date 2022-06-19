package com.example.pract.screens


import android.util.Log
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
        val bool1 = remember {
            mutableStateOf("")
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
            Button(
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp),
                onClick = { bool1.value += "1" },
            ) {
                Text(text = "Автозаполнение")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        ) {
            if (bool1.value.isNotEmpty()) {
                yearstart.value = "1950"
                yearend.value = "2050"
                coefficientborn.value = "0.0212"
                coefficientdie.value = "0.007"
                countpeople.value = "4564000"
                bool1.value = ""
            }
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
    val main : List<DataPoint> = listOf(DataPoint(1f, 200f), DataPoint(2f, 178f),DataPoint(3f, 180f),DataPoint(4f, 181f),DataPoint(5f, 181f),DataPoint(6f, 180f),DataPoint(7f, 178f),DataPoint(8f, 176f),DataPoint(9f, 173f),DataPoint(10f, 170f),DataPoint(11f, 167f),DataPoint(12f, 163f),DataPoint(13f, 160f),DataPoint(14f, 156f),DataPoint(15f, 152f),DataPoint(16f, 149f),DataPoint(17f, 145f),DataPoint(18f, 141f),DataPoint(19f, 138f),DataPoint(20f, 134f),DataPoint(21f, 130f))

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
                            "Биотический потенциал популяции жертв",
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
                            "Исходное число хищников",
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
                        var listpreys: MutableList<DataPoint> = mutableListOf()
                        listpreys.add(DataPoint(1f, preys.toFloat()))
                        var predators = bornpredator.value.toFloat()
                        var listpredators: MutableList<DataPoint> = mutableListOf()
                        listpredators.add(DataPoint(1f, predators.toFloat()))
                        for (i in 2..150) {
                            if ((countpredator.value.toFloat() - bioprey.value.toFloat() * bornpredator.value.toFloat()) * preys.toFloat() + preys.toFloat() > 0) {
                                preys =
                                    (countpredator.value.toFloat() - bioprey.value.toFloat() * bornpredator.value.toFloat()) * preys.toFloat() + preys.toFloat()
                                listpreys.add(DataPoint(i.toFloat(), preys.toFloat()))
                            } else {
                                preys = 0f
                                listpreys.add(DataPoint(i.toFloat(), preys.toFloat()))
                            }
                            Log.d("valueq1", preys.toString())
                            if ((coefficientdeath.value.toFloat() * preys - deathpredator.value.toFloat()) * predators.toFloat() + predators.toFloat() > 0) {
                                predators =
                                    (coefficientdeath.value.toFloat() * preys - deathpredator.value.toFloat()) * predators.toFloat() + predators.toFloat()
                            } else {
                                predators = 0f
                                listpreys.add(DataPoint(i.toFloat(), predators.toFloat()))
                            }
                            Log.d("valueq1", predators.toString())
                        }
                        val f: List<List<DataPoint>> =
                            listOf(listpreys.toList(), main.toList())
                        SampleLineGraph2(lines = f, countstep = 10)
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

    val maxheight = 50.dp
    val maxfontsizeall = 8.sp
    val buying = remember { mutableStateOf("") }
    val selling = remember { mutableStateOf("") }
    val counttov = remember { mutableStateOf("") }
    val ver1 = remember { mutableStateOf("") }
    val ver2 = remember { mutableStateOf("") }
    val ver3 = remember { mutableStateOf("") }
    val ver4 = remember { mutableStateOf("") }
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
                Text("Выбор оптимального решения с помощью дерева решений", fontSize = 18.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TextField(
                    buying.value,
                    { buying.value = it },
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
                            "Стоимость 1 ед. закупки",
                            fontSize = maxfontsizeall,
                            textAlign = TextAlign.Center
                        )
                    })
                TextField(
                    selling.value,
                    { selling.value = it },
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
                            "Стоимость 1 ед. продажи",
                            fontSize = maxfontsizeall,
                            textAlign = TextAlign.Center
                        )
                    })
                TextField(
                    ver1.value,
                    { ver1.value = it },
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
                            "Отсутствие продаж",
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
                    ver2.value,
                    { ver2.value = it },
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
                            "Низкие продажи",
                            fontSize = maxfontsizeall,
                            textAlign = TextAlign.Center
                        )
                    })
                TextField(
                    ver3.value,
                    { ver3.value = it },
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
                            "Средние продажи",
                            fontSize = maxfontsizeall,
                            textAlign = TextAlign.Center
                        )
                    })
                TextField(
                    ver4.value,
                    { ver4.value = it },
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
                            "Высокие продажи",
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
                    counttov.value,
                    { counttov.value = it },
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
                            "Макимальное количество проданных товаров",
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
                    if (buying.value.isNotEmpty() and selling.value.isNotEmpty() and ver1.value.isNotEmpty() and ver2.value.isNotEmpty() and ver3.value.isNotEmpty() and ver4.value.isNotEmpty()) {
                        if (ver1.value.toFloat() + ver2.value.toFloat() + ver3.value.toFloat() + ver4.value.toFloat() != 1f) {
                            bool.value = ""
                            Toast.makeText(
                                LocalContext.current,
                                "Сумма вероятностей должна быть равна 1",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        } else {
                            var min = 0f
                            var counter = 0
                            val avgsell = Math.round((counttov.value.toFloat() + 1) / 2)
                            val lowsell =
                                1 * (selling.value.toFloat() - buying.value.toFloat()) * ver2.value.toFloat()
                            val mediumsell =
                                avgsell.toFloat() * (selling.value.toFloat() - buying.value.toFloat()) * ver3.value.toFloat()
                            val highsell =
                                counttov.value.toFloat() * (selling.value.toFloat() - buying.value.toFloat()) * ver4.value.toFloat()
                            if (lowsell > mediumsell) {
                                min = lowsell;
                                counter = 1
                            } else {
                                min = mediumsell;
                                counter = avgsell
                            }
                            if (min < highsell) {
                                min = highsell;
                                counter = counttov.value.toInt()
                            }
                            if ((ver1.value.toFloat() > ver2.value.toFloat()) and (ver1.value.toFloat() > ver3.value.toFloat()) and (ver1.value.toFloat() > ver4.value.toFloat())) {
                                counter = 0
                                min = 0f
                            }
                            Text(text = "Максимальная прибыль будет с $counter продаж. Выручка составит ${counter * (selling.value.toFloat() - buying.value.toFloat())} ед. денег.")
                        }
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