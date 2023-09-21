/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fmauz.advent_of_code_2015.day_22;

/**
 *
 * @author fmauz
 */
public class Player extends Character {

    private SpellBundle spellBundle;
    private int mana;
    private int armor;

    public Player(int life, int mana, SpellBundle bundle) {
        super(life, 0);
        this.mana = mana;
        this.spellBundle = bundle;
    }

    public void addMana(int mana) {
        this.mana += mana;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getMana() {
        return mana;
    }

    public void heal(int amount) {
        this.life += amount;
    }

    public Spell castNextSpell() {
        Spell s = spellBundle.getNextSpell();
        mana -= s.getCost();
        if (mana < 0) {
            throw new RuntimeException("Not enough mana");
        }
        return s;
    }

    @Override
    public void recieveDamage(int attackValue) {
        int realizedDamage = Math.max(1, attackValue - armor);
        life -= realizedDamage;
    }
}
