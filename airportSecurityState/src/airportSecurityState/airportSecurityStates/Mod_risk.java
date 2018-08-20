package airportSecurityState.airportSecurityStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

public class Mod_risk implements AirportStateI {

	Context context;

	public Mod_risk(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		MyLogger.writeMessage("current state is set the comming state which is as Mod risk", DebugLevel.CONSTRUCTOR);

	}

	@Override
	public String same_State() {
		// TODO Auto-generated method stub
		// System.out.println("2 3 5 8 9");
		// this.context=context;
		context.set_riskState(context.getLow());

		return null;
	}

	@Override
	public String next_State() {
		// TODO Auto-generated method stub

		// System.out.println("2 3 5 8 9");
		this.context = context;
		MyLogger.writeMessage("State Changes to Moderate Risk", DebugLevel.IN_RUN);

		// context.set_riskState(context.getHigh());
		return null;
	}

	@Override
	public String prev_State() {
		// TODO Auto-generated method stub
		context.set_riskState(context.getHigh());
		return null;
	}

	public String toString() {
		return "2 3 5 8 9";
	}

}
