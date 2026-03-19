package game.engine;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException ;
import game.engine.dataloader.DataLoader;
import game.engine.monsters.Monster;

public class Game {
    private Board board; // The game board
    private ArrayList<Monster> allMonsters; // List of all available monsters read from the CSV
    private Monster player; // The player’s monster
    private Monster opponent; // The opponent’s monster
    private Monster current; // The monster whose currently playing the turn. This attribute is READ AND WRITE.

    public Game (Role playerRole)throws IOException{
    	board = new Board (DataLoader.readCards());
    	allMonsters = DataLoader.readMonsters();
    	player = selectRandomMonsterByRole(playerRole);
    	if (playerRole==Role.SCARER){
    		opponent = selectRandomMonsterByRole(Role.LAUGHER);
    	}
    	else {
    		opponent = selectRandomMonsterByRole(Role.SCARER);
    	}
    	current = player ;
    	
    	
    }
    
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
    public void setCurrent(Monster current) {
        this.current = current;
    }
    private Monster selectRandomMonsterByRole(Role role){
    	ArrayList<Monster> temp = new ArrayList<Monster>();
    	for (int i = 0 ;i<allMonsters.size();i++){
    		if(allMonsters.get(i).getRole()==role){
    			temp.add(allMonsters.get(i));
    		}
    	}
    	int randomNum = (int)(Math.random()*(temp.size()));
    	return temp.get(randomNum);
    }
   
    
}
