/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fmauz.advent_of_code_2015.day_22;

import fmauz.advent_of_code_2015.day_22.SpellBook.SpellType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author fmauz
 */
public class SpellBundleCreator {

    private int amountSpellTypes = SpellType.values().length;
    private Spell currentSpellToAdd;
    private SpellBook spellBook;

    public SpellBundleCreator(SpellBook book) {
        spellBook = book;
        currentSpellToAdd = book.getSpell(SpellType.MAGIC_MISSILE);
    }

    public List<SpellBundle> createBundleWithSpells(int spells, int mana) {

        int bundlesAmount = (int) Math.pow(amountSpellTypes, spells);
        boolean[] cuttedSolutions = new boolean[bundlesAmount];
        List<SpellBundle> bundles = new ArrayList<>();
        for (int i = 0; i < bundlesAmount; i++) {
            bundles.add(new SpellBundle());
        }

        for (int j = 0; j < spells; j++) {

            System.out.println("Valid paths in round " + j + " :" + getValidPaths(cuttedSolutions));
            int x = (int) Math.pow(amountSpellTypes, spells - 1 - j);
            for (int i = 0; i < bundlesAmount; i++) {
                if (!cuttedSolutions[i]) {
                    bundles.get(i).addSpell(currentSpellToAdd.copySpell());
                    cuttedSolutions[i] = !isBundleCostLowEnough(bundles.get(i), mana);
                }
                if (i % x == 0) {
                    currentSpellToAdd = spellBook.getNextSpell(currentSpellToAdd);
                }
            }
        }

        for (SpellBundle b : bundles) {
            b.saveNames();
            b.setFinalCost();
        }
        removeBundlesWithToMuchCosts(cuttedSolutions, bundles);
        return bundles;

    }

    private boolean isBundleCostLowEnough(SpellBundle b, int maxMana) {
        return b.calculateCosts() <= maxMana;
    }

    private void removeBundlesWithToMuchCosts(boolean[] cuttedSolutions, List<SpellBundle> bundles) {
        for (int i = bundles.size() - 1; i >= 0; i--) {
            if (cuttedSolutions[i]) {
                bundles.remove(i);
            }
        }
    }

    private int getValidPaths(boolean[] cuttedSolutions) {
        int validSolutions = 0;
        for (int i = 0; i < cuttedSolutions.length; i++) {
            validSolutions += cuttedSolutions[i] ? 0 : 1;
        }
        return validSolutions;
    }

}
