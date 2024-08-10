
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App(counterManager: CounterManager) {
    var counter by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()
    var job: Job? = null


    MaterialTheme{
        Scaffold(
            topBar = {
                TopAppBar(
                        title = { Text("Push-Up Counter") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Red,
                        titleContentColor = Color.White
                    )
                )
            }
        ){}

        Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = counter.toString(), fontSize = 36.sp)
          Column(modifier = Modifier.padding(top = 16.dp)) {    Button(onClick = {
              job =  scope.launch {
                    repeat(10){
                        delay(1466)
                        counter++
                        counterManager.startSpeechCounter(counter)
                    }
                }
            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )){
                Text("Start Push-Up")

            }
            Button(onClick = {
                job?.cancel()
                counter = 0
                counterManager.stopSpeechCounter()

            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )){
                Text("Stop Push-Up")

            }
          }
        }
    }
}
