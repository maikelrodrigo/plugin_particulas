package me.maikelkruger.plugins;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Comandos extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + this.getName()+" Iniciado com sucesso!");
        getCommand("exibir").setExecutor(new ExibirParticulas());
    }
}
