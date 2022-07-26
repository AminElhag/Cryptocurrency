package com.example.cryptocurrency.presentation.coins.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cryptocurrency.domain.coins.models.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onClickAction: (Coin) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickAction(coin) }
            .padding(20.dp)
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Clip
        )
        Text(
            text = if (coin.isActive) "Active" else "InActive",
            color = if (coin.isActive) Color.Green else Color.Red,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.End,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .align(CenterVertically)
        )
    }
}