package space.gtimpact.mixinmodule.mixins.sgcraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import gcewing.sg.PowerBlock;

@Mixin(PowerBlock.class)
public class PowerBlock_Mixin {

    // The local GUI has window ID 0 and no slots, so pending player-inventory packets crash it.
    // Wait for Forge to open the GUI with the server-assigned window ID instead.
    @Inject(method = "onBlockActivated", at = @At("HEAD"), cancellable = true, require = 1)
    private void impact$waitForServerGui(
            World world,
            int x, int y, int z,
            EntityPlayer player,
            int side,
            float hitX, float hitY, float hitZ,
            CallbackInfoReturnable<Boolean> cir) {
        if (world.isRemote) {
            cir.setReturnValue(true);
        }
    }
}
