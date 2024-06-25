package com.app.strugglepalapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.strugglepalapp.data.Unit
import com.app.strugglepalapp.data.UnitType
import com.app.strugglepalapp.ui.theme.MainBackgroundColor
import com.app.strugglepalapp.ui.theme.StrugglePalAppTheme
import com.app.strugglepalapp.ui.theme.UnitKeyWordsColor
import com.app.strugglepalapp.ui.theme.UnitNameColor
import com.app.strugglepalapp.ui.theme.UnitTypeColor

var unitDatabaseService = UnitDatabaseService()

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrugglePalAppTheme {

                val mainActivityViewModel:MainActivityViewModel = viewModel()

                Scaffold(
                    topBar = {
                        Text(text = "Todo: Add menu")
                    },
                    bottomBar = {
                        ArrayUnit(mainActivityViewModel.unitArray, Modifier)
                    },
                    modifier = Modifier
                        .fillMaxSize(),
                    content = { innerPadding ->
                        UnitList(
                            unitList = unitDatabaseService.unitList,
                            arrayUnit = mainActivityViewModel.unitArray,
                            modifier = Modifier
                                .background(
                                    color = MainBackgroundColor
                                )
                                .padding(innerPadding)
                        )
                    }
                )
            }
        }
    }
}

fun isProbablyAnEmulator() = Build.FINGERPRINT.startsWith("generic")
        || Build.FINGERPRINT.startsWith("unknown")
        || Build.MODEL.contains("google_sdk")
        || Build.MODEL.contains("Emulator")
        || Build.MODEL.contains("Android SDK built for x86")
        || Build.BOARD == "QC_Reference_Phone" //bluestacks
        || Build.MANUFACTURER.contains("Genymotion")
        || Build.HOST.startsWith("Build") //MSI App Player
        || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
        || "google_sdk" == Build.PRODUCT

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
                lineHeight = 16.sp,
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

fun ClickUnitRow(unit: Unit, arrayUnit: MutableList<Unit?>){
    var index = 0;

    // case: Unit already exists. Remove the unit from the selection
    var unitFound = arrayUnit.find { it?.name == unit.name }
    if(unitFound != null) {
        arrayUnit[arrayUnit.indexOf(unitFound)] = null
        // todo: save
        return
    }

    // Case: this name unit does not exist => do nothing
    var unit = UnitDatabaseService().unitList.find { it.name == unit.name }
    if(unit == null)
        return

    // Case: Only if a slot is selected: replace the slot.
    // Todo when slot is a thing

    // Case: Unit type full => do nothing, cannot add the unit
    if(arrayUnit.filter { it?.type ==  unit.type}.count() >= 2)
        return

    // Case: nominal => add Unit to the selection
    if(arrayUnit[0]?.name != unit.name) {
        addUnitToSelectionArray(unit, arrayUnit)
    }
}

fun addUnitToSelectionArray(unit: Unit, arrayUnit: MutableList<Unit?>) {
    // Add unit to the unit selection
    when (unit.type) {
        UnitType.Primary -> {
            if (arrayUnit[0] == null)
                arrayUnit[0] = unit
            else
                arrayUnit[3] = unit
        }
        UnitType.Secondary -> {
            if (arrayUnit[1] == null)
                arrayUnit[1] = unit
            else
                arrayUnit[4] = unit
        }
        UnitType.Support -> {
            if (arrayUnit[2] == null)
                arrayUnit[2] = unit
            else
                arrayUnit[5] = unit
        }
    }
}


@Composable
fun ArrayUnit(unitArray: List<Unit?>, modifier: Modifier = Modifier){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        unitArray.forEach {
            if(it != null){
                ProfilePicture(
                    unitName = it.name
                )
            }
            else{
                ProfilePicture(
                    unitName = "no unit"
                )
            }
        }
    }

}
        
@Composable
fun UnitList(unitList: List<Unit>, arrayUnit: MutableList<Unit?> ,modifier: Modifier = Modifier){
    LazyColumn (modifier = modifier){
        items(unitList){it ->
            UnitRow(unitName = it.name,
                Modifier.clickable(
                    onClick = {
                        ClickUnitRow(it, arrayUnit)
                    }
                )
            )
        }
    }
}


@Composable
fun ProfilePicture(unitName: String, modifier: Modifier = Modifier) {
    val database = UnitDatabaseService()
    val unit = database.unitList.find { it.name == unitName }


    if (unit != null) {
        Image(
            painter = painterResource(id = R.drawable.grievous1),
            contentDescription = "default pp",

            modifier = modifier
                .clip(CircleShape)
                .border(2.dp, Color.Black, shape = CircleShape)
                .scale(10f)
                .size(50.dp)
                .offset(x = -7.1.dp, y = 11.5.dp)
        )
    }
    else {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "default pp",

            modifier = modifier
                .clip(CircleShape)
                .border(2.dp, Color.Black, shape = CircleShape)
                .scale(10f)
                .size(50.dp)
                .offset(x = -7.1.dp, y = 11.5.dp)
        )
    }
}


//            AsyncImage(
//                model = ImageRequest.Builder(context = LocalContext.current)
//                    .data(unit.stanceCardUrl1)
//                    .build(),
//                contentDescription = unit.name,
//                modifier = modifier
//                    .clip(CircleShape)
//                    .scale(10f)
//                    .size(50.dp)
//                    .offset(x = -7.1.dp, y = 11.5.dp)
//            )

@Preview(showBackground = true)
@Composable
fun PagePreview() {
    StrugglePalAppTheme {
        UnitRow("Kalani, Super Tactical Robot")
    }
}