package ambos.farview.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @ModifyVariable(method = "method_1537", at = @At(value = "STORE", ordinal = 2))
    private int doubleViewDistance(int var7) {
        return var7 * 2;
    }
}
