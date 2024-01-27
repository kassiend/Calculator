package nuemorphism.shape

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import nuemorphism.NeuStyle

abstract class NeuShape(open val cornerShape: CornerShape) {
    abstract fun draw(drawScope: ContentDrawScope, style: NeuStyle)
}