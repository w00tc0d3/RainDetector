package net.w00tc0d3.RainDetector;

import net.minecraft.tileentity.TileEntity;

public class TileEntityRainDetector extends TileEntity {
	
	public boolean canUpdate() {
		return true;
	}
	
	public void updateEntity() {
		if(worldObj.isRemote == false) {
			if(!worldObj.isRaining() || !worldObj.isThundering()) {
				worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 0, 3);
			} else {
				worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, 1, 3);
			}
		}
	}
}
