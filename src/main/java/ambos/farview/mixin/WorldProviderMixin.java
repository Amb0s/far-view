package ambos.farview.mixin;

import net.minecraft.src.WorldProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = WorldProvider.class, remap = false)
final class WorldProviderMixin {
    private float cloudHeight = 128F;
    @Inject(method = "getCloudHeight", at = @At("RETURN"), cancellable = true, require = 0)
    public void onGetCloudHeight(CallbackInfoReturnable ci) {
        ci.setReturnValue(cloudHeight); // Sets default cloud height.
    }
}
