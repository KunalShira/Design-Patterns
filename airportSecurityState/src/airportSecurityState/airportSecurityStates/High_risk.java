package airportSecurityState.airportSecurityStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

public class High_risk implements AirportStateI {

	Context context;

	public High_risk(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		MyLogger.writeMessage("current state is set the comming state which is as High risk", DebugLevel.CONSTRUCTOR);
	}

	@Override
	public String same_State() {
		// TODO Auto-generated method stub

		context.set_riskState(context.getLow());
		return null;
	}

	@Override
	public String next_State() {
		// TODO Auto-generated method stub
		context.set_riskState(context.getMod());
		return null;
	}

	@Override
	public String prev_State() {
		// TODO Auto-generated method stub
		// System.out.println("2 4 6 8 10");
		this.context = context;
		
		// context.set_riskState(context.getMod());
		MyLogger.writeMessage("State Changes to High Risk", DebugLevel.IN_RUN);

		return null;
	}

	public String toString() {
		return "2 4 6 8 10";
	}

}
