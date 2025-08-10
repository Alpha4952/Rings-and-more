package alpheta.rings_and_more.item.custom;

import alpheta.rings_and_more.RingsAndMore;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class CigaretteItem extends Item {
    public CigaretteItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        world.playSound(
                null,
                user.getBlockPos(),
                RingsAndMore.CIGARETTE_SMOKING,
                SoundCategory.PLAYERS,
                0.7f,
                1.0f
        );

        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(
                    ParticleTypes.CAMPFIRE_COSY_SMOKE, // particle type
                    user.getX(),                     // X
                    user.getEyeY(),                   // Y (user head)
                    user.getZ(),                      // Z
                    2,                                  // count
                    0.1, 0.1, 0.1,                       // spread X/Y/Z
                    0.01                                // speed
            );
        }

        user.getStackInHand(hand).damage(1, user, LivingEntity.getSlotForHand(hand));
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        user.setCurrentHand(hand);
        user.getItemCooldownManager().set(this, 80);
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 60;
    }
}