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
fun ModeScreen(
    zeroOneModeOptions: List<Pair<Int,Int>>,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
//            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(35.dp)
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        zeroOneModeOptions.forEach { item ->
            SelectZeroOneModeButton(
                labelResourceId = item.first,
                onClick = {onNextButtonClicked()}
            )
        }

    }
}

@Composable
fun SelectZeroOneModeButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(315.dp)
            .height(75.dp)
            .border( width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(255,97,97))
    ) {
        Text(text = stringResource(labelResourceId), color = Color.White, style = MaterialTheme.typography.h1)
    }
}