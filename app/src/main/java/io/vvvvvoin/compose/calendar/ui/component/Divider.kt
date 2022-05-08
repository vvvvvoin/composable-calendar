package io.vvvvvoin.compose.calendar.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.vvvvvoin.compose.calendar.ui.theme.bg_transparent

@Composable
internal fun DividerDp(
        size: Double,
) {
    Divider(
            modifier = Modifier
                    .size(size.dp),
            color = bg_transparent,
    )
}

@Composable
internal fun DividerHeightDp(
        height: Double,
) {
    Divider(
            modifier = Modifier
                    .fillMaxWidth()
                    .height(height.dp),
            color = bg_transparent,
    )
}

@Composable
internal fun DividerWidthDp(
        width: Double,
) {
    Divider(
            modifier = Modifier
                    .fillMaxHeight()
                    .width(width.dp),
            color = bg_transparent,
    )
}
