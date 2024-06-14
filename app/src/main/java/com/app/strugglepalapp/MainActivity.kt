package com.app.strugglepalapp

import UnitDatabaseService
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.app.strugglepalapp.ui.theme.StrugglePalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrugglePalAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfilePicture(
                        "Kalani, Super Tactical Robot",
                        modifier = Modifier.padding(innerPadding)
                        )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier.weight(1f)
        )
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data("https://shatterpointdb.com/media/fx4lex3u/star-wars-shatterpoint-grievous-unit-card.png")
                .crossfade(true)
                .build(),
            contentDescription = "example",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ProfilePicture(unitName: String, modifier: Modifier = Modifier) {
    val database = UnitDatabaseService()
    val unit = database.unitList.find { it.name == unitName }

    if (unit != null) {
        val painter = painterResource(id = R.drawable.grievous1)

        Column {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(unit.stanceCardUrl1)
                    .build(),
                contentDescription = unit.name,
                modifier = modifier
                    .clip(CircleShape)
                    .scale(10f)
                    .size(50.dp)
                    .offset(x = -7.1.dp, y = 11.5.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StrugglePalAppTheme {
        ProfilePicture("Kalani, Super Tactical Robot")
    }
}