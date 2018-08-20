package airportSecurityState.airportSecurityStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;

public class Context implements AirportStateI {

	AirportStateI lowRisk;
	AirportStateI modRisk;
	AirportStateI highRisk;
	private AirportStateI state = lowRisk;

	public Context() {
		// TODO Auto-generated constructor stub
		lowRisk = new Low_risk(this);
		modRisk = new Mod_risk(this);
		highRisk = new High_risk(this);
		state = lowRisk;
		MyLogger.writeMessage("Initial State set to low risk as no traveller entered to airport", DebugLevel.CONSTRUCTOR);

		// ---------
	}

	public void set_riskState(AirportStateI state) {
		this.state = state;
	}

	public AirportStateI get_riskState() {
		return state;
	}

	public AirportStateI getLow() {
		return lowRisk;
	}

	public AirportStateI getMod() {
		return modRisk;
	}

	public AirportStateI getHigh() {
		return highRisk;
	}

	@Override
	public String same_State() {
		// TODO Auto-generated method stub
		state.same_State();
		return null;
	}

	@Override
	public String next_State() {
		// TODO Auto-generated method stub
		state.next_State();
		// state.same_State();
		return null;
	}

	@Override
	public String prev_State() {
		// TODO Auto-generated method stub
		state.prev_State();
		// state.same_State();
		return null;
	}

	public String toString() {
		return state.toString();
	}

}
