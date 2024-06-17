package me.maikelkruger.plugins;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ExibirParticulas implements CommandExecutor, TabCompleter {
    @Override
    public List<String> onTabComplete(@Nonnull CommandSender commandSender,@Nonnull Command command,@Nonnull String s,@Nonnull String[] strings) {
        List<String> string = new ArrayList<>();
        string.clear();
        if(strings.length == 1){
            string.add("10");
            string.add("20");
        }else if(strings.length == 2){
            string.add("1");
            string.add("2");
        }

        return string;
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command,@Nonnull String s,@Nonnull String[] strings) {
        Player player = ((Player) commandSender);
        Location location = player.getLocation().add(0,1,0);
        int numParticles = Integer.parseInt(strings[0]);
        int idParticles = Integer.parseInt(strings[1]);
        if(s.equalsIgnoreCase("exibir")){
            if(commandSender instanceof Player){
                if(strings.length == 1) {
                    if (strings[0].equalsIgnoreCase("help")) {
                        player.sendMessage("Tipos de partículas:\n1-Happy Villager\n2-Angry Villager");
                    }else{
                        commandSender.sendMessage(ChatColor.RED + " Digite /exibir <help> ou /exibir <quantidade de partículas> <id da partícula (1-2)>.");
                        return true;
                    }
                }else if(strings.length == 2){
                    if(numParticles >= 10 && numParticles < 30){
                        if(idParticles == 1) {
                            player.getWorld().spawnParticle(Particle.HAPPY_VILLAGER, location, numParticles);
                        }else if(idParticles == 2){
                            player.getWorld().spawnParticle(Particle.ANGRY_VILLAGER, location, numParticles);
                        }else{
                            commandSender.sendMessage(ChatColor.RED + " Digite /exibir <help> ou /exibir <quantidade de partículas> <id da partícula (1-2)>.");
                            return true;
                        }
                        player.getWorld().playSound(location, Sound.ENTITY_ENDER_DRAGON_GROWL, 0.5f, 1.0f);
                    }else{
                        commandSender.sendMessage(ChatColor.RED + " A quantidade de partículas mínima é 10 e máxima 30.");
                        return true;
                    }
                }else{
                    commandSender.sendMessage(ChatColor.RED + " Digite /exibir <help> ou /exibir <quantidade de partículas> <id da partícula (1-2)>.");
                    return true;
                }
            }else{
                commandSender.sendMessage(ChatColor.RED+" Este comando não pode ser usar no console.");
            }
        }
        return true;
    }
}
