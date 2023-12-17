package space.gtimpact.mixinmodule.mixins.ae2;

import com.glodblock.github.inventory.FluidConvertingInventoryAdaptor;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaPipeEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidConvertingInventoryAdaptor.class)
public class AEFC_GT_Fix_Mixin {

    @Inject(method = "checkGTPipeConnection", at = @At("HEAD"), remap = false, cancellable = true)
    private void checkGTPipeConnection(TileEntity te, ForgeDirection direction, CallbackInfoReturnable<Boolean> cir) {
        if (te instanceof IGregTechTileEntity) {
            IMetaTileEntity mte = ((IGregTechTileEntity) te).getMetaTileEntity();
            if (mte instanceof MetaPipeEntity) {
                cir.setReturnValue(((MetaPipeEntity) mte).isConnectedAtSide(direction.ordinal()));
            }
        }
        cir.setReturnValue(true);
    }
}
