package me.crafter.mc.choptreew;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public class ReplantTask implements Runnable {

	public Block block;
	public Material saplingType;
	
	@SuppressWarnings("deprecation")
	public ReplantTask(Block log){
		block = log;
		switch (log.getType()){
		case OAK_LOG:
			saplingType = Material.OAK_SAPLING;
			break;
		case SPRUCE_LOG:
			saplingType = Material.SPRUCE_SAPLING;
			break;
		case BIRCH_LOG:
			saplingType = Material.BIRCH_SAPLING;
			break;
		case ACACIA_LOG:
			saplingType = Material.ACACIA_SAPLING;
			break;
		case DARK_OAK_LOG:
			saplingType = Material.DARK_OAK_SAPLING;
			break;
		case JUNGLE_LOG:
			saplingType = Material.JUNGLE_SAPLING;
			break;
		default:
			break;
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		if (block.getType() == Material.AIR){
			switch (block.getRelative(BlockFace.DOWN).getType()){
			case DIRT:
			case GRASS:
			case MYCELIUM:
				block.setType(saplingType);
				break;
			default:
				break;
			}
		}
	}

}
