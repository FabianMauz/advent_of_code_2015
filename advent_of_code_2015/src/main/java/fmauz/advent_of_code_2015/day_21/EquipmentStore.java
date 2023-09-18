package fmauz.advent_of_code_2015.day_21;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author fmauz
 */
public class EquipmentStore {

    private List<Equipment> weapons = new ArrayList<>();
    private List<Equipment> armors = new ArrayList<>();
    private List<Equipment> rings = new ArrayList<>();

    public EquipmentStore() {
        weapons.add(new Equipment(8, 4, 0, "Dagger"));
        weapons.add(new Equipment(10, 5, 0, "Shortsword"));
        weapons.add(new Equipment(25, 6, 0, "Warhammer"));
        weapons.add(new Equipment(40, 7, 0, "Longsword"));
        weapons.add(new Equipment(74, 8, 0, "Greataxe"));

        armors.add(new Equipment(13, 0, 1, "Leather armor"));
        armors.add(new Equipment(31, 0, 2, "Chainmail"));
        armors.add(new Equipment(53, 0, 3, "Splintmail"));
        armors.add(new Equipment(75, 0, 4, "Bandedmail"));
        armors.add(new Equipment(102, 0, 5, "Platemail"));

        rings.add(new Equipment(25, 1, 0, "Damage +1"));
        rings.add(new Equipment(50, 2, 0, "Damage +2"));
        rings.add(new Equipment(100, 3, 0, "Damage +3"));
        rings.add(new Equipment(20, 0, 1, "Defense +1"));
        rings.add(new Equipment(40, 0, 2, "Defense +2"));
        rings.add(new Equipment(80, 0, 3, "Defense +3"));
    }

    public TreeSet<EquipmentBundle> getPossibleEquipmentSortedByLowestCost() {
        TreeSet<EquipmentBundle> bundles = createPossibleRingBundles();
        bundles = addArmorToBundles(bundles);
        bundles = addWeaponToBundles(bundles);
        
        return bundles;
    }

    public TreeSet<EquipmentBundle> addWeaponToBundles(TreeSet<EquipmentBundle> bundles) {
        TreeSet<EquipmentBundle> bundlesWithWeapon = new TreeSet<>();
        for (Equipment weapon : weapons) {
            for (EquipmentBundle eb : bundles) {
                EquipmentBundle ebWithWeapon = eb.copyBundle();
                ebWithWeapon.addEquipment(weapon);
                bundlesWithWeapon.add(ebWithWeapon);
            }

        }
        return bundlesWithWeapon;
    }

    public TreeSet<EquipmentBundle> addArmorToBundles(TreeSet<EquipmentBundle> bundles) {
        TreeSet<EquipmentBundle> bundlesWithoutArmor = bundles;
        TreeSet<EquipmentBundle> bundlesWithArmor = new TreeSet<>();
        for (Equipment armor : armors) {
            for (EquipmentBundle eb : bundlesWithoutArmor) {
                EquipmentBundle ebWithArmor = eb.copyBundle();
                ebWithArmor.addEquipment(armor);
                bundlesWithArmor.add(ebWithArmor);
            }
        }

        bundlesWithArmor.addAll(bundlesWithoutArmor);
        return bundlesWithArmor;

    }

    public TreeSet<EquipmentBundle> createPossibleRingBundles() {
        TreeSet<EquipmentBundle> ringBundles = new TreeSet<>();
        //create bundles with exactly one ring
        for (Equipment ring : rings) {
            EquipmentBundle eb = new EquipmentBundle();
            eb.addEquipment(ring);
            ringBundles.add(eb);
        }
        //create bundles with exactly two rings
        for (Equipment ring1 : rings) {
            for (Equipment ring2 : rings) {
                if (ring1 != ring2) {
                    EquipmentBundle eb = new EquipmentBundle();
                    eb.addEquipment(ring1);
                    eb.addEquipment(ring2);
                    ringBundles.add(eb);
                }
            }
        }
        //Add empty ring bundle
        ringBundles.add(new EquipmentBundle());

        return ringBundles;
    }
}
