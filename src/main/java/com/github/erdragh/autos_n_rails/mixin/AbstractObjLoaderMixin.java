package com.github.erdragh.autos_n_rails.mixin;

import dev.monarkhes.myron.impl.client.obj.AbstractObjLoader;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(value = AbstractObjLoader.class, remap = false)
public class AbstractObjLoaderMixin {
  @Inject(method = "loadModel", at = @At("HEAD"), cancellable = true)
  private void autos_n_rails$TEMPORARY_FIX_FOR_STEAM_N_RAILS_REMOVE_LATER(ResourceManager resourceManager, ResourceLocation identifier, ItemTransforms transformation, boolean isSideLit, CallbackInfoReturnable<UnbakedModel> cir) {
    final String namespace = identifier.getNamespace();
    if ("railways".equals(namespace) || "create".equals(namespace)) {
      cir.setReturnValue(null);
    }
  }
}
