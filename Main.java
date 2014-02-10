package sunfury.TumbaBit.template;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	//Makes Main class available from all other classes
    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        FileConfiguration config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        
        //Runs the setup method to create the arenas
        ArenaManager.getInstance().setup();
    }

    public void onDisable() {
    	
    }
    
    //Basic command structure
    public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("test")) {
            player.sendMessage("Test!");
        }
        return true;
    }
}
