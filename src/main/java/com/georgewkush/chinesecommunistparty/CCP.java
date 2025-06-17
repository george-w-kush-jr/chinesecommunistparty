package com.georgewkush.chinesecommunistparty;

import org.spongepowered.asm.launch.MixinBootstrap;    // ← correct here
import org.spongepowered.asm.mixin.Mixins;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CCP.MODID)
public class CCP {
    public static final String MODID = "chinesecommunistpartypatchmixin";

    public CCP() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.chinesecommunistparty.json");
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        // common‐side init
    }
}
