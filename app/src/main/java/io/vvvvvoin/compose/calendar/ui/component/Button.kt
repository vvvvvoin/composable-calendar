package io.vvvvvoin.compose.calendar.ui.component

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
import io.vvvvvoin.compose.calendar.R
import io.vvvvvoin.compose.calendar.ui.component.layout.Layout
import io.vvvvvoin.compose.calendar.ui.theme.*

@Composable
internal fun Button(
        layout: Layout = Layout.WRAP,
        size: ButtonSize = ButtonSize.S,
        text: String = "",
        leftIcon: Int = 0,
        rightIcon: Int = 0,
        iconTint: Color = icon_darkest,
        buttonTextColor: Color = text_darkest,
        buttonBackgroundColor: Color = bg_white,
        onClickButton: () -> Unit = {},
) {
    Card(
            modifier = Modifier
                    .clickable { onClickButton.invoke() },
            shape = RoundedCornerShape(size.cornerSize.dp),
            elevation = 0.dp,
            backgroundColor = buttonBackgroundColor,
    ) {
        Row(
                modifier = if (layout == Layout.WRAP) {
                    Modifier.wrapContentWidth()
                } else {
                    Modifier.fillMaxWidth()
                }.height(size.height.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
        ) {
            ButtonContents(
                    size = size,
                    text = text,
                    leftIcon = leftIcon,
                    rightIcon = rightIcon,
                    iconTint = iconTint,
                    buttonTextColor = buttonTextColor,
            )
        }
    }
}

@Composable
internal fun ButtonContents(
        size: ButtonSize,
        text: String,
        leftIcon: Int,
        rightIcon: Int,
        iconTint: Color,
        buttonTextColor: Color,
) {
    DividerDp(size = size.horizontalPadding.dp)

    if (leftIcon != 0) {
        Icon(
                modifier = Modifier
                        .padding(
                                end = if (text.isNotEmpty()) {
                                    size.contentPadding.dp
                                } else {
                                    0.dp
                                }
                        )
                        .size(size.iconSize.dp),
                painter = painterResource(id = leftIcon),
                contentDescription = null,
                tint = iconTint,
        )
    }

    if (text.isNotEmpty()) {
        Text(
                text = text,
                color = buttonTextColor,
                fontSize = size.fontSize.sp,
        )
    }

    if (rightIcon != 0) {
        Icon(
                modifier = Modifier
                        .padding(
                                start = if (text.isNotEmpty()) {
                                    size.contentPadding.dp
                                } else {
                                    0.dp
                                }
                        )
                        .size(size.iconSize.dp),
                painter = painterResource(id = rightIcon),
                contentDescription = null,
                tint = iconTint,
        )
    }

    DividerDp(size = size.horizontalPadding.dp)
}

internal enum class ButtonSize(
        val height: Int,
        val cornerSize: Double,
        val fontSize: Int,
        val iconSize: Int,
        val horizontalPadding: Int,
        val contentPadding: Int,
) {
    XS(24, 10.8, 12, 16, 4, 4),
    S(30, 12.6, 13, 20, 4, 4),
    M(36, 15.12, 14, 24, 4, 4),
    L(40, 16.8, 15, 28, 6, 5),
    XL(44, 18.48, 15, 32, 6, 6),
}

@Preview
@Composable
fun PreviewButtonIcon() {
    Button(
            layout = Layout.WRAP,
            size = ButtonSize.XS,
            leftIcon = R.drawable.ic_icon_left_arrow,
            buttonTextColor = text_darkest,
            buttonBackgroundColor = bg_white,
            onClickButton = {},
    )
}

@Preview
@Composable
fun PreviewButtonXS() {
    Button(
            size = ButtonSize.XS,
            text = "Bezier Button XS",
            leftIcon = R.drawable.ic_icon_left_arrow,
            rightIcon = R.drawable.ic_icon_right_arrow,
            buttonTextColor = text_darkest,
            buttonBackgroundColor = bg_white,
            onClickButton = {},
    )
}

@Preview
@Composable
fun PreviewButtonS() {
    Button(
            size = ButtonSize.S,
            text = "Bezier Button S",
            leftIcon = R.drawable.ic_icon_left_arrow,
            rightIcon = R.drawable.ic_icon_right_arrow,
            buttonTextColor = text_darkest,
            buttonBackgroundColor = bg_white,
            onClickButton = {},
    )
}

@Preview
@Composable
fun PreviewButtonM() {
    Button(
            size = ButtonSize.M,
            text = "Bezier Button M",
            leftIcon = R.drawable.ic_icon_left_arrow,
            rightIcon = R.drawable.ic_icon_right_arrow,
            buttonTextColor = text_darkest,
            buttonBackgroundColor = bg_white,
            onClickButton = {},
    )
}

@Preview
@Composable
fun PreviewButtonL() {
    Button(
            size = ButtonSize.L,
            text = "Bezier Button L",
            leftIcon = R.drawable.ic_icon_left_arrow,
            rightIcon = R.drawable.ic_icon_right_arrow,
            buttonTextColor = text_darkest,
            buttonBackgroundColor = bg_white,
            onClickButton = {},
    )
}

@Preview
@Composable
fun PreviewButtonXL() {
    Button(
            size = ButtonSize.XL,
            text = "Bezier Button XL",
            leftIcon = R.drawable.ic_icon_left_arrow,
            rightIcon = R.drawable.ic_icon_right_arrow,
            buttonTextColor = text_darkest,
            buttonBackgroundColor = bg_white,
            onClickButton = {},
    )
}
