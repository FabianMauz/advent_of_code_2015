package fmauz.advent_of_code_2015.day_21;

/**
 *
 * @author fmauz
 */
public class Equipment {

    private int cost;
    private int damage;
    private int armor;
    private String name;

    public Equipment(int cost, int damage, int armor, String name) {
        this.cost = cost;
        this.damage = damage;
        this.armor = armor;
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public String getName() {
        return name;
    }

}
