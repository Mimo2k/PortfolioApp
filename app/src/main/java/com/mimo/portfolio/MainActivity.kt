package com.mimo.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mimo.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioTheme {
                MainContent()
            }
        }
    }

}
@Composable
fun MainContent(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        MainScreen()
    }
}
@Composable
fun MainScreen(){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Color.White,
            elevation = 4.dp) {
            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                 Spacer(modifier = Modifier.height(5.dp))
                 RoundedImage()
                 Spacer(modifier = Modifier.height(10.dp))
                 Divider(modifier = Modifier.width(300.dp), thickness = 1.dp )
                 Spacer(modifier = Modifier.height(10.dp))
                 MidTextBox()
                 Spacer(modifier = Modifier.height(10.dp))
                 PreviewButton()

            }

        }
    }
}
@Composable
fun RoundedImage(modifier: Modifier = Modifier){
    Surface(modifier = modifier
        .size(165.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 6.dp,
        color = MaterialTheme.colors.onSurface.copy(0.5f)
    ) {
        Image(painter = painterResource(id =R.drawable.profile),
            contentDescription ="profile image",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )
    }
}
@Composable
fun MidTextBox(){
    Column(modifier = Modifier.padding(5.dp)) {
        Text(text = "Lady X.",
            style = MaterialTheme.typography.h3,
            color = Color.Black)
        Text(text = "Initiator",
            fontSize = 20.sp,
            style = MaterialTheme.typography.subtitle1,
            color = Color.Gray)
    }
}
@Composable
fun PreviewButton(){
    var buttonClicked by remember {
        mutableStateOf(false)
    }
    Button(
        onClick = {
        buttonClicked = !buttonClicked

    }) {
       Text(text = "Portfolio", style = MaterialTheme.typography.button)
    }
    if (buttonClicked){
        PreviewContent()
    }
}
@Composable
fun PreviewContent(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)) {
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(width = 2.dp,
                color = Color.LightGray)
        ) {
            Portfolio(data = listOf("project 1", "project 2", "project 3", "project 4"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
  LazyColumn{
      items(data){item: String ->
          Card(modifier = Modifier
              .padding(13.dp)
              .fillMaxWidth(),
               shape = RectangleShape) {
              Row(modifier = Modifier
                  .padding(8.dp)
                  .background(MaterialTheme.colors.surface)
                  .padding(16.dp)
              ) {
                  RoundedImage(modifier = Modifier.size(120.dp))
                  Column(modifier = Modifier.padding(8.dp).align(alignment = Alignment.CenterVertically)) {
                      Text(text = item, fontWeight = FontWeight.Bold)
                      Text(text = "A great Project", style = MaterialTheme.typography.body1)
                  }

              }

          }
      }
  }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PortfolioTheme {
        MainScreen()
    }
}
