package io.vvvvvoin.compose.calendar.ui.component

import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import org.threeten.bp.LocalDate

@Composable
fun Calendar(
        initYear: Int,
        initMonth: Int,
        initDay: Int,
        chosenDate: LocalDate? = null,
        coroutineScope: CoroutineScope,
        onClickConfirm: (String?) -> Unit,
        onClickClear: () -> Unit,
) {
    CalendarFrame(
            initYear = initYear,
            initMonth = initMonth,
            initDay = initDay,
            chosenDate = chosenDate,
            onClickConfirm = onClickConfirm,
            onClickClear = onClickClear,
    )
}
