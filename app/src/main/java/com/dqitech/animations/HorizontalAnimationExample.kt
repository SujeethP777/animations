package com.dqitech.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dqitech.animations.ui.theme.AnimationsTheme

@Composable
fun HorizontalAnimationExample(modifier: Modifier = Modifier){

    Column(
        modifier = modifier
            .fillMaxSize()
    ){
        var isVisible by remember { mutableStateOf(false) }
        Button(onClick = {
            isVisible = !isVisible
        })
        {
            Text(text = "Toggle")
        }
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally() + fadeIn(),
            exit = fadeOut() + shrinkHorizontally(),
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(modifier = modifier
                .background(Color.Red))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HorizontalAnimationExamplePreview(){
    AnimationsTheme {
        HorizontalAnimationExample()
    }
}