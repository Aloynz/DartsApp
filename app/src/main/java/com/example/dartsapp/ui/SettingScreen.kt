package com.example.dartsapp.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.dartsapp.R
import java.security.AllPermission

@Composable
fun SettingScreen(
    onBullOptionSelectionChanged : (String) -> Unit = {},
    onInOptionSelectionChanged : (String) -> Unit = {},
    onNumberOfRoundsSelectionChanged : (String) -> Unit = {},
    onShanghaiSelectionChanged : (String) -> Unit = {},
    onOutOptionSelectionChanged : (String) -> Unit ={},
    onGameOnButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var bullOptions = listOf("25/50", "50/50")
    var selectedBullOption by rememberSaveable() { mutableStateOf("") }

    var inOptions = listOf("Open", "Double", "Triple", "Master")
    var selectedInOption by rememberSaveable() { mutableStateOf("") }

    var numberOfRoundsOptions = listOf("10", "15", "20", "25", "30", "No Limit")
    var selectedNumberOfRoundsOption by rememberSaveable() { mutableStateOf("") }

    var shanghaiOptions = listOf("Off", "On")
    var selectedShanghaiOption by rememberSaveable() { mutableStateOf("") }

    var outOptions = listOf("Open", "Double", "Triple", "Master")
    var selectedOutOption by rememberSaveable() { mutableStateOf("") }


    Row(modifier = modifier.padding(5.dp)) {
        Column(modifier = modifier.padding(16.dp, 10.dp, 16.dp).weight(2f)) {

            //bullsettings
            Text("Bull")
            bullOptions.forEach { item ->
                Row (
                    modifier = Modifier.selectable(
                        selected = selectedBullOption == item,
                        onClick = {
                            selectedBullOption = item
                            onBullOptionSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    RadioButton (
                        selected = selectedBullOption == item,
                        onClick = {
                            selectedBullOption = item
                            onBullOptionSelectionChanged(item)
                        }
                    )
                    Text(item)

                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            //in option
            Text("In Option")
            inOptions.forEach { item ->
                Row (
                    modifier = Modifier.selectable(
                        selected = selectedInOption == item,
                        onClick = {
                            selectedInOption = item
                            onInOptionSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    RadioButton (
                        selected = selectedInOption == item,
                        onClick = {
                            selectedInOption = item
                            onInOptionSelectionChanged(item)
                        }
                    )
                    Text(item)

                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            //Number of rounds Options
            Text("Number of rounds")
            numberOfRoundsOptions.forEach { item ->
                Row (
                    modifier = Modifier.selectable(
                        selected = selectedNumberOfRoundsOption == item,
                        onClick = {
                            selectedNumberOfRoundsOption = item
                            onNumberOfRoundsSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    RadioButton (
                        selected = selectedNumberOfRoundsOption == item,
                        onClick = {
                            selectedNumberOfRoundsOption = item
                            onNumberOfRoundsSelectionChanged(item)
                        }
                    )
                    Text(item)

                }
            }

        }

        Column(modifier = modifier.padding(16.dp, 10.dp, 0.dp).weight(2f)) {

            //Shanghai Options
            Text("Shanghai")
            shanghaiOptions.forEach { item ->
                Row (
                    modifier = Modifier.selectable(
                        selected = selectedShanghaiOption == item,
                        onClick = {
                            selectedShanghaiOption = item
                            onShanghaiSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    RadioButton (
                        selected = selectedShanghaiOption == item,
                        onClick = {
                            selectedShanghaiOption = item
                            onShanghaiSelectionChanged(item)
                        }
                    )
                    Text(item)

                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            //Out Option
            Text("Out Option")
            outOptions.forEach { item ->
                Row (
                    modifier = Modifier.selectable(
                        selected = selectedOutOption == item,
                        onClick = {
                            selectedOutOption = item
                            onOutOptionSelectionChanged(item)
                        }
                    ),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    RadioButton (
                        selected = selectedOutOption == item,
                        onClick = {
                            selectedOutOption = item
                            onOutOptionSelectionChanged(item)
                        }
                    )
                    Text(item)

                }
            }

            Spacer(modifier = Modifier.height(200.dp))

        }

        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(246,0, 0)),
                enabled = selectedBullOption.isNotEmpty() && selectedInOption.isNotEmpty()
                        && selectedOutOption.isNotEmpty() && selectedShanghaiOption.isNotEmpty()
                        && selectedNumberOfRoundsOption.isNotEmpty(),

                modifier = modifier
                    .width(140.dp)
                    .height(80.dp)
                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),

                onClick = onGameOnButtonClicked
            ) {
                Text(stringResource(R.string.gameon))
            }

        }



    }

}

@Preview
@Composable
fun SettingScreenPreview() {
    SettingScreen()
}