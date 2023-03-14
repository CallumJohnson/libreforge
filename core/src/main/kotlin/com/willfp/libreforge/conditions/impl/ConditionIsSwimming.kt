package com.willfp.libreforge.conditions.impl

import com.willfp.eco.core.config.interfaces.Config
import com.willfp.libreforge.NoCompileData
import com.willfp.libreforge.conditions.Condition
import com.willfp.libreforge.updateEffects
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.EntityToggleSwimEvent

object ConditionIsSwimming : Condition<NoCompileData>("is_swimming") {
    override fun isMet(player: Player, config: Config, compileData: NoCompileData): Boolean {
        return player.isSwimming
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun handle(event: EntityToggleSwimEvent) {
        val player = event.entity as? Player ?: return
        player.updateEffects()
    }
}