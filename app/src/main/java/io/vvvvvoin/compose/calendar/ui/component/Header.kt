package io.vvvvvoin.compose.calendar.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.vvvvvoin.compose.calendar.R
import io.vvvvvoin.compose.calendar.ui.theme.*
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

@Composable
internal fun Header(
        year: Int,
        month: Int,
        textColor: Color = text_darkest,
        iconColor: Color = icon_darkest,
        backgroundColor: Color = bg_white,
        onClickLeftButton: () -> Unit,
        onClickRightButton: () -> Unit,
) {
    val date = LocalDate.of(year, month, 1)
    val formatter = DateTimeFormatter.ofPattern("LLLL")

    Card(
            shape = RoundedCornerShape(12.dp),
            elevation = 0.dp,
            backgroundColor = backgroundColor,
    ) {
        Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
        ) {

            IconButton(
                    drawableRes = R.drawable.ic_icon_left_arrow,
                    iconColor = iconColor,
                    onClickIconButton = onClickLeftButton,
            )

            Text(
                    modifier = Modifier
                            .weight(weight = 1f, ),
                    text = "${date.format(formatter)} ${year}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = textColor,
                    textAlign = TextAlign.Center,
            )

            IconButton(
                    drawableRes = R.drawable.ic_icon_right_arrow,
                    iconColor = iconColor,
                    onClickIconButton = onClickRightButton,
            )
        }
    }


}

@Preview
@Composable
fun PreviewHeader() {
    Header(
            year = 2022,
            month = 3,
            textColor = text_darkest,
            iconColor = text_dark,
            backgroundColor = bgt_mint_normal,
            onClickLeftButton = {},
            onClickRightButton = {},
    )
}
