package io.vvvvvoin.compose.calendar.ui.component

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.vvvvvoin.compose.calendar.ui.theme.*
import java.time.LocalDate

@Composable
internal fun DayButton(
        selected: Boolean,
        localDate: LocalDate,
        onClickButton: (LocalDate) -> Unit,
        defaultTextColor: Color,
        defaultBackgroundColor: Color,
        selectedBackgroundColor: Color,
) {

    Box(
            modifier = Modifier
                    .size(36.dp)
                    .clip(
                            shape = RoundedCornerShape(
                                    size = 18.dp,
                            ),
                    )
                    .background(
                            color = when {
                                selected -> selectedBackgroundColor
                                else -> defaultBackgroundColor
                            }
                    )
                    .clickable(
                            onClick = {
                                onClickButton.invoke(localDate)
                            },
                            interactionSource = MutableInteractionSource(),
                            indication = rememberRipple(),
                    ),
    ) {
        Text(
                modifier = Modifier.align(Alignment.Center),
                text = localDate.dayOfMonth.toString(),
                fontSize = 16.sp,
                color = defaultTextColor,
                maxLines = 1,
        )

        /*today mark*/
        if (localDate.isEqual(LocalDate.now())) {
            Canvas(
                    modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 2.dp)
                            .size(4.dp)
            ) {
                drawCircle(
                        color = selectedBackgroundColor,
                )
            }
        }
    }
}

@Preview
@Composable
internal fun PreviewButton1() {
    DayButton(
            selected = false,
            localDate = LocalDate.of(1995, 2, 8),
            defaultTextColor = text_darkest,
            defaultBackgroundColor = bg_transparent,
            selectedBackgroundColor = bgt_aqua_normal,
            onClickButton = {},
    )
}

@Preview
@Composable
internal fun PreviewButton2() {
    DayButton(
            selected = true,
            localDate = LocalDate.of(1995, 2, 8),
            defaultTextColor = text_darkest,
            defaultBackgroundColor = bg_transparent,
            selectedBackgroundColor = bgt_aqua_normal,
            onClickButton = {},
    )
}
