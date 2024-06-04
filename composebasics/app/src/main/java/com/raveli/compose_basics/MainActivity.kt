package com.raveli.compose_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raveli.compose_basics.ui.theme.ComposebasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposebasicsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ComposeTutorial()
                }
            }
        }
    }
}

@Composable
fun ComposeTutorial() {
    Tutorial(
        painterResource(id = R.drawable.bg_compose_background),
        stringResource(R.string.tutorial_heading_text),
        stringResource(R.string.tutorial_description_text),
        stringResource(R.string.tutorial_details_text),
    )
}

@Composable
fun Tutorial(
             image: Painter,
             heading: String,
             description: String,
             details: String,
             modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = heading,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        )
        Text(
            text = details,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp),
        )
    }

}

@Preview(showBackground = true)
@Composable
fun TutorialPreview() {
    ComposebasicsTheme {
        ComposeTutorial()
    }
}