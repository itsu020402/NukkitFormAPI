package itsu.mcbe.form.core;

import cn.nukkit.plugin.PluginBase;
import itsu.mcbe.form.event.NukkitFormEventListener;

public class NukkitFormAPICore extends PluginBase {

    @Override
    public void onEnable() {
        DataCenter.initalize();
        getServer().getPluginManager().registerEvents(new NukkitFormEventListener(), this);
        getLogger().info("Initialized NukkitFormAPI.");
    }

}
