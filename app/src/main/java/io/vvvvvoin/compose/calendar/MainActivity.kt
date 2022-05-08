package io.vvvvvoin.compose.calendar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.vvvvvoin.compose.calendar.ui.component.CalendarFrame
import io.vvvvvoin.compose.calendar.ui.theme.CanlendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanlendarTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    CalendarFrame(
                            initYear = 2022,
                            initMonth = 5,
                            initDay = 7,
                            onClickConfirm = {
                                Log.e("compose Test", "value = ${it}")
                            }
                    ) {

                    }
                }
            }
        }
    }
}
