package com.jasonbarraclough465lab.dreaddaysmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.npc.AbstractVillager;
import com.jasonbarraclough465lab.dreaddaysmod.entity.DreadDaysEntities;

/**
 * ENTITY ATTRIBUTE SETUP
 * 
 * Registers the HelperNPC's stats and attributes
 * (health, movement speed, follow range, etc.)
 */
@Mod.EventBusSubscriber(modid = "dreaddaysmod", bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributeHandler {
    @SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(DreadDaysEntities.HELPER_NPC.get(), 
            AbstractVillager.createAttributes().build());
    }
}
