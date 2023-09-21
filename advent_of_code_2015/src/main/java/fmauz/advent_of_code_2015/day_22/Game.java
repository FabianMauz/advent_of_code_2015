package fmauz.advent_of_code_2015.day_22;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fmauz
 */
public class Game {

    private final Player player;
    private final Character enemy;
    private boolean playerTurn = true;
    private int round = 0;
    private List<Spell> activeSpells = new ArrayList<>();
    private boolean printOutput = false;

    public Game(Player player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public Game simulateBattle() {
        while (!isBattleOver()) {
            doNextTurn();
        }
        return this;
    }

    public boolean isPlayerWinner() {
        return player.getLife() > 0;
    }

    private boolean isBattleOver() {
        return player.getLife() <= 0 || enemy.getLife() <= 0;
    }

    private void doNextTurn() {
        round++;

        player.addMana(getRecharge());
        int poisonDamage = getDamage();

        enemy.recieveDamage(getDamage());
        if (printOutput) {
            System.out.println("Poison deals " + poisonDamage + " -> Boss has " + enemy.getLife() + " HP left");
        }
        if (enemy.life <= 0) {
            return;
        }
        if (playerTurn) {
            doPlayerSpellCast();

        } else {
            if (printOutput) {
                System.out.println("Boss attacks for " + enemy.getAttack() + ", Armor of player " + getArmor());
            }
            doEnemyAttack();
        }

        reduceDurations();
        playerTurn = !playerTurn;
    }

    private void doPlayerSpellCast() {
        Spell spell;
        try {
            spell = player.castNextSpell();
        } catch (Exception e) {
            player.life = 0;
            return;
        }
        if (spell.getType() == SpellBook.SpellType.MAGIC_MISSILE) {

            enemy.recieveDamage(spell.getDamage());
            if (printOutput) {
                System.out.println("Player spells magic missile: " + spell.getDamage() + " -> Boss has " + enemy.getLife() + " HP left");
            }
        } else if (spell.getType() == SpellBook.SpellType.DRAIN) {

            enemy.recieveDamage(spell.getDamage());
            player.heal(spell.getHeal());
            if (printOutput) {
                System.out.println("Player spells DRAIN: " + spell.getDamage() + " -> Boss has " + enemy.getLife() + " HP left");
            }
        } else {
            if (printOutput) {
                System.out.println("Player spells " + spell.getName());
            }
            activeSpells.add(spell);
        }
    }

    private void doEnemyAttack() {
        player.setArmor(getArmor());
        player.recieveDamage(enemy.getAttack());
    }

    public int getRound() {
        return round;
    }

    public int getDamage() {
        int damage = 0;
        for (Spell s : activeSpells) {
            damage += s.getDamage();
        }
        return damage;
    }

    public int getArmor() {
        int armor = 0;
        for (Spell s : activeSpells) {
            armor += s.getArmor();
        }
        return armor;
    }

    public int getHeal() {
        int heal = 0;
        for (Spell s : activeSpells) {
            heal += s.getHeal();
        }
        return heal;
    }

    public int getRecharge() {
        int recharge = 0;
        for (Spell s : activeSpells) {
            recharge += s.getRecharge();
        }
        return recharge;
    }

    public void reduceDurations() {
        for (int i = activeSpells.size() - 1; i >= 0; i--) {
            Spell s = activeSpells.get(i);
            boolean isOver = s.decreaseRound();
            if (isOver) {
                activeSpells.remove(s);
            }
        }
    }

    public void setPrintOutput(boolean printOutput) {
        this.printOutput = printOutput;
    }

    
}
