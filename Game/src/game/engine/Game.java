package game.engine;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import game.engine.monsters.Monster;

public class Game {
    private Board board; // The game board
    private ArrayList<Monster> allMonsters; // List of all available monsters read from the CSV
    private Monster player; // The player’s monster
    private Monster opponent; // The opponent’s monster
    private Monster current; // The monster whose currently playing the turn. This attribute is READ AND WRITE.

    public Board getBoard() {
        return board;
    }

    public ArrayList<Monster> getAllMonsters() {
        return allMonsters;
    }

    public Monster getPlayer() {
        return player;
    }

    public Monster getOpponent() {
        return opponent;
    }

    public Monster getCurrent() {
        return current;
    }
    public Monster setCurrent(Monster current) {
        this.current = current;
        return current;
    }
}
