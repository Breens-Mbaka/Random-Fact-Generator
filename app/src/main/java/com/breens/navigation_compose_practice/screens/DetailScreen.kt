package com.breens.navigation_compose_practice.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.breens.navigation_compose_practice.ui.theme.NavigationComposePracticeTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(onNavigateToHomeScreen: () -> Unit, info: String?) {
    NavigationComposePracticeTheme {

        Scaffold(
            topBar = {
                TopAppBar() {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { onNavigateToHomeScreen() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }

                        Text(
                            text = "Random Fact !",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            },
            content = {
                Box(
                    Modifier
                        .padding(15.dp)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = info ?: "Info Not Found",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
    }
}