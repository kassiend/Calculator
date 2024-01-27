package ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

public val Icons.Filled.Nightlight: ImageVector
    get() {
        if (_nightlight != null) {
            return _nightlight!!
        }
        _nightlight = materialIcon(name = "Filled.Nightlight") {
            materialPath {
                moveTo(14.0f, 2.0f)
                curveToRelative(1.82f, 0.0f, 3.53f, 0.5f, 5.0f, 1.35f)
                curveTo(16.01f, 5.08f, 14.0f, 8.3f, 14.0f, 12.0f)
                reflectiveCurveToRelative(2.01f, 6.92f, 5.0f, 8.65f)
                curveTo(17.53f, 21.5f, 15.82f, 22.0f, 14.0f, 22.0f)
                curveTo(8.48f, 22.0f, 4.0f, 17.52f, 4.0f, 12.0f)
                reflectiveCurveTo(8.48f, 2.0f, 14.0f, 2.0f)
                close()
            }
        }
        return _nightlight!!
    }

private var _nightlight: ImageVector? = null
