package io.vvvvvoin.compose.calendar.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.vvvvvoin.compose.calendar.R
import io.vvvvvoin.compose.calendar.ui.theme.icon_darkest

@Composable
internal fun IconButton(
        drawableRes: Int,
        iconColor: Color = icon_darkest,
        onClickIconButton: () -> Unit,
) {
    Box(
            modifier = Modifier
                    .size(36.dp)
                    .clip(
                            shape = RoundedCornerShape(
                                    size = 18.dp,
                            ),
                    )
                    .clickable(
                            onClick = { onClickIconButton.invoke() },
                            interactionSource = MutableInteractionSource(),
                            indication = rememberRipple(),
                    ),
            contentAlignment = Alignment.Center,
    ) {
        Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(drawableRes),
                tint = iconColor,
                contentDescription = null,
        )
    }
}

@Preview
@Composable
internal fun PreviewIconButton() {
    IconButton(
            drawableRes = R.drawable.ic_icon_left_arrow,
            onClickIconButton = {},
    )
}
