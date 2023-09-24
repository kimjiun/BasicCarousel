package com.jiun.basiccarousel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jiun.basiccarousel.ui.theme.BasicCarouselTheme

class PageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val key = intent.getIntExtra("KEY", 0)

        setContent {
            BasicCarouselTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowPagers(key)
                }
            }
        }
    }
}

@Composable
fun ShowPagers(key: Int){
    when(key){
        0 -> MyHorizontalPager()
        1 -> BasicCarousel()
        2 -> PaddingCarousel()
        3 -> RightCarousel()
        4 -> OneItemCarousel()
        5 -> TwoItemCarousel()
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyHorizontalPager() {
    val arr = arrayOf(R.drawable.lemon_tree, R.drawable.lemon_squeeze, R.drawable.lemon_drink, R.drawable.lemon_restart)
    val cArr = arrayOf(Color.Red, Color.Green, Color.Blue, Color.Yellow)

    Box{
        HorizontalPager(pageCount = arr.size,
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = 16.dp
        ) { page ->
            val index = arr[page % arr.size]
            val color = cArr[page % cArr.size]
            Box(modifier = Modifier
                .background(color = color)
                .fillMaxSize()){
                Image(painter = painterResource(id = index), contentDescription = "${index}")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasicCarousel() {
    val arr = arrayOf(R.drawable.lemon_tree, R.drawable.lemon_squeeze, R.drawable.lemon_drink, R.drawable.lemon_restart)
    val cArr = arrayOf(Color.Red, Color.Green, Color.Blue, Color.Yellow)

    val actualPageCount = arr.size
    val pageCount = Int.MAX_VALUE
    val maxNumOfRounds = Int.MAX_VALUE / actualPageCount
    val pagerState = rememberPagerState(
        initialPage = (maxNumOfRounds / 2) * actualPageCount
    )

    Box{
        HorizontalPager(pageCount = pageCount,
            state = pagerState
        ) { page ->
            val index = page % actualPageCount

            val item = arr[index]
            val color = cArr[index]
            Box(modifier = Modifier
                .background(color = color)
                .fillMaxSize()){
                Image(painter = painterResource(id = item), contentDescription = "${item}")
            }

            Text(modifier = Modifier
                .align(Alignment.TopEnd)
                .background(color = Color.DarkGray)
                .padding(20.dp),
                text = "${index + 1} / ${actualPageCount}",
                color = Color.White,
                fontSize = 20.sp)
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PaddingCarousel() {
    val arr = arrayOf(R.drawable.lemon_tree, R.drawable.lemon_squeeze, R.drawable.lemon_drink, R.drawable.lemon_restart)
    val cArr = arrayOf(Color.Red, Color.Green, Color.Blue, Color.Yellow)

    val actualPageCount = arr.size
    val pageCount = Int.MAX_VALUE
    val maxNumOfRounds = Int.MAX_VALUE / actualPageCount
    val pagerState = rememberPagerState(
        initialPage = (maxNumOfRounds / 2) * actualPageCount
    )

    Box{
        HorizontalPager(pageCount = pageCount,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = 16.dp
        ) { page ->
            val index = page % actualPageCount

            val item = arr[index]
            val color = cArr[index]
            Box(modifier = Modifier
                .background(color = color)
                .fillMaxSize()){
                Image(painter = painterResource(id = item), contentDescription = "${item}")
            }

            Text(modifier = Modifier
                .align(Alignment.TopEnd)
                .background(color = Color.DarkGray)
                .padding(20.dp),
                text = "${index + 1} / ${actualPageCount}",
                color = Color.White,
                fontSize = 20.sp)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OneItemCarousel() {
    val arr = arrayOf(R.drawable.lemon_tree)
    val cArr = arrayOf(Color.Red)

    val actualPageCount = arr.size
    val pageCount = Int.MAX_VALUE
    val maxNumOfRounds = Int.MAX_VALUE / actualPageCount
    val pagerState = rememberPagerState(
        initialPage = (maxNumOfRounds / 2) * actualPageCount
    )

    Box{
        HorizontalPager(pageCount = pageCount,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = 16.dp
        ) { page ->
            val index = page % actualPageCount

            val item = arr[index]
            val color = cArr[index]
            Box(modifier = Modifier
                .background(color = color)
                .fillMaxSize()){
                Image(painter = painterResource(id = item), contentDescription = "${item}")
            }

            Text(modifier = Modifier
                .align(Alignment.TopEnd)
                .background(color = Color.DarkGray)
                .padding(20.dp),
                text = "${index + 1} / ${actualPageCount}",
                color = Color.White,
                fontSize = 20.sp)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TwoItemCarousel() {
    val arr = arrayOf(R.drawable.lemon_tree, R.drawable.lemon_squeeze)
    val cArr = arrayOf(Color.Red, Color.Green)

    val actualPageCount = arr.size
    val pageCount = Int.MAX_VALUE
    val maxNumOfRounds = Int.MAX_VALUE / actualPageCount
    val pagerState = rememberPagerState(
        initialPage = (maxNumOfRounds / 2) * actualPageCount
    )

    Box{
        HorizontalPager(pageCount = pageCount,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = 16.dp
        ) { page ->
            val index = page % actualPageCount

            val item = arr[index]
            val color = cArr[index]
            Box(modifier = Modifier
                .background(color = color)
                .fillMaxSize()){
                Image(painter = painterResource(id = item), contentDescription = "${item}")
            }

            Text(modifier = Modifier
                .align(Alignment.TopEnd)
                .background(color = Color.DarkGray)
                .padding(20.dp),
                text = "${index + 1} / ${actualPageCount}",
                color = Color.White,
                fontSize = 20.sp)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RightCarousel() {
    val arr = arrayOf(R.drawable.lemon_tree, R.drawable.lemon_squeeze, R.drawable.lemon_drink, R.drawable.lemon_restart)
    val cArr = arrayOf(Color.Red, Color.Green, Color.Blue, Color.Yellow)

    Box{
        HorizontalPager(pageCount = Int.MAX_VALUE,
            contentPadding = PaddingValues(horizontal = 32.dp),
            pageSpacing = 16.dp
        ) { page ->
            val index = arr[page % arr.size]
            val color = cArr[page % cArr.size]
            Box(modifier = Modifier
                .background(color = color)
                .fillMaxSize()){
                Image(painter = painterResource(id = index), contentDescription = "${index}")
            }
        }
    }
}