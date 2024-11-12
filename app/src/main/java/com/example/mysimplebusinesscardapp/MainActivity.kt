package com.example.mysimplebusinesscardapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysimplebusinesscardapp.ui.theme.MySimpleBusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MySimpleBusinessCardAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                ){
                    MyFullApp()
                }
            }
        }
    }
}

@Composable
fun MyFullApp(
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
            .fillMaxSize()
    ){
        LogoNameTitle(
            "My First Business Card","Captain-D",
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Column (
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp)
        ){
            ContactInformation(
                image = painterResource(R.drawable.mobile_16076069),
                description = "+255 758548912",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            ContactInformation(
                image = painterResource(R.drawable.browser_11370082),
                description = "https://denisjovitusbuberwa.com",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            ContactInformation(
                image = painterResource(R.drawable.email_8725723),
                description = "denisjovitusbuberwa@gmail.com",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                )
        }
    }
}

@Composable
fun LogoNameTitle(name:String,
                  title:String,
                  modifier: Modifier
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =modifier
            .padding(16.dp)

    ) {
        Image(
            painter = painterResource(R.drawable.mimipic),
            contentDescription = null,
            modifier =modifier
                .size(500.dp)
                .padding(bottom = 8.dp)
        )
        Text(
            text = name,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = title
        )
    }

}

@Composable
fun ContactInformation(
    image: Painter,
    description:String,
    modifier: Modifier
){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(vertical = 4.dp)
        ){
            Image(
                painter= image,
                contentDescription = null,
                Modifier.size(30.dp)
            )
            Text(
                text = description,
                modifier = Modifier.weight(1f)
            )
        }

    }


@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MySimpleBusinessCardAppTheme {
        MyFullApp()
    }
}