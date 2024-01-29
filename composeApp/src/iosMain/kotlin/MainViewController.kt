import androidx.compose.ui.main.defaultUIKitMain
import com.moriatsushi.insetsx.WindowInsetsUIViewController
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return WindowInsetsUIViewController { App() }
}

