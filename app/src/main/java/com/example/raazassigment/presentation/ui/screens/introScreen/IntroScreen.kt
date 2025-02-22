import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.raazassigment.presentation.ui.components.OptionButton
import com.example.raazassigment.presentation.ui.components.SkipButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroScreen(navController: NavController) {
    val questions = listOf(
        Question(
            text = "What is your favourite colour?",
            options = listOf("Blue", "Red", "Green")
        ),
        Question(
            text = "Do you have a pet?",
            options = listOf("Yes", "No")
        ),
        Question(
            text = "Which is your most visited city?",
            options = listOf("Mumbai", "Delhi", "Pune"),
        ),
        Question(
            text = "When did you graduate?",
            options = listOf("2021", "2022", "2023")
        )
    )

    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    val currentQuestion = questions[currentQuestionIndex]
    val context = LocalContext.current // Accessing context for Toast

    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* Empty or add a title here if needed */ },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xffD3E7F1)),
                actions = {
                    SkipButton {
                        // Handle skip logic (e.g., navigate to the next screen)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffD3E7F1))
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = currentQuestion.text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            currentQuestion.options.forEach { option ->
                OptionButton(option = option) {
                    if (currentQuestionIndex < questions.size - 1) {
                        currentQuestionIndex++
                    } else {
                        // Show toast message on the last question
                        Toast.makeText(context, "You have completed the questions!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

data class Question(
    val text: String,
    val options: List<String>
)
