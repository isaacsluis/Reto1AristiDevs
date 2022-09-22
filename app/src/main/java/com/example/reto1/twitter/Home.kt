package com.example.reto1.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.reto1.R
import com.example.reto1.twitter.TwitterViewModel

@Composable
fun Home(twitterViewModel: TwitterViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF171C26))

    ) {
        Box(
            Modifier
                .fillMaxHeight(0.53f)
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Row() {
                ImagenProfile()
                Column(
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    UserName()
                    PrincipalText("Descripcion Id w arga sbre dwd")
                    PrincipalText("texto Descripción larga sobre texto")
                    PrincipalText("Descripción larga sobre texto")
                    PrincipalText("Descripción larga sobre texto")
                    PrincipalText("Descripcion larga dw dadsobre texto")
                    ImagenCenter()
                    Social(twitterViewModel)
                }
            }
        }
        Divider(
            Modifier.fillMaxWidth(),
            color = Color(0xFF2f353f),
            thickness = 4.dp,
        )
    }
}

@Composable
fun UserName() {
    Row(

    ) {
        Text(
            text = "Aris  ",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "@AristiDevs 4h",
            color = Color.Gray
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dots),
                contentDescription = "Dots",
                tint = Color.White
            )
        }
    }
}

@Composable
fun Social(twitterViewModel: TwitterViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        ChatResource(twitterViewModel)
        RTResourse(twitterViewModel)
        LikeResource(twitterViewModel)
    }
}

@Composable
fun LikeResource(twitterViewModel: TwitterViewModel) {

    val likeNum by twitterViewModel.likeNum.observeAsState(2)
    val like by twitterViewModel.like.observeAsState(true)


    if (like) {
        IconButton(onClick = {twitterViewModel.onClicLike(like,1,likeNum) }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = "like",
                tint = Color.White,
                modifier =
                Modifier.padding(start = 70.dp)
            )
        }
    } else {
        IconButton(onClick = {twitterViewModel.onClicLike(like,1,likeNum) }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_like_filled),
                contentDescription = "like",
                tint = Color.Red,
                modifier =
                Modifier.padding(start = 70.dp)
            )
        }
    }

    Text(text = likeNum.toString(),
        color = Color.Gray)
}

@Composable
fun RTResourse(twitterViewModel: TwitterViewModel) {

    val rtNum by twitterViewModel.rtNum.observeAsState(2)
    val rt by twitterViewModel.rt.observeAsState(true)

    if (rt) {
        IconButton(onClick = {twitterViewModel.onClicLike(rt,2,rtNum) }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "RT",
                tint = Color.White,
                modifier =
                Modifier.padding(start = 70.dp)
            )
        }

    } else {
        IconButton(onClick = {twitterViewModel.onClicLike(rt,2,rtNum) }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = "RT",
                tint = Color.Green,
                modifier =
                Modifier.padding(start = 70.dp)
            )
        }
    }

    Text(
        text = rtNum.toString(),
        color = Color.Gray,
//    textAlign =
    )
}

@Composable
fun ChatResource(twitterViewModel: TwitterViewModel) {

    val chatNum by twitterViewModel.chatNum.observeAsState(2)
    val chat by twitterViewModel.chat.observeAsState(true)

    if (chat) {
        IconButton(onClick = { twitterViewModel.onClicLike(chat,3,chatNum)}) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chat),
                contentDescription = null,
                tint = Color.White
            )
        }
    } else {
        IconButton(onClick = { twitterViewModel.onClicLike(chat,3,chatNum) }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chat_filled),
                contentDescription = null,
                tint = Color.White
            )
        }

}
    Text(text = chatNum.toString(),
        color = Color.Gray)
}

@Composable
fun PrincipalText(tex: String) {
    Text(
        text = tex,
        color = Color.White,
        fontSize = 14.sp
    )
}

@Composable
fun ImagenProfile() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Imagen",
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)

    )
}

@Composable
fun ImagenCenter() {
    Image(
        painter = rememberAsyncImagePainter(
            model = R.drawable.profile,
        ),
        contentDescription = "Imagen",
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clip(RoundedCornerShape(50f))
            .background(Color.Red),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop

    )
}
