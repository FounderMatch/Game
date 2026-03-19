package game.engine.monsters;

import game.engine.Role;

public class MultiTasker extends Monster {
	private int normalSpeedTurns ;

	public int getNormalSpeedTurns() {
		return normalSpeedTurns;
	}

	public void setNormalSpeedTurns(int normalSpeedTurns) {
		if (normalSpeedTurns>=0)
		this.normalSpeedTurns = normalSpeedTurns;
	}

	public MultiTasker(String name, String description, Role role,
			int energy) {
		super(name, description, role, energy);
		normalSpeedTurns = 0 ;
	}
	
	

}
