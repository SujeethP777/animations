package com.dqitech.animations

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun TransitionAnimationExample() {
    var isToggled by remember { mutableStateOf(false) }

    val size by animateDpAsState(
        targetValue = if (isToggled) 200.dp else 100.dp,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing
        ), label = "size"
    )

    val offsetX by animateDpAsState(
        targetValue = if (isToggled) 100.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing
        ), label = "offsetX"
    )

    val offsetY by animateDpAsState(
        targetValue = if (isToggled) 100.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing
        ), label = "offsetY"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .offset(x = offsetX, y = offsetY)
                .background(Color.Blue)
                .clickable {
                    isToggled = !isToggled
                }
        )
    }
}

@Preview
@Composable
fun TransitionAnimationExamplePreview(){
  AnimationsTheme {
     TransitionAnimationExample()
  }
}
