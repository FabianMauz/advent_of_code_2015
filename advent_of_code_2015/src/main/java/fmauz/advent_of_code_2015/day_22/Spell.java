/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fmauz.advent_of_code_2015.day_22;

/**
 *
 * @author fmauz
 */
public class Spell {

    private String name;
    private int duration;
    private int armor;
    private SpellBook.SpellType type;

    public int getArmor() {
        return armor;
    }

    public int getDamage() {
        return damage;
    }

    public int getRecharge() {
        return recharge;
    }

    public int getHeal() {
        return heal;
    }
    private int damage;
    private int recharge;
    private int cost;
    private int heal;

    public Spell(String name, int cost, SpellBook.SpellType type) {
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public Spell setArmor(int armor) {
        this.armor = armor;
        return this;
    }

    public Spell setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public Spell setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    public Spell setRecharge(int recharge) {
        this.recharge = recharge;
        return this;
    }

    public Spell setHeal(int heal) {
        this.heal = heal;
        return this;
    }

    public boolean decreaseRound() {
        this.duration--;
        return duration <= 0;
    }

    public int getCost() {
        return cost;
    }

    public SpellBook.SpellType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Spell copySpell() {
        Spell spell = new Spell(name, cost, type);
        spell.setArmor(armor);
        spell.setDamage(damage);
        spell.setDuration(duration);
        spell.setHeal(heal);
        spell.setRecharge(recharge);
        return spell;
    }

}
