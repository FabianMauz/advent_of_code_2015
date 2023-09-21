/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fmauz.advent_of_code_2015.day_22;

/**
 *
 * @author fmauz
 */
public class Character {

    protected int life;
    protected int attack;

    public Character(int life, int attack) {
        this.life = life;
        this.attack = attack;
    }

    public int getLife() {
        return life;
    }

    public int getAttack() {
        return attack;
    }

    public void recieveDamage(int attackValue) {
        int realizedDamage = attackValue;
        life -= realizedDamage;
    }

}
