package ambos.farview.mixin;

import net.minecraft.level.dimension.Dimension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Dimension.class)
public class DimensionMixin {
    @Inject(method = "method_1764", at = @At("RETURN"), cancellable = true)
    public void onGetCloudsHeight(CallbackInfoReturnable ci) {
        ci.setReturnValue(128F);
    }
}
