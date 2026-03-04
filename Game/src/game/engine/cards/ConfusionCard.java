package game.engine.cards;
class ConfusionCard extends Card {
	private int duration;
	ConfusionCard(String name, String description, int rarity, int duration){
		super(name, description, rarity,false);
		this.duration=duration;
	}
	public int getDuration() {
		return duration;
	}
	
}
