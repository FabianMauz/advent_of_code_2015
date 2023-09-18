package fmauz.day_21;

import fmauz.advent_of_code_2015.day_21.Character;
import fmauz.advent_of_code_2015.day_21.Game;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fmauz
 */
public class Day21Test {

    @Test
    public void example_from_riddle() {
        Character player = new Character(8, 5, 5);
        Character enemy = new Character(12, 7, 2);
        Game game = new Game(player, enemy);
        game.simulateBattle();

        assertTrue(game.isPlayerWinner());
    }
    @Test
    public void player_should_win() {
        Character enemy = new Character(10, 2, 3);
        Character player = new Character(10, 2, 3);
        Game game = new Game(player, enemy);
        game.simulateBattle();

        assertTrue(game.isPlayerWinner());
    }

    @Test
    public void enemy_should_win() {
        Character enemy = new Character(20, 2, 3);
        Character player = new Character(10, 2, 3);
        Game game = new Game(player, enemy);
        game.simulateBattle();

        assertFalse(game.isPlayerWinner());
    }
}
