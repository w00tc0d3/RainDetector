package net.w00tc0d3.RainDetector;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRainDetector extends Block {

	public BlockRainDetector(int par1) {
		super(par1, Material.ground);
		this.setHardness(0.5F);
		this.setStepSound(Block.soundStoneFootstep);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("raindetector:raindetector");
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityRainDetector();
	}	
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
    /**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     */
	@Override
    public boolean canProvidePower()
    {
        return true;
    }

    /**
     * Returns true if the block is emitting indirect/weak redstone power on the specified side. If isBlockNormalCube
     * returns true, standard redstone propagation rules will apply instead and this will not be called. Args: World, X,
     * Y, Z, side. Note that the side is reversed - eg it is 1 (up) when checking the bottom of the block.
     */
    @Override
    public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
    	int metadata = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
        if(metadata == 0) {
        	return 0;
        }
        return 15;
    }
}
