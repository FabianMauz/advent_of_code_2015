/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fmauz.advent_of_code_2015.day_22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author fmauz
 */
public class Solution {

    public static void main(String[] args) {

        int PLAYER_MANA = 500;
        int PLAYER_HP = 50;
        int BOSS_HP = 55;
        int BOSS_ATTACK = 8;

        SpellBook book = new SpellBook();
        SpellBundleCreator bundleCreator = new SpellBundleCreator(book);
        List<SpellBundle> winningBundles = new ArrayList<>();

        for (int depth = 4; depth < 9; depth++) {
            List<SpellBundle> bundles = bundleCreator.createBundleWithSpells(depth, PLAYER_MANA);
            int i = 0;
            for (SpellBundle bundle : bundles) {

                Player player = new Player(PLAYER_HP, PLAYER_MANA, bundle);
                Character enemy = new fmauz.advent_of_code_2015.day_22.Character(BOSS_HP, BOSS_ATTACK);
                //Character enemy = new fmauz.advent_of_code_2015.day_22.Character(13, 8, 0);
                Game game = new Game(player, enemy);
                // game.setPrintOutput(true);

                game.simulateBattle();
                boolean win = game.isPlayerWinner();
                if (win) {
                    winningBundles.add(bundles.get(i));
                }
                float percent = Math.round((100f * i) / (double) bundles.size());
                //System.out.print("Iteration " + i + " -> " + win + "   " + bundles2.get(i).getSpellNames());
                //System.out.print(" ------ " + percent + " %");
                //System.out.println("");
                i++;
            }
        }

        winningBundles.sort((b1, b2) -> {
            if (b1.getCosts() > b2.getCosts()) {
                return 1;
            } else if (b1.getCosts() < b2.getCosts()) {
                return -1;
            } else {
                return 0;
            }
        });

        for (SpellBundle bundle : winningBundles) {
            System.out.println(bundle.getCosts() + " -> " + bundle.getSpellNames());
        }

    }
}
