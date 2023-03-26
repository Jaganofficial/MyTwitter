package com.lineup.mytwitter.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lineup.mytwitter.R
import kotlin.random.Random

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileSection() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Black,
                            Color.Black
                        )
                    )
                )
        ) {
            BannerImage()
            UserProfile()
        }
    }
}

@Composable
fun BannerImage() {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            modifier = Modifier.height(160.dp),
            contentScale = ContentScale.Crop
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 10.dp, top = 15.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = "Back arrow",
                modifier = Modifier.size(21.dp),
                colorFilter = ColorFilter.tint(color = Color.LightGray)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = "Profile",
                style = TextStyle(
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserProfile() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 145.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp)
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)), color = colorResource(
                id = R.color.background
            )
        ) {
            Column(modifier = Modifier) {
                UserInfo()
            }
        }
        Image(
            painter = painterResource(id = R.drawable.channel_logo),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(145.dp)
                .align(Alignment.TopStart)
                .offset(y = -(60.dp), x = 15.dp)
                .padding(16.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.LightGray,
                    shape = CircleShape
                )
        )
        Button(
            modifier = Modifier
                .width(165.dp)
                .clip(RoundedCornerShape(5.dp))
                .padding(top = 15.dp, end = 34.dp)
                .align(Alignment.TopEnd),
            border = BorderStroke(1.dp, colorResource(id = R.color.light_blue)),
            onClick = {},
            colors =
            ButtonDefaults.buttonColors(
                contentColor = colorResource(id = R.color.theme),
                backgroundColor = Color.Transparent
            ),
            elevation = null
        ) {
            Text(
                text = "Follow",
                style = TextStyle(
                    color = colorResource(id = R.color.theme),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            )
        }
    }
}

@Composable
fun UserInfo() {
    Column(modifier = Modifier.padding(top = 75.dp)) {
        Column(modifier = Modifier.padding(start = 15.dp, end = 10.dp)) {
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Jagan", style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp,
                        color = colorResource(id = R.color.user_name)
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.verification_icon),
                    contentDescription = "Blue tick,",
                    modifier=Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = "@Jagan_dev", style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = colorResource(R.color.user_tag)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "About me? I'm just an idiot, who don't know what I'm doing with my life! ;) yeah...",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.user_tag)
                ),
            )
            Spacer(modifier = Modifier.height(21.dp))
            UserDetails()
            Spacer(modifier = Modifier.height(17.dp))
            Followers()
            Spacer(modifier = Modifier.height(15.dp))
        }
        TweetsSection()
    }
}

@Composable
fun UserDetails() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.calender), contentDescription = "Date")
            Text(
                text = "Joined Mar 12,2017",
                style = TextStyle(color = Color.Black, fontSize = 12.sp),
                modifier = Modifier.padding(start = 3.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.link),
                contentDescription = "link",
                modifier = Modifier.size(15.dp)
            )
            Text(
                text = "youtube.com/@jagan_dev",
                style = TextStyle(color = colorResource(id = R.color.theme), fontSize = 12.sp),
                modifier = Modifier
                    .padding(start = 3.dp)
                    .width(125.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}

@Composable
fun Followers() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "1.2k", style = TextStyle(
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(end = 10.dp)
        )
        Text(
            text = "Following", style =
            TextStyle(
                color = Color.DarkGray,
                fontSize = 13.sp
            ),
            modifier = Modifier.padding(end = 10.dp)
        )
        Spacer(modifier = Modifier.width(30.dp))
        Divider(
            modifier = Modifier
                .width(3.dp)
                .height(25.dp), color = Color.LightGray
        )
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = "127.3k", style = TextStyle(
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(end = 10.dp)
        )
        Text(
            text = "Followers", style =
            TextStyle(
                color = Color.DarkGray,
                fontSize = 13.sp
            )
        )
    }
}

