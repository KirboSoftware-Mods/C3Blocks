package com.kirbosoftware.c3blocks.item;

import com.kirbosoftware.c3blocks.block.CompressionBlock;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CompressedBlockItem extends BlockItem {
    private final int compressionLevel;
    private final Block parent;
    public CompressedBlockItem(CompressionBlock block, Settings settings, int compressionTier, Block parentBlock) {
        super(block, settings);
        this.parent = parentBlock;
        this.compressionLevel = compressionTier;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        int baseValue = 9;

        if (!(this.compressionLevel == 1)) {
            for (int i = 2; i <= this.compressionLevel; i++) {
                baseValue *= 9;
            }
        }

        tooltip.add(Text.translatable("item.c3blocks.tooltip", (baseValue), Text.translatable(this.parent.getTranslationKey()))
                .formatted(Formatting.GRAY));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
