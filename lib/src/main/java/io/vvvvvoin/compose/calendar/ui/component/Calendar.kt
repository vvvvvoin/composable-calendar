package io.vvvvvoin.compose.calendar.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.vvvvvoin.compose.calendar.ui.theme.*
import java.time.LocalDate

// default
@Composable
fun Calendar(
        initYear: Int,
        initMonth: Int,
        initDay: Int,
        onClickConfirm: (String?) -> Unit,
        onClickClear: () -> Unit,
) {
    CalendarFrame(
            initDate = LocalDate.of(initYear, initMonth, initDay),
            chosenDate = null,
            onClickConfirm = onClickConfirm,
            onClickClear = onClickClear,
    )
}

// theme
@Composable
fun Calendar(
        initYear: Int,
        initMonth: Int,
        initDay: Int,
        calendarTheme: CalendarTheme,
        onClickConfirm: (String?) -> Unit,
        onClickClear: () -> Unit,
) {
    CalendarFrame(
            initDate = LocalDate.of(initYear, initMonth, initDay),
            chosenDate = null,
            daySelectedBackgroundColor = calendarTheme.primaryColor,
            buttonBackgroundColor = calendarTheme.primaryColor,
            onClickConfirm = onClickConfirm,
            onClickClear = onClickClear,
    )
}

// custom color
@Composable
fun Calendar(
        initYear: Int,
        initMonth: Int,
        initDay: Int,
        headerTextColor: Color = text_darkest,
        headerIconColor: Color = icon_darkest,
        headerBackgroundColor: Color = bg_white,
        dayOfWeekColor: Color = text_darker,
        dayPrimaryColor: Color = text_darkest,
        daySecondaryColor: Color = text_dark,
        daySelectedColor: Color = bg_white,
        dayBackgroundColor: Color = bg_transparent,
        daySelectedBackgroundColor: Color = bgt_blue_normal,
        buttonTextColor: Color = bg_white,
        buttonBackgroundColor: Color = bgt_blue_normal,
        onClickConfirm: (String?) -> Unit,
        onClickClear: () -> Unit,
) {
    CalendarFrame(
            initDate = LocalDate.of(initYear, initMonth, initDay),
            chosenDate = null,
            headerTextColor = headerTextColor,
            headerIconColor = headerIconColor,
            headerBackgroundColor = headerBackgroundColor,
            dayOfWeekColor = dayOfWeekColor,
            dayPrimaryColor = dayPrimaryColor,
            daySecondaryColor = daySecondaryColor,
            daySelectedColor = daySelectedColor,
            dayBackgroundColor = dayBackgroundColor,
            daySelectedBackgroundColor = daySelectedBackgroundColor,
            buttonTextColor = buttonTextColor,
            buttonBackgroundColor = buttonBackgroundColor,
            onClickConfirm = onClickConfirm,
            onClickClear = onClickClear,
    )
}

// custom color (wrapper)
@Composable
fun Calendar(
        initYear: Int,
        initMonth: Int,
        initDay: Int,
        calendarCustomColor: CalendarCustomColor,
        onClickConfirm: (String?) -> Unit,
        onClickClear: () -> Unit,
) {
    CalendarFrame(
            initDate = LocalDate.of(initYear, initMonth, initDay),
            chosenDate = null,
            headerTextColor = calendarCustomColor.headerTextColor,
            headerIconColor = calendarCustomColor.headerIconColor,
            headerBackgroundColor = calendarCustomColor.headerBackgroundColor,
            dayOfWeekColor = calendarCustomColor.dayOfWeekColor,
            dayPrimaryColor = calendarCustomColor.dayPrimaryColor,
            daySecondaryColor = calendarCustomColor.daySecondaryColor,
            daySelectedColor = calendarCustomColor.daySelectedColor,
            dayBackgroundColor = calendarCustomColor.dayBackgroundColor,
            daySelectedBackgroundColor = calendarCustomColor.daySelectedBackgroundColor,
            buttonTextColor = calendarCustomColor.buttonTextColor,
            buttonBackgroundColor = calendarCustomColor.buttonBackgroundColor,
            onClickConfirm = onClickConfirm,
            onClickClear = onClickClear,
    )
}

// chosen
@Composable
fun Calendar(
        initYear: Int,
        initMonth: Int,
        initDay: Int,
        chosenYear: Int,
        chosenMonth: Int,
        chosenDay: Int,
        onClickConfirm: (String?) -> Unit,
        onClickClear: () -> Unit,
) {
    CalendarFrame(
            initDate = LocalDate.of(initYear, initMonth, initDay),
            chosenDate = LocalDate.of(chosenYear, chosenMonth, chosenDay),
            onClickConfirm = onClickConfirm,
            onClickClear = onClickClear,
    )
}

