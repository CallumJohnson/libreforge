package com.willfp.libreforge.conditions.conditions

import com.willfp.eco.core.config.interfaces.Config
import com.willfp.eco.core.integrations.placeholder.PlaceholderManager
import com.willfp.libreforge.arguments
import com.willfp.libreforge.conditions.Condition
import org.bukkit.entity.Player


class ConditionPlaceholderEquals : Condition("placeholder_equals") {
    override val arguments = arguments {
        require("placeholder", "You must specify the placeholder!")
        require("value", "You must specify the value!")
    }

    override fun isConditionMet(player: Player, config: Config): Boolean {
        return PlaceholderManager.translatePlaceholders(config.getString("placeholder"), player)
            .equals(config.getString("value"), ignoreCase = true)
    }
}