package airportSecurityState.airportSecurityStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

public class Low_risk implements AirportStateI {

	Context context;

	public Low_risk(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		MyLogger.writeMessage("current state is set the comming state which is as Low risk", DebugLevel.CONSTRUCTOR);
	}

	@Override
	public String same_State() {
		// TODO Auto-generated method stub
		// System.out.println("1 3 5 7 9");
		this.context = context;
		MyLogger.writeMessage("State Changes to Low Risk", DebugLevel.IN_RUN);
		return null;
	}

	@Override
	public String next_State() {
		// TODO Auto-generated method stub
		context.set_riskState(context.getMod()); // put Mod Risk
		return null;
	}

	@Override
	public String prev_State() {
		// TODO Auto-generated method stub
		context.set_riskState(context.getHigh());
		return null;
	}

	public String toString() {
		return "1 3 5 7 9";
	}

}
