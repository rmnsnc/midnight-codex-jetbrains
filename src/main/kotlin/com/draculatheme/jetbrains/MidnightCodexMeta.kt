package com.MidnightCodexTheme.jetbrains

import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.extensions.PluginId

object MidnightCodexMeta {
    val currentVersion: String
        get() = PluginManagerCore.getPlugin(PluginId.getId("com.rmnsnc.idea"))?.version ?: ""
}