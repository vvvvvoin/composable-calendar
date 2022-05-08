package io.vvvvvoin.compose.calendar.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.vvvvvoin.compose.calendar.ui.theme.*

@Composable
internal fun BezierButton(
        text: String,
        leftIcon: Int = 0,
        rightIcon: Int = 0,
        size: ButtonSize = ButtonSize.S,
        buttonTextColor: Color,
        buttonBackgroundColor: Color,
        onClickButton: () -> Unit,
) {
    Card(
            modifier = Modifier
                    .clickable { onClickButton.invoke() },
            shape = RoundedCornerShape(size.cornerSize.dp),
            elevation = 0.dp,
            backgroundColor = buttonBackgroundColor,
    ) {
        Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .height(size.heightSize.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
        ) {
            if (leftIcon != 0) {
                Icon(
                        modifier = Modifier.size(size.iconSize.dp),
                        painter = painterResource(id = leftIcon),
                        contentDescription = null
                )
            }

            Text(
                    modifier = Modifier
                            .padding(horizontal = 6.dp)
                            .background(bg_transparent),
                    text = text,
                    color = buttonTextColor,
                    fontSize = size.fontSize.sp,
            )

            if (rightIcon != 0) {
                Icon(
                        modifier = Modifier.size(size.iconSize.dp),
                        painter = painterResource(id = rightIcon),
                        contentDescription = null
                )
            }
        }
    }
}

enum class ButtonSize(
        val id: Int,
        val heightSize: Int,
        val cornerSize: Double,
        val fontSize: Int,
        val iconSize: Int,
) {
    XS(0, 24, 10.8, 12, 16),
    S(1, 30, 12.6, 13, 20),
    M(2, 36, 15.12, 14, 24),
    L(3, 40, 16.8, 15, 28),
    XL(4, 44, 18.48, 15, 34),
}

@Preview
@Composable
fun PreviewBezierButton() {
    BezierButton(
            size = ButtonSize.M,
            text = "Bezier Button",
            buttonTextColor = text_darkest,
            buttonBackgroundColor = bg_white,
            onClickButton = {},
    )
}