package com.jasonbarraclough465lab.dreaddaysmod.event;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import com.jasonbarraclough465lab.dreaddaysmod.entity.HelperNPCEntity;
import com.jasonbarraclough465lab.dreaddaysmod.entity.DreadDaysEntities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * HELPER NPC SPAWN HANDLER
 * 
 * Spawns the Helper NPC on the first day the player logs in.
 * The NPC appears in the distance, watching. Waiting.
 * 
 * It only spawns once. After that, it's always there.
 * You can't get rid of it. You won't want to.
 */
@Mod.EventBusSubscriber(modid = "dreaddaysmod", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HelperNPCSpawnHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String NPC_SPAWNED_KEY = "DreadDaysNPCSpawned";

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) return;
        
        if (event.getServer() == null || event.getServer().getPlayerList().getPlayers().isEmpty()) return;

        Player player = event.getServer().getPlayerList().getPlayers().get(0);
        if (player == null) return;

        Level level = player.level();
        if (level.isClientSide) return;

        if (!player.getPersistentData().getBoolean(NPC_SPAWNED_KEY)) {
            spawnHelperNPC(player, level);
            player.getPersistentData().putBoolean(NPC_SPAWNED_KEY, true);
        }
    }

    /**
     * Spawns the HelperNPC at a distance from the player
     * It appears mysteriously, and you immediately know something is wrong
     */
    private static void spawnHelperNPC(Player player, Level level) {
        Vec3 spawnPos = player.position().add(
            (Math.random() - 0.5) * 60,
            0,
            (Math.random() - 0.5) * 60
        );

        HelperNPCEntity npc = DreadDaysEntities.HELPER_NPC.get().create(level);
        if (npc != null) {
            npc.moveTo(spawnPos.x, spawnPos.y, spawnPos.z, 0, 0);
            level.addFreshEntity(npc);
            LOGGER.warn("Helper NPC spawned at: " + spawnPos.x + ", " + spawnPos.y + ", " + spawnPos.z);
            LOGGER.warn("The watcher has arrived.");
        }
    }
}
