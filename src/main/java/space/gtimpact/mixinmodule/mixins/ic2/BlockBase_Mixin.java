package space.gtimpact.mixinmodule.mixins.ic2;

import ic2.core.block.BlockBase;
import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockBase.class)
public class BlockBase_Mixin extends Block {

    protected BlockBase_Mixin() {
        super(null);
    }

    @Override
    public int getHarvestLevel(int metadata) {
        return 0;
    }

    @Override
    public String getHarvestTool(int metadata) {
        return "wrench";
    }
}
