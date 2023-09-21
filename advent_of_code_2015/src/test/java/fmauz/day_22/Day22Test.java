package fmauz.day_22;

import fmauz.advent_of_code_2015.day_22.Game;
import fmauz.advent_of_code_2015.day_22.Player;
import fmauz.advent_of_code_2015.day_22.SpellBundle;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import fmauz.advent_of_code_2015.day_22.Character;
import fmauz.advent_of_code_2015.day_22.SpellBook;
import fmauz.advent_of_code_2015.day_22.SpellBundleCreator;
import java.util.List;

/**
 *
 * @author fmauz
 */
public class Day22Test {

    @Test
    public void example_1_from_riddle() {
        SpellBundle bundle = new SpellBundle();
        SpellBook book = new SpellBook();

        bundle.addSpell(book.getSpell(SpellBook.SpellType.POISON));
        bundle.addSpell(book.getSpell(SpellBook.SpellType.MAGIC_MISSILE));

        Player player = new Player(10, 250, bundle);
        Character enemy = new fmauz.advent_of_code_2015.day_22.Character(13, 8);

        Game game = new Game(player, enemy);
        game.setPrintOutput(true);
        game.simulateBattle();

        assertTrue(game.isPlayerWinner());
    }

    @Test
    public void createBundles() {
        SpellBook book = new SpellBook();
        SpellBundleCreator bundleCreator = new SpellBundleCreator(book);
        List<SpellBundle> bundles = bundleCreator.createBundleWithSpells(7, 0);
        for (SpellBundle bundle : bundles) {
            //System.out.println(bundle.getSpellNames());
        }
        System.out.println(bundles.size());
    }
}
