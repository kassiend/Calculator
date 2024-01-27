package nuemorphism.shape

import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import nuemorphism.NeuStyle
import nuemorphism.drawBackgroundShadows

class Flat(override val cornerShape: CornerShape) : NeuShape(cornerShape) {
    override fun draw(drawScope: ContentDrawScope, style: NeuStyle) {
        drawScope.drawBackgroundShadows(this, style)
        drawScope.drawContent()
    }
}