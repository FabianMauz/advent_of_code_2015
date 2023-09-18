/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fmauz.advent_of_code_2015.day_21;

/**
 *
 * @author fmauz
 */
public class Character {

    private int life;
    private int armor;
    private int attack;

    public Character(int life, int attack, int armor) {
        this.life = life;
        this.armor = armor;
        this.attack = attack;
    }

    public int getLife() {
        return life;
    }

    public int getArmor() {
        return armor;
    }

    public int getAttack() {
        return attack;
    }

    public void recieveDamage(int attackValue) {
        int realizedDamage = Math.max(1, attackValue - armor);
        life -= realizedDamage;
    }

}
