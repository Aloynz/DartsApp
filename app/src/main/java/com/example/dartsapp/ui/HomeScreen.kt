package com.example.dartsapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dartsapp.data.DataSource.modeOptions


@Composable
fun HomeScreen(
    modeOptions: List<Pair<Int, Int>>,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
//            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        modeOptions.forEach { item ->
            SelectModeButton(
                labelResourceId = item.first,
                onClick = {onNextButtonClicked()}
            )
        }

    }
}

@Composable
fun SelectModeButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors =  when(stringResource(labelResourceId)) {
            "01" -> ButtonDefaults.buttonColors(backgroundColor = Color(255,97,97))
            "Cricket" -> ButtonDefaults.buttonColors(backgroundColor = Color(50, 58, 255))
            "Count Up" -> ButtonDefaults.buttonColors(backgroundColor = Color(0, 165, 16))
            "Leaderboard" -> ButtonDefaults.buttonColors(backgroundColor = Color(12, 48, 41))
            else -> ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        },
        modifier = modifier
            .width(315.dp)
            .height(105.dp)
            .border( width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))

    ) {
        Text(
            text = stringResource(labelResourceId),
            color = Color.White,
            style = MaterialTheme.typography.h1
        )

    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(modeOptions = modeOptions, onNextButtonClicked = {})
}