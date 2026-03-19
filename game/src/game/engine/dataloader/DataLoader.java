package game.engine.dataloader;
import java.io.BufferedReader;
import game.engine.Role;
import game.engine.cards.*;
import game.engine.cells.*;
import game.engine.monsters.*;
import java.io.IOException ;
import java.util.*;
import java.io.FileReader;


public class DataLoader {
    private static final String CARDS_FILE_NAME = "cards.csv" ; //A String containing the name of the card’s csv file.
    private static final String CELLS_FILE_NAME="cells.csv"; //A String containing the name of the cell’s csv file.
    private static final String MONSTERS_FILE_NAME ="monsters.csv"; //A String containing the name of the monster’s csv file.
    
    //general method that reads any file
    public static ArrayList<String> readFile(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> lines = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        reader.close();
        return lines;
    }
    public static ArrayList<Card> readCards() throws IOException {
    	ArrayList<String> cardsfile = readFile(CARDS_FILE_NAME);
    	String [] arr1 = new String [5];
    	ArrayList<Card> cardOut = new ArrayList<Card>();
    	for(int i =0 ; i<cardsfile.size();i++){
    		String temp = cardsfile.get(i);
    		arr1 = temp.split(",");
    		Card c ;
    		switch (arr1[0]){
    		case "SWAPPER":
    			c = new SwapperCard(arr1[1],arr1[2],Integer.parseInt(arr1[3]));
    			cardOut.add(c);
    			break ;
    		case "SHIELD":
    			c = new ShieldCard(arr1[1],arr1[2],Integer.parseInt(arr1[3]));
    			cardOut.add(c);
    			break ;
    		case "ENERGYSTEAL":
    			c = new EnergyStealCard(arr1[1],arr1[2],Integer.parseInt(arr1[3]),Integer.parseInt(arr1[4]));
    			cardOut.add(c);
    			break;
    		case "STARTOVER":
    			c = new StartOverCard(arr1[1],arr1[2],Integer.parseInt(arr1[3]),Boolean.parseBoolean(arr1[4]));
    			cardOut.add(c);
    			break;
    		case "CONFUSION" :
    			c = new ConfusionCard(arr1[1],arr1[2],Integer.parseInt(arr1[3]),Integer.parseInt(arr1[4]));
    			cardOut.add(c);
    			break;
    		}
    	}
    	return cardOut;    
    }
    public static ArrayList<Cell> readCells() throws IOException {
    	ArrayList<String> cellsFile = readFile(CELLS_FILE_NAME);
    	String [] arr1 = new String [3];
    	ArrayList<Cell> cellOut = new ArrayList<Cell>();
    	for(int i =0 ; i<cellsFile.size();i++){
    		String temp = cellsFile.get(i);
    		arr1 = temp.split(",");
    		Cell c ;
    		if(arr1[2]!=null){
    			Role myrole = Role.valueOf(arr1[1]);
    			c = new DoorCell(arr1[0],myrole,Integer.parseInt(arr1[2]));
    			cellOut.add(c);
    		}
    		else {
    			if (Integer.parseInt(arr1[1])>0){
    				c = new ConveyorBelt(arr1[0],Integer.parseInt(arr1[1]));
    				cellOut.add(c);
    			}
    			else {
    				c = new ContaminationSock(arr1[0],Integer.parseInt(arr1[1]));
    				cellOut.add(c);
    			}
    				
    		}
    	}
    	return cellOut ;
    }
    public static ArrayList<Monster> readMonsters() throws IOException {
    	ArrayList<String> monstersFile = readFile(MONSTERS_FILE_NAME);
    	String [] arr1 = new String [5];
    	ArrayList<Monster> monsterOut = new ArrayList<Monster>();
    	for(int i =0 ; i<monstersFile.size();i++){
    		String temp = monstersFile.get(i);
    		arr1 = temp.split(",");
    		Monster m ;
    		Role myrole = Role.valueOf(arr1[3]) ;
    		switch (arr1[0]){
    		case "DYNAMO":
    			m = new Dynamo (arr1[1],arr1[2],myrole,Integer.parseInt(arr1[4]));
    			monsterOut.add(m);
    			break;
    		case "DASHER":
    			m = new Dasher (arr1[1],arr1[2],myrole,Integer.parseInt(arr1[4]));
    			monsterOut.add(m);
    			break;
    			
    		case "SCHEMER":
    			m = new Schemer (arr1[1],arr1[2],myrole,Integer.parseInt(arr1[4]));
    			monsterOut.add(m);
    			break;
    		case "MULTITASKER":
    			m = new MultiTasker (arr1[1],arr1[2],myrole,Integer.parseInt(arr1[4]));
    			monsterOut.add(m);
    			break;
    		}
    	
    }
    	return monsterOut ;
}
}
