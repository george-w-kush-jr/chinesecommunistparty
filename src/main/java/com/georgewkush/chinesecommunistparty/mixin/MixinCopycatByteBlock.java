package com.georgewkush.chinesecommunistparty.mixin;

import com.copycatsplus.copycats.content.copycat.bytes.CopycatByteBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CopycatByteBlock.class)
public class MixinCopycatByteBlock {

    @Inject(
            method = "getVectorFromProperty(Lnet/minecraft/world/level/block/state/BlockState;Ljava/lang/String;)Lnet/minecraft/core/Vec3i;",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private void inject$onMissingBite(BlockState state, String property, CallbackInfoReturnable<Vec3i> cir) {
        if (CopycatByteBlock.byteMap == null || !CopycatByteBlock.byteMap.containsKey(property)) {
            cir.setReturnValue(new Vec3i(0, 0, 0));
        }
    }
}
