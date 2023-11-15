package com.MidnightCodexTheme.jetbrains.listeners

import com.MidnightCodexTheme.jetbrains.enums.MidnightCodexVariant
import com.intellij.ide.ui.LafManager
import com.intellij.ide.ui.LafManagerListener
import com.intellij.openapi.editor.colors.EditorColorsManager

class MidnightCodexThemeChangeListener : LafManagerListener {

    private val editorColorsManager = EditorColorsManager.getInstance()

    private var previousUI = LafManager.getInstance().currentLookAndFeel.name

    override fun lookAndFeelChanged(lafManager: LafManager) {
        val currentUI = lafManager.currentLookAndFeel.name
        if (previousUI != currentUI) {
            if (currentUI == MidnightCodexVariant.MidnightCodex.label || currentUI == MidnightCodexVariant.MidnightCodexAlternative.label) {
                editorColorsManager.globalScheme = editorColorsManager.getScheme("_@user_$currentUI")
            }
        }
        previousUI = currentUI
    }

}
