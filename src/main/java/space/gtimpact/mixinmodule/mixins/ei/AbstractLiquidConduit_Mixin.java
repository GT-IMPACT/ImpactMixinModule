package space.gtimpact.mixinmodule.mixins.ei;

import crazypants.enderio.conduit.liquid.AbstractLiquidConduit;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractLiquidConduit.class)
public abstract class AbstractLiquidConduit_Mixin {

    @Shadow(remap = false) public abstract IFluidHandler getExternalHandler(ForgeDirection direction);

    @Inject(method = "canConnectToExternal", at = @At("HEAD"), remap = false, cancellable = true)
    private void canConnectToExternal(ForgeDirection direction, boolean ignoreDisabled, CallbackInfoReturnable<Boolean> cir) {
        IFluidHandler h = getExternalHandler(direction);
        if (h == null) {
            cir.setReturnValue(false);
            return;
        }

        if (h instanceof IGregTechTileEntity) {
            IMetaTileEntity mte = ((IGregTechTileEntity) h).getMetaTileEntity();
            cir.setReturnValue(mte != null && mte.getCapacity() > 0);
            return;
        }
        cir.setReturnValue(true);
    }
}
