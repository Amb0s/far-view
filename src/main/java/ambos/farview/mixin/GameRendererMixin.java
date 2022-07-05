package ambos.farview.mixin;

import net.minecraft.sortme.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
final class GameRendererMixin {
    @Shadow
    private float field_2350 = 0.0F;

    private float field_2350_store;

    @Inject(method = "method_1842", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL11;glFogf(IF)V", ordinal = 4), cancellable = true)
    private void changeFogStartDistance(int i, float f, CallbackInfo ci) {
        if (field_2350 >= 256) { // On Far view distance ...
            field_2350_store = field_2350;
            field_2350 = field_2350 * 4; // Fog starts at view distance.
        }
    }

    @Inject(method = "method_1842", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL11;glFogf(IF)V", ordinal = 5), cancellable = true)
    private void restoreField(int i, float f, CallbackInfo ci) {
        if (field_2350 >= 256) {
            field_2350 = field_2350_store;
        }
    }
}
