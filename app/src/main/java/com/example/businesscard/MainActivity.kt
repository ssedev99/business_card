package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                BusinessCard()
            }
        }
    }
}

@Composable
fun CenterSection(
    logo: Painter,
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .size(102.dp)
                .background(colorResource(id = R.color.icon))
        )
        Text(
            text = fullName,
            fontSize = 48.sp,
        )
        Text(
            text = title,
            color = colorResource(id = R.color.title),
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun IconLabel(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color(0xFF026E3C),
            modifier = Modifier
                .size(24.dp)
        )
        Text(
            text = label,
        )
    }
}

@Composable
fun BottomSection(
    phoneNumber: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        IconLabel(
            icon = Icons.Rounded.Phone,
            label = phoneNumber,
        )
        IconLabel(
            icon = Icons.Rounded.Share,
            label = socialMedia,
        )
        IconLabel(
            icon = Icons.Rounded.Email,
            label = email,
        )
    }
}

@Composable
fun BusinessCard(
    modifier: Modifier = Modifier
) {
    val logo = painterResource(id = R.drawable.android_logo)

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .background(colorResource(id = R.color.background)),
        contentAlignment = Alignment.Center
    ) {
        CenterSection(
            logo = logo,
            fullName = "Jennifer Doe",
            title = "Android Developer Extraordinaire",
            modifier = Modifier.align(Alignment.Center)
        )
        BottomSection(
            phoneNumber = "+11 (123) 444 555 666",
            socialMedia = "@AndroidDev",
            email = "jen.doe@android.com",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun IconLabelPreview() {
    BusinessCardTheme {
        IconLabel(
            icon = Icons.Rounded.Phone,
            label = "+11 (123) 444 555 666",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSectionPreview() {
    BusinessCardTheme {
        BottomSection(
            phoneNumber = "+11 (123) 444 555 666",
            socialMedia = "@AndroidDev",
            email = "jen.doe@android.com",
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CenterSectionPreview() {
    BusinessCardTheme {
        CenterSection(
            logo = painterResource(id = R.drawable.android_logo),
            fullName = "Jennifer Doe",
            title = "Android Developer Extraordinaire",
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
