package ambos.farview.mixin;

import net.minecraft.src.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntityRenderer.class, remap = false)
final class EntityRendererMixin {
    @Shadow
    private float farPlaneDistance = 0.0F;

    private float farPlaneDistance_store;

    @Inject(method = "setupFog", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL11;glFogf(IF)V", ordinal = 4),
            cancellable = true, require = 0)
    private void changeFogStartDistance(int i, float f, CallbackInfo ci) {
        farPlaneDistance_store = farPlaneDistance;
        farPlaneDistance = farPlaneDistance * 8; // Disables fog.
    }

    @Inject(method = "setupFog", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/GL11;glFogf(IF)V", ordinal = 5),
            cancellable = true, require = 0)
    private void restoreField(int i, float f, CallbackInfo ci) {
        farPlaneDistance = farPlaneDistance_store;
    }
}
