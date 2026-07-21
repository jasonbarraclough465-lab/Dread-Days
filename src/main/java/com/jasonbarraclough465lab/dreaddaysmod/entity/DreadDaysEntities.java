package com.jasonbarraclough465lab.dreaddaysmod.entity;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

/**
 * ENTITY REGISTRATION
 * 
 * Registers the HelperNPC entity type so Minecraft knows about it
 */
public class DreadDaysEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = 
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "dreaddaysmod");

    public static final RegistryObject<EntityType<HelperNPCEntity>> HELPER_NPC =
        ENTITIES.register("helper_npc", () ->
            EntityType.Builder.of(HelperNPCEntity::new, MobCategory.CREATURE)
                .sized(0.6f, 1.95f)
                .build("helper_npc"));
}
