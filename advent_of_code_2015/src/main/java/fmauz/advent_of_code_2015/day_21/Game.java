package fmauz.advent_of_code_2015.day_21;

/**
 *
 * @author fmauz
 */
public class Game {

    private final Character player;
    private final Character enemy;
    private boolean playerTurn = true;
    private int round = 0;
    private boolean logging=false;

    public Game(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public Game simulateBattle() {
        while (!isBattleOver()) {
            doNextTurn();
        }
        return this;
    }

    public boolean isPlayerWinner() {
        return player.getLife() > 0;
    }

    private boolean isBattleOver() {
        return player.getLife() <= 0 || enemy.getLife() <= 0;
    }

    private void doNextTurn() {
        round++;
        if (playerTurn) {
            doPlayerAttack();
        } else {
            doEnemyAttack();
        }
        playerTurn = !playerTurn;
    }

    private void doPlayerAttack() {
        enemy.recieveDamage(player.getAttack());
    }

    private void doEnemyAttack() {
     //   System.out.println("Player");
        player.recieveDamage(enemy.getAttack());
    }

    public int getRound() {
        return round;
    }

}
