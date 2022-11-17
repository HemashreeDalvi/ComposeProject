package com.hem.mycomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hem.mycomposedemo.ui.theme.MyComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                    //, color = MaterialTheme.colors.background
                ) {
                    Greeting("Nirvi")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.background) {
        //Text(text = "Hello $name!", modifier = Modifier.padding(5.dp))
        BirthdayWish("Happy Birthday Nirvi", "from Aai Baba")
    }
}

@Composable
fun BirthdayWish(msg: String, from: String) {
    Box {
        BirthdayWishImage()
        Column {
            //Text(text = "$msg", fontSize = 14.sp, fontStyle = FontStyle.Italic)
            TextShadow(txt = msg)
            Text(
                text = "$from",
                fontSize = 7.sp,
                textAlign = TextAlign.Right,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.width(150.dp)
            )
            //Text(stringResource(R.string.app_name), color = Color.Red)
        }
    }
}

@Composable
fun BirthdayWishImage(){
    val birthdayImage = painterResource(id = R.drawable.androidparty)
    Image(painter = birthdayImage, contentDescription = null
        , modifier = Modifier.fillMaxHeight().fillMaxWidth()
    , contentScale = ContentScale.Crop)

}

@Preview(showBackground = true)
@Composable
fun TextShadow(txt : String) {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = txt,
        style = TextStyle(
            fontSize = 14.sp,
            shadow = Shadow(
                color = Color.Blue,
                offset = offset,
                blurRadius = 3f
            )
        )
    )
}

@Preview//(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeDemoTheme {
//        BirthdayWish("Happy Birthday Nirvi", "from Aai Baba")
        Greeting("test")
    }
}