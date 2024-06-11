package com.raveli.businesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raveli.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally  ) {
            BusinessCardIntro(image = painterResource(
                id =R.drawable.profileimg),
                fullName = "Joseph Climber",
                title = "Senior Software Engineer"
            )
        }
        Column(modifier = Modifier
            .padding(16.dp)
            .width(IntrinsicSize.Max)
            .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally  ) {
            BusinessCardDetails(
                phone = "+1 123 456 7890",
                socialMediaURL = "https://www.linkedin.com/in/josephclimber",
                email = "joseph@climber.com"
            )
        }
    }
}

@Composable
fun BusinessCardIntro(image: Painter, fullName: String, title: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(104.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.padding(8.dp)
        )
    }
        Text(
            text = fullName,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            fontSize = 35.sp

        )
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
}

@Composable
fun BusinessCardDetails(phone: String, socialMediaURL: String, email: String, modifier: Modifier = Modifier) {
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Rounded.Phone ,
                contentDescription = "Phone",
                modifier = modifier.padding(end = 16.dp)
            )
            Text(
                text = phone,
                modifier = modifier.fillMaxWidth()
            )
        }
        Row (modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Rounded.AccountBox ,
                contentDescription = "Social Media Link",
                modifier = modifier.padding(end = 16.dp)
            )
            Text(
                text = socialMediaURL,
                modifier = modifier.fillMaxWidth()
            )
        }
        Row (modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Rounded.Email ,
                contentDescription = "Email address",
                modifier = modifier.padding(end = 16.dp)
            )
            Text(
                text = email,
                modifier = modifier.fillMaxWidth()
            )
        }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCard()
}