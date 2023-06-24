package art.raegaltbogg.mc.choptreew;

import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChopListener implements Listener {
	
	// Check order: isLog -> isTool -> isTree
	@EventHandler(priority = EventPriority.MONITOR)
	@SuppressWarnings("deprecation")
	public void onChopTree(BlockBreakEvent event){
		if (event.isCancelled()) return;
		ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
		ItemMeta m = null;
		if (item.hasItemMeta()){
			m = item.getItemMeta();
		}
		if (ChopWorker.isLog(event.getBlock()) && ChopWorker.isTool(item)
				&& ChopWorker.checkPermission(event.getPlayer()) && !Storage.isOff(event.getPlayer())
				&& ChopWorker.isTree(event.getBlock())){
			Block block = event.getBlock();
			List<Block> logsl = ChopWorker.getLogsToPop(block);
			if (logsl.size() == 0) return;
			int logsamount = logsl.size();
			if (ChopWorker.checkDurability(event.getPlayer().getInventory().getItemInMainHand(), logsamount) || m.isUnbreakable()){
				logsl.add(0, event.getBlock());
				ChopWorker.pop(logsl, block);
				event.setCancelled(true);
				if (item.getDurability() > item.getType().getMaxDurability()){
					event.getPlayer().getInventory().setItemInMainHand(null);
				}
			} else {
			}
		}
	}

}
