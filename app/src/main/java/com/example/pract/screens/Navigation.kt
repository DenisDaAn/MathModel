package com.example.pract.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
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
                        LinePlot.Highlight(color = Color.Red)
                    )
                ),
                grid = LinePlot.Grid(Color.Blue, steps = countstep),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(20.dp),
            onSelection = { xLine, points ->

            }
        )
    }

}



