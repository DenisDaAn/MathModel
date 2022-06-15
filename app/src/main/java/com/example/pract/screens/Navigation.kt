package com.example.pract.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph
import com.madrapps.plot.line.LinePlot

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainActivity.route) {
        composable(route = Screen.MainActivity.route) {
            MainActivity(navController = navController)
        }
        composable(route = Screen.NOneScreen.route) {
            NOneScreen(navController = navController)
        }
        composable(route = Screen.NTwoScreen.route) {
            NTwoScreen(navController = navController)
        }
        composable(route = Screen.NThreeScreen.route) {
            NThreeScreen(navController = navController)
        }
        composable(route = Screen.NFourScreen.route) {
            NFourScreen(navController = navController)
        }

    }
}

@Composable
fun SampleLineGraph(lines: List<List<DataPoint>>, countstep: Int) {
    val context = LocalContext.current
    val points2 = remember { mutableStateOf("") }
    val stroke = Stroke(
        width = 5f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 15f), 1f)
    )

    Box(
        Modifier
            .fillMaxSize()
            .height(350.dp)
            .padding(20.dp), contentAlignment = Alignment.BottomCenter
    ) {
        Canvas(
            Modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(20.dp)
        ) {
            drawRoundRect(color = Color.Red, style = stroke)
        }
        LineGraph(
            plot = LinePlot(
                listOf(
                    LinePlot.Line(
                        dataPoints = lines[0],
                        LinePlot.Connection(color = Color.Red),
                        LinePlot.Intersection(color = Color.Red),
                        LinePlot.Highlight(color = Color.Red),
                        //LinePlot.XAxis(stepSize = 20.dp, steps = 1, paddingBottom = 10.dp, paddingTop = 10.dp, unit = 1f, roundToInt = false, content = {}
                    )
                ),
                grid = LinePlot.Grid(Color.Blue, steps = countstep),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(20.dp),
            onSelection = { xLine, points ->
                points2.value = points.toString()
            }
        )
        Text(text = points2.value, Modifier.padding(top = 30.dp))
    }

}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}

@Composable
fun DrawTable(preys: MutableList<Float>, predators: MutableList<Float>) {
    val column1Weight = .5f
    val column2Weight = .5f
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(16.dp)
    ) {
        item {
            Row(Modifier.background(Color.Gray)) {
                TableCell(text = "Жертвы", weight = column1Weight)
                TableCell(text = "Хищники", weight = column2Weight)
            }
        }
        /*items(predators.size) {
            Row(Modifier.fillMaxWidth()) {
                for (i in 0..predators.size) {
                    TableCell(text = preys[i].toString(), weight = column1Weight)
                    TableCell(text = predators[i].toString(), weight = column2Weight)
                }
            }
        }*/
    }
}