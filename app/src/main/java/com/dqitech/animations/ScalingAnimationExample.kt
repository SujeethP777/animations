package com.dqitech.animations

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dqitech.animations.ui.theme.AnimationsTheme

@Composable
fun ScalingAnimationExample(modifier: Modifier = Modifier) {
    var sizeState by remember { mutableStateOf(50.dp) }
    val size by animateDpAsState(
        targetValue = sizeState,
        animationSpec = tween(durationMillis = 1000,
            easing = LinearEasing
        ),
        label = ""
    )
    Column (
        modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = { sizeState *= 2 }) {
            Text(text = "Click here!")
        }
        Spacer(modifier = modifier.height(16.dp))
        Box(modifier = modifier
            .size(size)
            .background(color = Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScalingAnimationExamplePreview() {
    AnimationsTheme {
        ScalingAnimationExample()
    }
}