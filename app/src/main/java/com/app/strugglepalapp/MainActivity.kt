package com.app.strugglepalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.app.strugglepalapp.data.Unit
import com.app.strugglepalapp.ui.theme.MainBackgroundColor
import com.app.strugglepalapp.ui.theme.StrugglePalAppTheme
import com.app.strugglepalapp.ui.theme.UnitKeyWordsColor
import com.app.strugglepalapp.ui.theme.UnitNameColor
import com.app.strugglepalapp.ui.theme.UnitTypeColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrugglePalAppTheme {
                Scaffold(
                    topBar = {
                        Text(text = "Todo: Add menu")
                    },
                    bottomBar = {
                        Text(text = "Todo: add unit array")
                    },
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    UnitList(
                        unitList = UnitDatabaseService().unitList,
                        modifier = Modifier
                            .background(
                                color = MainBackgroundColor
                            )
                            .padding(innerPadding)
                        )
                }
            }
        }
    }
}

@Composable
fun UnitRow(unitName: String, modifier: Modifier = Modifier){
    val database = UnitDatabaseService()
    val unit = database.unitList.find { it.name == unitName }

    Row(
        modifier = modifier
            .padding(
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ){
        ProfilePicture(
            unitName,
            modifier = Modifier
                .padding(8.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
        ){
            Text(
                text = unitName,
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = UnitNameColor
            )
            Text(
                unit?.type.toString(),
                modifier = Modifier,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = UnitTypeColor
            )
            unit?.keyWords?.let {
                Text(
                    it.joinToString(),
                    modifier = Modifier,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                    color = UnitKeyWordsColor
                )
            }
        }
        IconButton(
            modifier = Modifier
                .padding(4.dp),
            onClick = { },

            ){
            Icon(
                painter = painterResource(id = R.drawable.card_detail),
                contentDescription = "detail button",
                tint = UnitNameColor
            )
        }
    }
}

@Composable
fun UnitList(unitList: List<Unit>, modifier: Modifier = Modifier){
    LazyColumn (modifier = modifier){
        items(unitList){it ->
            UnitRow(unitName = it.name)
        }
    }
}


@Composable
fun ProfilePicture(unitName: String, modifier: Modifier = Modifier) {
    val database = UnitDatabaseService()
    val unit = database.unitList.find { it.name == unitName }

    if (unit != null) {
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
fun PagePreview() {
    StrugglePalAppTheme {
        UnitRow("Kalani, Super Tactical Robot")
    }
}