package net.w00tc0d3.RainDetector;

import net.minecraft.tileentity.TileEntity;

public class TileEntityRainDetector extends TileEntity {
	
	private boolean currentState = false;
	private boolean newState = false;
	
	public boolean canUpdate() {
		return true;
	}
	
	public void updateEntity() {
		if(worldObj.isRemote == false) {
			if(!worldObj.isRaining() || !worldObj.isThundering()) {
				newState = false;
			} else {
				newState = true;
			}
			
			if(newState != currentState) {
				worldObj.setBlockMetadataWithNotify(this.xCoord, this.yCoord, this.zCoord, (newState ? 1 : 0), 3);
				currentState = newState;
			}
		}
	}
}
