package fmauz.advent_of_code_2015.day_22;

/**
 *
 * @author fmauz
 */
public class SpellBook {

    private Spell[] spells = new Spell[5];

    public SpellBook() {
        spells[0] = new Spell("Magic Missile", 53, SpellType.MAGIC_MISSILE).setDamage(4);
        spells[1] = new Spell("Drain", 73, SpellType.DRAIN).setDamage(2).setHeal(2);
        spells[2] = new Spell("Shield", 113, SpellType.SHIELD).setArmor(7).setDuration(6);
        spells[3] = new Spell("Poison", 173, SpellType.POISON).setDamage(3).setDuration(6);
        spells[4] = new Spell("Recharge", 229, SpellType.RECHARGE).setRecharge(101).setDuration(5);
    }

    public Spell getSpell(SpellType type) {
        return spells[type.ordinal()];
    }

    public enum SpellType {
        MAGIC_MISSILE,
        DRAIN,
        SHIELD,
        POISON,
        RECHARGE
    }

    public Spell getNextSpell(Spell s) {
        for (int i = 0; i < spells.length - 1; i++) {
            if (s == spells[i]) {
                return spells[i + 1];
            }
        }
        return spells[0];
    }

}
