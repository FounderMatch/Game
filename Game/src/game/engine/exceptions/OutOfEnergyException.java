package game.engine.exceptions;

public class OutOfEnergyException extends GameActionException {
	private static final String MSG = "Not Enough Energy for Power up";
	public OutOfEnergyException(){
		super(MSG);
	}
	public OutOfEnergyException(String message){
		super(message);
	}

}
