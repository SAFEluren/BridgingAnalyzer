package ldcr.BridgingAnalyzer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent.Status;

public class ResourcePackLoader implements Listener {
	@EventHandler
	public void onJoin(final PlayerJoinEvent e) {
		/*Bukkit.getScheduler().runTaskLater(BridgingAnalyzer.instance, new Runnable() {
			@Override
			public void run() {
				e.getPlayer().setResourcePack("https://raw.githubusercontent.com/Ldcr993519867/FileCloud/master/BridgingHelper.zip");
			}
		}, 10);*/
	}

	@EventHandler
	public void onRefuse(final PlayerResourcePackStatusEvent e) {
		if (e.getStatus() == Status.ACCEPTED) {
			e.getPlayer().sendMessage("§b§lBridgingAnalyzer §7>> §e正在下载资源包, 请稍候...");
			//} else if (e.getStatus() == Status.DECLINED) {
			//	e.getPlayer().sendMessage(new String[] { "§c§lBridgingAnalyzer §7>> §e您拒绝了我们的资源包, 如想要使用请重新进入游戏",
			//			"§c§lBridgingAnalyzer §7>> §b此资源包对沙石添加了标记线以辅助您练习" });
		} else if (e.getStatus() == Status.FAILED_DOWNLOAD) {
			e.getPlayer().sendMessage(new String[] { "§a§lBridgingAnalyzer §7>> §c资源包下载失败, 请重进游戏再试一次",
			"§a§lBridgingAnalyzer §7>> §c如果此情况反复出现, 请联系管理员" });
		} else if (e.getStatus() == Status.SUCCESSFULLY_LOADED) {
			e.getPlayer().sendMessage(new String[] {"",
					"§a§lBridgingAnalyzer §7>> §b此资源包对沙石添加了标记线以辅助您练习",
					"§a§lBridgingAnalyzer §7>> §e  顶端的红蓝线是走搭路线",
					"§a§lBridgingAnalyzer §7>> §e  侧面的指示线是推荐准心位置",
					"§a§lBridgingAnalyzer §7>> §a输入 /bridge 可以开关一些有用的功能",
			"" });
		}
	}
}