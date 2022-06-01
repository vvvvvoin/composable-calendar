package io.vvvvvoin.compose.calendar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import io.vvvvvoin.compose.calendar.ui.component.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scrollState = rememberScrollState()

            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Calendar(
                        initYear = 2022,
                        initMonth = 5,
                        initDay = 7,
                        onClickConfirm = {
                            Log.e("compose Test", "value = ${it}")
                        },
                        onClickClear = {},
                )
            }
        }
    }
}
