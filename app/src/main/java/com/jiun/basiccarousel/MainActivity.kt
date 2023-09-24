package com.jiun.basiccarousel

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jiun.basiccarousel.ui.theme.BasicCarouselTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCarouselTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Button(onClick = { startPageActivity(0) }) {
                            Text(text = "기본 페이저")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = { startPageActivity(1) }) {
                            Text(text = "기본 무한 스크롤")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = { startPageActivity(2) }) {
                            Text(text = "패딩 무한 스크롤")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = { startPageActivity(3) }) {
                            Text(text = "기본 오른쪽으로만 무한 스크롤")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = { startPageActivity(4) }) {
                            Text(text = "아이템 하나")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = { startPageActivity(5) }) {
                            Text(text = "아이템 두개")
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                    }

                }
            }
        }
    }

    private fun startPageActivity(key: Int){
        startActivity(Intent(this, PageActivity::class.java).putExtra("KEY", key))
    }
}

