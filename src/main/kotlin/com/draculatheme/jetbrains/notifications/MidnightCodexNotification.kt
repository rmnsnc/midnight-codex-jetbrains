package com.MidnightCodexTheme.jetbrains.notifications

import com.MidnightCodexTheme.jetbrains.MidnightCodexMeta
import com.intellij.ide.BrowserUtil
import com.intellij.notification.Notification
import com.intellij.notification.NotificationAction
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.IconLoader
import org.intellij.lang.annotations.Language

object MidnightCodexNotification {

    @Language("HTML")
    private val whatsNew = """
        <ul>
            <li>Force switch to correspond editor color when toggle UI to Midnight Codex</li>
        </ul>
    """.trimIndent()

    @Language("HTML")
    private val releaseNote = """
        <p>What's New?</p>
        $whatsNew
    """.trimIndent()

    @Language("HTML")
    private val welcomeMessage = """
        <p>Thank you for choosing Midnight Codex.</p>
    """.trimIndent()

    private const val NOTIFICATION_GROUP_ID = "Midnight Codex"

    @JvmField
    val notificationIcon = IconLoader.getIcon("/icons/midnight-codex-logo.svg", javaClass)

    private const val GITHUB_LINK = "https://github.com/rmnsnc/midnight-codex-jetbrains"
    private const val DONATE_LINK = "https://www.buymeacoffee.com/nszihan"

    fun notifyReleaseNote(project: Project) {
        val title = "Midnight CodexTheme updated to v${MidnightCodexMeta.currentVersion}"
        val notification = NotificationGroupManager.getInstance().getNotificationGroup(NOTIFICATION_GROUP_ID)
            .createNotification(title, releaseNote, NotificationType.INFORMATION)
        addNotificationActions(notification)
        notification.icon = notificationIcon
        notification.notify(project)
    }

    fun notifyFirstlyDownloaded(project: Project) {
        val title = "Midnight CodexTheme is installed"
        val notification = NotificationGroupManager.getInstance().getNotificationGroup(NOTIFICATION_GROUP_ID)
            .createNotification(title, welcomeMessage, NotificationType.INFORMATION)
        addNotificationActions(notification)
        notification.icon = notificationIcon
        notification.notify(project)
    }

    private fun addNotificationActions(notification: Notification) {
        val github = NotificationAction.createSimple("GitHub") {
            BrowserUtil.browse(GITHUB_LINK)
        }
        val actionDonate = NotificationAction.createSimple("Donate") {
            BrowserUtil.browse(DONATE_LINK)
        }
        notification.addAction(github)
        notification.addAction(actionDonate)
    }

}
