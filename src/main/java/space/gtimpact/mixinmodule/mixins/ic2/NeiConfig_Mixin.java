package space.gtimpact.mixinmodule.mixins.ic2;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import ic2.neiIntegration.core.NEIIC2Config;
import ic2.neiIntegration.core.recipehandler.AdvRecipeHandler;
import ic2.neiIntegration.core.recipehandler.AdvShapelessRecipeHandler;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(NEIIC2Config.class)
public abstract class NeiConfig_Mixin implements IConfigureNEI {

    @Override
    public void loadConfig() {
        API.registerRecipeHandler(new AdvRecipeHandler());
        API.registerUsageHandler(new AdvRecipeHandler());
        API.registerRecipeHandler(new AdvShapelessRecipeHandler());
        API.registerUsageHandler(new AdvShapelessRecipeHandler());
    }
}
