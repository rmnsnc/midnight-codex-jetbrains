package com.MidnightCodexTheme.jetbrains.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(name = "MidnightCodexSettings", storages = [Storage("midnight-codex-theme.xml")])
class MidnightCodexSettings : PersistentStateComponent<MidnightCodexState> {
    companion object {
        val instance: MidnightCodexSettings
            get() = ApplicationManager.getApplication().getService(MidnightCodexSettings::class.java)
    }

    private var myState = MidnightCodexState()

    var version: String
        get() = myState.version
        set(value) {
            myState.version = value
        }

    override fun getState(): MidnightCodexState {
        return myState
    }

    override fun loadState(state: MidnightCodexState) {
        myState = state
    }

}
