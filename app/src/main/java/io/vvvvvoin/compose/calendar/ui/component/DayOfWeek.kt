package io.vvvvvoin.compose.calendar.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.vvvvvoin.compose.calendar.R
import io.vvvvvoin.compose.calendar.ui.theme.bg_white
import io.vvvvvoin.compose.calendar.ui.theme.text_darker

@Composable
internal fun DayOfWeek(
        dayOfWeek: DayOfWeek,
        textColor: Color = text_darker,
) {

    Box(
            modifier = Modifier.size(36.dp),
            contentAlignment = Alignment.Center,
    ) {
        Text(
                text = stringResource(id = dayOfWeek.kay),
                fontSize = 16.sp,
                color = textColor,
        )
    }
}

enum class DayOfWeek(
        val kay: Int,
) {
    SUNDAY(R.string.day_of_week_sunday),
    MONDAY(R.string.day_of_week_monday),
    TUESDAY(R.string.day_of_week_tuesday),
    WEDNESDAY(R.string.day_of_week_wednesday),
    THURSDAY(R.string.day_of_week_thursday),
    FRIDAY(R.string.day_of_week_friday),
    SATURDAY(R.string.day_of_week_saturday)
}

@Preview
@Composable
fun PreviewDayOfWeekButton() {
    DayOfWeek(
            dayOfWeek = DayOfWeek.FRIDAY,
            textColor = bg_white,
    )
}
