package com.MidnightCodexTheme.jetbrains.activities

import com.MidnightCodexTheme.jetbrains.MidnightCodexMeta
import com.MidnightCodexTheme.jetbrains.notifications.MidnightCodexNotification
import com.MidnightCodexTheme.jetbrains.settings.MidnightCodexSettings
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity

class MidnightCodexStartupActivity : StartupActivity, DumbAware {
    override fun runActivity(project: Project) {
        val settings = MidnightCodexSettings.instance
        if (settings.version.isEmpty()) {
            settings.version = MidnightCodexMeta.currentVersion
            MidnightCodexNotification.notifyFirstlyDownloaded(project)
            return
        }
        if (MidnightCodexMeta.currentVersion != settings.version) {
            settings.version = MidnightCodexMeta.currentVersion
            MidnightCodexNotification.notifyReleaseNote(project)
        }
    }
}
