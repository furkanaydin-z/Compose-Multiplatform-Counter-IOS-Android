import platform.AVFAudio.AVSpeechBoundary
import platform.AVFAudio.AVSpeechSynthesizer
import platform.AVFAudio.AVSpeechUtterance

actual class CounterManager {

    private val synthesizer = AVSpeechSynthesizer()

    actual fun startSpeechCounter(count: Int) {
        val utterance = AVSpeechUtterance(string = "$count")
        synthesizer.speakUtterance(utterance)

    } //need permission.....

    actual fun stopSpeechCounter() {
        synthesizer.stopSpeakingAtBoundary(AVSpeechBoundary.AVSpeechBoundaryImmediate)

    }
}