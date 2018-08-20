package airportSecurityState.airportSecurityStates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Helper {
	static ArrayList<Integer> alDays = new ArrayList<>();
	static Set<Integer> uniqueDays = null;

	static String str = "";

	static int tot_travellers = 0;
	static int tot_pro_item = 0;
	static int tot_days = 0;

	static float avgTrafficPD;
	static float avgProPD;

	static final int LOW_RISK = 1;
	static final int MODERATE_RISK = 2;
	static final int HIGH_RISK = 3;

	static int state = 0;

	public int tightenOrLoosen(String str) {
		tot_travellers++;
		for (String retval : str.split(";")) {
//			System.out.print(retval + " ");

			String[] parts = retval.split(":");
			if (parts[0].equals("Day")) {
				alDays.add(Integer.parseInt(parts[1]));
				uniqueDays = new HashSet<Integer>(alDays);
			}
			if (parts[0].equals("Item")) {
				if (parts[1].equals("Gun") || parts[1].equals("NailCutter") || parts[1].equals("Blade")
						|| parts[1].equals("Knife")) {
					tot_pro_item = tot_pro_item + 1;
				}
			}
		}
		tot_days = uniqueDays.size();
		avgTrafficPD = (float) tot_travellers / tot_days;
		avgProPD = (float) tot_pro_item / tot_days;

		try {
			if ((0 <= avgTrafficPD && avgTrafficPD < 4) || (0 <= avgProPD && avgProPD < 1)) {
				state = LOW_RISK;
			}

			if ((4 <= avgTrafficPD && avgTrafficPD < 8) || (1 <= avgProPD && avgProPD < 2)) {
				state = MODERATE_RISK;
			}

			if ((8 <= avgTrafficPD) || (2 <= avgProPD)) {
				state = HIGH_RISK;
			}

			return state;
		} catch (Exception e) {

		}

		finally {
//			System.out.println("\ntraf		items		days	    State -> \n" + "" + tot_travellers + "		"
//					+ tot_pro_item + "		" + tot_days + "		" + state);

			state = 0;
			avgProPD = 0;
			avgTrafficPD = 0;

		}

		return 0;
	}

}
