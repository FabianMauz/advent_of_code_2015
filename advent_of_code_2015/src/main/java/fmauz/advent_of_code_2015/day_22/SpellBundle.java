package fmauz.advent_of_code_2015.day_22;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fmauz
 */
public class SpellBundle {

    private List<Spell> spellsToCast = new ArrayList<>();
    private int cost;
    private String names;
    private int finalCost;

    public void addSpell(Spell s) {
        this.spellsToCast.add(s);
    }

    public Spell getNextSpell() {
        if (spellsToCast.isEmpty()) {
            throw new RuntimeException("No more Spells");
        }
        Spell s = spellsToCast.get(0);
        spellsToCast.remove(s);
        return s;
    }

    public void saveNames() {
        names = calculateNames();
    }

    public String getSpellNames() {
        return names;
    }

    private String calculateNames() {
        String out = "";
        for (Spell s : spellsToCast) {
            out += s.getName() + " - ";
        }

        return out.substring(0, out.length() - 2);
    }

    public void resetDurations() {
        for (Spell s : spellsToCast) {
            if (s.getType() == SpellBook.SpellType.RECHARGE) {
                s.setDuration(5);
            }
            if (s.getType() == SpellBook.SpellType.SHIELD) {
                s.setDuration(5);
            }
        }
    }

    public int calculateCosts() {
        cost = 0;
        for (int i = 0; i < spellsToCast.size(); i++) {
            cost += Math.max(spellsToCast.get(i).getCost() - getRechargeAt(i), 0);
        }
        return cost;
    }

    public int getCosts() {
        return finalCost;
    }

    private int getRechargeAt(int i) {
        int recharge = 0;
        if (i == 1) {
            recharge += spellsToCast.get(0).getRecharge();
        }
        if (i == 2) {
            recharge += spellsToCast.get(0).getRecharge();
            recharge += spellsToCast.get(1).getRecharge();
        }
        if (i == 3) {
            recharge += spellsToCast.get(0).getRecharge();
            recharge += spellsToCast.get(1).getRecharge();
            recharge += spellsToCast.get(2).getRecharge();
        }
        if (i == 4) {
            recharge += spellsToCast.get(0).getRecharge();
            recharge += spellsToCast.get(1).getRecharge();
            recharge += spellsToCast.get(2).getRecharge();
            recharge += spellsToCast.get(3).getRecharge();
        }
        if (i == 5) {
            recharge += spellsToCast.get(0).getRecharge();
            recharge += spellsToCast.get(1).getRecharge();
            recharge += spellsToCast.get(2).getRecharge();
            recharge += spellsToCast.get(3).getRecharge();
            recharge += spellsToCast.get(4).getRecharge();
        }
        if (i == 6) {
            recharge += spellsToCast.get(1).getRecharge();
            recharge += spellsToCast.get(2).getRecharge();
            recharge += spellsToCast.get(3).getRecharge();
            recharge += spellsToCast.get(4).getRecharge();
            recharge += spellsToCast.get(5).getRecharge();
        }
        if (i == 7) {
            recharge += spellsToCast.get(2).getRecharge();
            recharge += spellsToCast.get(3).getRecharge();
            recharge += spellsToCast.get(4).getRecharge();
            recharge += spellsToCast.get(5).getRecharge();
            recharge += spellsToCast.get(6).getRecharge();
        }
        if (i == 8) {
            recharge += spellsToCast.get(3).getRecharge();
            recharge += spellsToCast.get(4).getRecharge();
            recharge += spellsToCast.get(5).getRecharge();
            recharge += spellsToCast.get(6).getRecharge();
            recharge += spellsToCast.get(7).getRecharge();
        }
        if (i == 9) {
            recharge += spellsToCast.get(4).getRecharge();
            recharge += spellsToCast.get(5).getRecharge();
            recharge += spellsToCast.get(6).getRecharge();
            recharge += spellsToCast.get(7).getRecharge();
            recharge += spellsToCast.get(8).getRecharge();
        }
        return recharge;
    }

    public void setFinalCost() {
        this.finalCost = cost;
    }

}
