package ambos.farview.mixin;

import net.minecraft.src.RenderGlobal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = RenderGlobal.class, remap = false)
final class RenderGlobalMixin {
    private int j_store = 0;
    @ModifyVariable(method = "loadRenderers", at = @At(value = "STORE", ordinal = 1), require = 0)
    private int getRenderDistance(int j) {
        j_store = j;

        return j;
    }

    @ModifyVariable(method = "loadRenderers", at = @At(value = "STORE", ordinal = 2), require = 0)
    private int increaseRenderDistance(int j) {
        if (j == 400) {
            return j_store; // Increases render distance.
        }

        return j;
    }
}
