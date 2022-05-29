package io.vvvvvoin.compose.calendar.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.vvvvvoin.compose.calendar.ui.theme.bg_transparent

@Composable
internal fun DividerDp(
        size: Dp,
) {
    Divider(
            modifier = Modifier
                    .size(size),
            color = bg_transparent,
    )
}

@Composable
internal fun DividerHeightDp(
        height: Dp,
) {
    Divider(
            modifier = Modifier
                    .fillMaxWidth()
                    .height(height),
            color = bg_transparent,
    )
}

@Composable
internal fun DividerWidthDp(
        width: Dp,
) {
    Divider(
            modifier = Modifier
                    .fillMaxHeight()
                    .width(width),
            color = bg_transparent,
    )
}
