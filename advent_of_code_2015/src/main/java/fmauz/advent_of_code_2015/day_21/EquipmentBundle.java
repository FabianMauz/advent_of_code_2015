package fmauz.advent_of_code_2015.day_21;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fmauz
 */
public class EquipmentBundle implements Comparable<EquipmentBundle> {

    private List<Equipment> objects = new ArrayList<>();

    public void addEquipment(Equipment e) {
        this.objects.add(e);
    }

    public int getCost() {
        int cost = 0;
        for (Equipment e : objects) {
            cost += e.getCost();
        }
        return cost;
    }

    public int getTotalAttack() {
        int attack = 0;
        for (Equipment e : objects) {
            attack += e.getDamage();
        }
        return attack;
    }

    public int getTotalArmor() {
        int armor = 0;
        for (Equipment e : objects) {
            armor += e.getArmor();
        }
        return armor;
    }

    public EquipmentBundle copyBundle() {
        EquipmentBundle bundle = new EquipmentBundle();
        for (Equipment e : objects) {
            bundle.addEquipment(e);
        }
        return bundle;
    }

    public String getBundleContentNames() {
        String names = "";
        for (Equipment e : objects) {
            names += e.getName() + ", ";
        }

        return names;

    }

    @Override
    public int compareTo(EquipmentBundle o) {
        if (objects.size() == o.objects.size()) {
            boolean allSame = true;
            for (Equipment e : objects) {
                if (!o.objects.contains(e)) {
                    allSame = false;
                }
            }
            if (allSame) {
                return 0;
            }
        }
        if (o.getCost() == getCost()) {
            return 1;
        } else {
            return o.getCost() - getCost();
        }
    }
}
