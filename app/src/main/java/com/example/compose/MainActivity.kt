
package com.example.compose

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.theme.ComposeTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Conversation(messages = SampleData.conversationSample)
            }
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun ShowName(message: Message) {
    if (message.author == "Matheus") {
        Row(modifier = Modifier.padding(all = 8.dp)){
            val image = painterResource(id = R.drawable.profile_picture)
            Image (
                painter = image,
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    .clickable { showImage() }
            )

            Spacer(modifier = Modifier.width(8.dp))

            var isExpanded by remember { mutableStateOf(false)}

            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.surface,
                label = "",
            )

            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = message.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(4.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = message.body,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
    /*else if (message.author == "Heisenberg")
    {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var isExpanded by remember { mutableStateOf(false)}

            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colorScheme.tertiary
                else MaterialTheme.colorScheme.surface,
                label = "",
            )

            Column(
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded }
            ) {
                Text(
                    text = message.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(4.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = message.body,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.tertiary, CircleShape)
                    .clickable { showImage() }
                    .align(Alignment.CenterVertically)
            ) {
                val image = painterResource(id = R.drawable.profile_picture_heisenberg)
                Image(
                    painter = image,
                    contentDescription = "Contact profile picture"
                )
            }
        }
    }*/

    else if (message.author == "Heisenberg")
    {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            var isExpanded by remember { mutableStateOf(false) }

            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colorScheme.tertiary
                else Color.DarkGray,
                label = "",
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { isExpanded = !isExpanded },
                horizontalAlignment = Alignment.End
            ) {

                Text(
                    text = message.author,
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(4.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = message.body,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White
                    )
                }
            }


            Column(
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded }
                    .align(Alignment.CenterVertically)
            ) {
                val image = painterResource(id = R.drawable.profile_picture_heisenberg)
                Image(
                    painter = image,
                    contentDescription = "Contact profile picture",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colorScheme.tertiary, CircleShape)
                )
            }
        }
    }
}

fun showImage() {

}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "DarkMode"
)

@Composable
fun PreviewShowName() {
    ComposeTheme {
        Surface {
            ShowName(
                (Message("Lexi", "Lorem ipsu"))
            )
        }
    }
}

@Composable
fun Conversation(messages: List<Message>)
{
    LazyColumn {
        items(messages){
            message -> ShowName(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeTheme {
        Conversation(SampleData.conversationSample)
    }
}

/**
 * SampleData for Jetpack Compose Tutorial
 */
object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Message(
            "Matheus",
            "Test...Test...Test..."
        ),
        Message(
            "Matheus",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim()
        ),
        Message(
            "Matheus",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim()
        ),
        Message(
            "Heisenberg",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Heisenberg",
            """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
        ),
        Message(
            "Matheus",
            "It's available from API 21+ :)"
        ),
        Message(
            "Matheus",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Heisenberg",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Matheus",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Heisenberg",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Heisenberg",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Heisenberg",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Matheus",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}
