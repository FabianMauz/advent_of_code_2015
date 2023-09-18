/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fmauz.advent_of_code_2015.day_21;

import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author fmauz
 */
public class Solution {

    public static void main(String[] args) {
       

        EquipmentStore store = new EquipmentStore();
        TreeSet<EquipmentBundle> bundles = store.getPossibleEquipmentSortedByLowestCost();
        for (EquipmentBundle bundle : bundles) {
            Character player = new Character(100, bundle.getTotalAttack(), bundle.getTotalArmor());
            Character enemy = new Character(103, 9, 2);
            Game game = new Game(player, enemy);
            game.simulateBattle();
            String result = game.isPlayerWinner() ? "WIN" : "LOSS";
            System.out.println(result +" cost:" +bundle.getCost()+ " -> A:" +bundle.getTotalAttack()+" D:"+ bundle.getTotalArmor()+ " -> "+bundle.getBundleContentNames());
        }
    }

}