// chosen, theme
@Composable
fun Calendar(
        initYear: Int,
        initMonth: Int,
        initDay: Int,
        chosenYear: Int,
        chosenMonth: Int,
        chosenDay: Int,
        calendarTheme: CalendarTheme,
        onClickConfirm: (String?) -> Unit,
        onClickClear: () -> Unit,
) {
    CalendarFrame(
            initDate = LocalDate.of(initYear, initMonth, initDay),
            chosenDate = LocalDate.of(chosenYear, chosenMonth, chosenDay),
            daySelectedBackgroundColor = calendarTheme.primaryColor,
            buttonBackgroundColor = calendarTheme.primaryColor,
            onClickConfirm = onClickConfirm,
            onClickClear = onClickClear,
    )
}

// chosen, custom color
@Composable
fun Calendar(
        initYear: Int,
        initMonth: Int,
        initDay: Int,
        chosenYear: Int,
        chosenMonth: Int,
        chosenDay: Int,
        headerTextColor: Color = text_darkest,
        headerIconColor: Color = icon_darkest,
        headerBackgroundColor: Color = bg_white,
        dayOfWeekColor: Color = text_darker,
        dayPrimaryColor: Color = text_darkest,
        daySecondaryColor: Color = text_dark,
        daySelectedColor: Color = bg_white,
        dayBackgroundColor: Color = bg_transparent,
        daySelectedBackgroundColor: Color = bgt_blue_normal,
        buttonTextColor: Color = bg_white,
        buttonBackgroundColor: Color = bgt_blue_normal,
        onClickConfirm: (String?) -> Unit,
        onClickClear: () -> Unit,
) {
    CalendarFrame(
            initDate = LocalDate.of(initYear, initMonth, initDay),
            chosenDate = LocalDate.of(chosenYear, chosenMonth, chosenDay),
            headerTextColor = headerTextColor,
            headerIconColor = headerIconColor,
            headerBackgroundColor = headerBackgroundColor,
            dayOfWeekColor = dayOfWeekColor,
            dayPrimaryColor = dayPrimaryColor,
            daySecondaryColor = daySecondaryColor,
            daySelectedColor = daySelectedColor,
            dayBackgroundColor = dayBackgroundColor,
            daySelectedBackgroundColor = daySelectedBackgroundColor,
            buttonTextColor = buttonTextColor,
            buttonBackgroundColor = buttonBackgroundColor,
            onClickConfirm = onClickConfirm,
            onClickClear = onClickClear,
    )
}

// chosen, custom color (wrapper)
@Composable
fun Calendar(
        initYear: Int,
        initMonth: Int,
        initDay: Int,
        chosenYear: Int,
        chosenMonth: Int,
        chosenDay: Int,
        calendarCustomColor: CalendarCustomColor,
        onClickConfirm: (String?) -> Unit,
        onClickClear: () -> Unit,
) {
    CalendarFrame(
            initDate = LocalDate.of(initYear, initMonth, initDay),
            chosenDate = LocalDate.of(chosenYear, chosenMonth, chosenDay),
            headerTextColor = calendarCustomColor.headerTextColor,
            headerIconColor = calendarCustomColor.headerIconColor,
            headerBackgroundColor = calendarCustomColor.headerBackgroundColor,
            dayOfWeekColor = calendarCustomColor.dayOfWeekColor,
            dayPrimaryColor = calendarCustomColor.dayPrimaryColor,
            daySecondaryColor = calendarCustomColor.daySecondaryColor,
            daySelectedColor = calendarCustomColor.daySelectedColor,
            dayBackgroundColor = calendarCustomColor.dayBackgroundColor,
            daySelectedBackgroundColor = calendarCustomColor.daySelectedBackgroundColor,
            buttonTextColor = calendarCustomColor.buttonTextColor,
            buttonBackgroundColor = calendarCustomColor.buttonBackgroundColor,
            onClickConfirm = onClickConfirm,
            onClickClear = onClickClear,
    )
}


data class CalendarCustomColor(
        val headerTextColor: Color = text_darkest,
        val headerIconColor: Color = icon_darkest,
        val headerBackgroundColor: Color = bg_white,
        val dayOfWeekColor: Color = text_darker,
        val dayPrimaryColor: Color = text_darkest,
        val daySecondaryColor: Color = text_dark,
        val daySelectedColor: Color = bg_white,
        val dayBackgroundColor: Color = bg_transparent,
        val daySelectedBackgroundColor: Color = bgt_blue_normal,
        val buttonTextColor: Color = bg_white,
        val buttonBackgroundColor: Color = bgt_blue_normal,
)

enum class CalendarTheme(
        val primaryColor: Color,
) {
    RED(bgt_red_normal),
    ORANGE(bgt_orange_normal),
    YELLOW(bgt_yellow_normal),
    GREEN(bgt_green_normal),
    AQUA(bgt_aqua_normal),
    SKY(bgt_sky_normal),
    BLUE(bgt_blue_normal),
    PURPLE(bgt_purple_normal),
    PINK(bgt_pink_normal),
}
