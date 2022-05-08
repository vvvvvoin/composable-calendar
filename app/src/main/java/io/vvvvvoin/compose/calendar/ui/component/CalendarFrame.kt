package io.vvvvvoin.compose.calendar.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import io.vvvvvoin.compose.calendar.R
import io.vvvvvoin.compose.calendar.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoField

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun CalendarFrame(
        initYear: Int,
        initMonth: Int,
        initDay: Int,
        chosenDate: LocalDate? = null,
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
        coroutineScope: CoroutineScope = rememberCoroutineScope(),
        onClickConfirm: (String?) -> Unit,
        onClickClear: () -> Unit,
) {
    val initLocalDate = LocalDate.of(initYear, initMonth, initDay)
    var selectedDate: LocalDate? by remember { mutableStateOf(null) }

    if (chosenDate != null) {
        selectedDate = chosenDate
    }

    val pagerState = rememberPagerState(
            pageCount = LIMITED_MONTH,
            initialPage = LIMITED_MONTH_HALF,
            infiniteLoop = false,
    )

    val nowLocalDate = if (LIMITED_MONTH_HALF >= pagerState.currentPage) {
        initLocalDate.minusMonths((LIMITED_MONTH_HALF - pagerState.currentPage).toLong())
    } else {
        initLocalDate.plusMonths((pagerState.currentPage - LIMITED_MONTH_HALF).toLong())
    }

    Card(
            modifier = Modifier.wrapContentWidth(),
            backgroundColor = bg_white,
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(
                    width = 1.dp,
                    color = border_dark,
            ),
    ) {
        Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            /*header*/
            Header(
                    year = nowLocalDate.year,
                    month = nowLocalDate.monthValue,
                    textColor = headerTextColor,
                    iconColor = headerIconColor,
                    backgroundColor = headerBackgroundColor,
                    onClickLeftButton = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    },
                    onClickRightButton = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
            )
            DividerHeightDp(height = 8.0)


            /*day of week*/
            Row {
                DayOfWeek.values().forEach {
                    DayOfWeek(
                            dayOfWeek = it,
                            textColor = dayOfWeekColor,
                    )
                    if (it != DayOfWeek.SATURDAY) {
                        DividerDp(size = 12.5)
                    }
                }
            }

            /*day*/
            PagerCalendar(
                    initLocalDate = initLocalDate,
                    chosenDate = selectedDate,
                    primaryColor = dayPrimaryColor,
                    secondaryColor = daySecondaryColor,
                    backgroundColor = dayBackgroundColor,
                    selectedColor = daySelectedColor,
                    selectedBackgroundColor = daySelectedBackgroundColor,
                    pagerState = pagerState,
                    onSelectedDay = {
                        selectedDate = it
                    },
            )


            /*buttons*/
            DividerHeightDp(height = 12.0)
            BezierButton(
                    text = stringResource(id = R.string.common_confirm),
                    buttonTextColor = buttonTextColor,
                    buttonBackgroundColor = buttonBackgroundColor,
                    onClickButton = {
                        onClickConfirm.invoke(
                                selectedDate?.format(DateTimeFormatter.ISO_DATE),
                        )
                    },
            )
            DividerHeightDp(height = 8.0)
            BezierButton(
                    text = stringResource(id = R.string.common_clear),
                    buttonTextColor = buttonTextColor,
                    buttonBackgroundColor = buttonBackgroundColor,
                    onClickButton = { onClickClear.invoke() },
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun PagerCalendar(
        initLocalDate: LocalDate,
        chosenDate: LocalDate?,
        pagerState: PagerState,
        primaryColor: Color,
        secondaryColor: Color,
        backgroundColor: Color,
        selectedColor: Color,
        selectedBackgroundColor: Color,
        onSelectedDay: (LocalDate) -> Unit,
) {
    HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.Top,
    ) { page ->
        Column(
                horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var localDate = initLocalDate

            localDate = if (LIMITED_MONTH_HALF >= page) {
                localDate.minusMonths((LIMITED_MONTH_HALF - page).toLong())
            } else {
                localDate.plusMonths((page - LIMITED_MONTH_HALF).toLong())
            }

            OneMonth(
                    initDate = localDate,
                    chosenDate = chosenDate,
                    primaryColor = primaryColor,
                    secondaryColor = secondaryColor,
                    backgroundColor = backgroundColor,
                    selectedColor = selectedColor,
                    selectedBackgroundColor = selectedBackgroundColor,
                    onSelectedDay = onSelectedDay,
            )
        }
    }
}

@Composable
private fun OneMonth(
        initDate: LocalDate,
        chosenDate: LocalDate? = null,
        primaryColor: Color,
        secondaryColor: Color,
        backgroundColor: Color,
        selectedColor: Color,
        selectedBackgroundColor: Color,
        onSelectedDay: (LocalDate) -> Unit,
) {

    val date = initDate.withDayOfMonth(1)

    // day of week : sunday = 7, monday = 1
    val startDayOfMonthIndex = if (date.get(ChronoField.DAY_OF_WEEK) == 7) {
        0
    } else {
        date.get(ChronoField.DAY_OF_WEEK)
    }

    var startDate = date.minusDays(startDayOfMonthIndex.toLong())

    var flag = true
    while (flag) {
        DividerHeightDp(height = 2.0)

        Row {
            repeat(REPEAT_DAY_OF_WEEK) { index ->
                val isSelected = chosenDate?.isEqual(startDate) == true

                DayButton(
                        selected = isSelected,
                        localDate = startDate,
                        defaultTextColor =
                        when {
                            isSelected -> selectedColor
                            startDate.get(ChronoField.MONTH_OF_YEAR) == initDate.monthValue -> primaryColor
                            else -> secondaryColor
                        },
                        defaultBackgroundColor = backgroundColor,
                        selectedBackgroundColor = selectedBackgroundColor,
                        onClickButton = onSelectedDay,
                )

                if (index != LAST_DAY_OF_WEEK_INDEX) {
                    DividerDp(size = 12.5)
                }
                startDate = startDate.plusDays(1)
            }
        }

        if (startDate.monthValue != initDate.monthValue) {
            flag = false
        }
    }
}

@Preview
@Composable
fun PreviewCalendarFrame() {
    CalendarFrame(
            initYear = 2022,
            initMonth = 1,
            initDay = 31,
            onClickConfirm = {},
            onClickClear = {},
            headerBackgroundColor = bgt_blue_darker,
    )
}