@Composable
fun TweetsSection() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)), elevation = 25.dp
    ) {
        Column() {
            Spacer(modifier = Modifier.height(21.dp))
            SectionName()
            Spacer(modifier = Modifier.height(15.dp))
            val textList = listOf(
                "I made Spotify and removed ads! ;)",
                "Change your ideas into apps",
                "Simplicity is the soul of efficiency...",
                "“Programmer: A machine that turns coffee into code.”",
                "Hello dude! I created the alternate version of the famous logos! Check that out...",
                "I made instagram, And gave my self thousands of followers!",
                "“A son asked his father (a programmer) why the sun rises in the east, and sets in the west. His response? It works, don’t touch!“",
                "New Video out now! Here I'm sharing my 4 months of app development experience...",
                "Avengers ! Assemble...",
                "“A good programmer is someone who always looks both ways before crossing a one-way street.”",
            )
            val posts = remember {
                listOf(
                    R.drawable.thumbnail8,
                    R.drawable.thumbnail2,
                    null,
                    null,
                    R.drawable.thumbnail6,
                    R.drawable.thumbnail14,
                    null,
                    R.drawable.thumbnail1,
                    R.drawable.thumbnail9,
                    null,

                    )
            }
            for (i in 0..9) {
                Tweet(
                    tweetText = textList[i],
                    tweetImage = posts[i]?.let { painterResource(id = posts[i]!!) })
            }
        }
    }
}

@Composable
fun SectionName() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Text(
                text = "Tweets",
                style = TextStyle(
                    color = colorResource(id = R.color.theme),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Divider(
                modifier = Modifier
                    .height(3.dp)
                    .width(45.dp)
                    .padding(start = 10.dp, end = 10.dp),
                color = colorResource(id = R.color.theme)
            )
        }
        Text(
            text = "Tweet replies",
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            text = "Tweets",
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            text = "Media",
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            text = "Likes",
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }

}

@Composable
fun Tweet(tweetText: String, tweetImage: Painter?) {
    Card(
        modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 4.dp, bottom = 10.dp),
        elevation = 25.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(10.dp)
                )
        ) {
            UserTweetDetails()
            Divider(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                color = Color.LightGray
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = tweetText, overflow = TextOverflow.Ellipsis, maxLines = 4,
                    style = TextStyle(fontSize = 14.sp),
                    modifier = Modifier.padding(5.dp)
                )
                if (tweetImage != null) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(170.dp)
                            .align(Alignment.CenterHorizontally),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Image(
                            modifier = Modifier,
                            painter = tweetImage,
                            contentDescription = "Tweet Image",
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
            TweetInfo()
        }
    }
}

@Composable
fun UserTweetDetails() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 4.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(color = Color.Transparent) {
                Image(
                    painter = painterResource(id = R.drawable.channel_logo),
                    contentDescription = "User Profile Picture",
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
                )
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Jagan", style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = colorResource(id = R.color.user_name)
                    )
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "@Jagan_dev", style = TextStyle(
                        fontSize = 13.sp,
                        color = colorResource(R.color.user_tag)
                    )
                )
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
            contentDescription = "More Icon",
            modifier = Modifier
                .size(25.dp)
        )
    }
}

@Composable
fun TweetInfo() {
    val tweetCount = Random.nextInt(300, 800)
    val likeCount = Random.nextInt(300, 800)
    val retweetCount = Random.nextInt(300, 800)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 4.dp, bottom = 4.dp)
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.comments),
                contentDescription = "Comments",
                tint = colorResource(id = R.color.theme),
                modifier = Modifier
                    .size(40.dp)
                    .padding(10.dp)
            )
            Text(
                text = tweetCount.toString(),
                style = TextStyle(color = colorResource(id = R.color.user_tag), fontSize = 12.sp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.retweet),
                contentDescription = "Retweet",
                modifier = Modifier
                    .size(40.dp)
                    .padding(10.dp),
                tint = Color.Green
            )
            Text(
                text = retweetCount.toString(),
                style = TextStyle(color = colorResource(id = R.color.user_tag), fontSize = 12.sp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "likes",
                modifier = Modifier
                    .size(40.dp)
                    .padding(10.dp),
                tint = Color.Red
            )
            Text(
                text = likeCount.toString(),
                style = TextStyle(color = colorResource(id = R.color.user_tag), fontSize = 12.sp)
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.send),
            contentDescription = "Send",
            modifier = Modifier
                .size(40.dp)
                .padding(10.dp)
        )
    }
}





