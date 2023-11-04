package lotto.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.validation.StringValidation;
import lotto.utilities.Parse;
import static lotto.system.SystemMessage.COMMA;

public class InputView {
	public static int askAmount() {
		String amountStr = getStrInput();
		StringValidation.isStringCorrect(amountStr);
		int amount = getIntAmount(amountStr);
		return amount;
	}
	
	private static String getStrInput() {
		return Console.readLine();
	}
	
	private static int getIntAmount(String amountString) {
		return Parse.parseStringToInt(amountString);
	}
	
	public static List<Integer> askWinning() {
		String winningString = getStrInput();
		String [] winningStringArray = Parse.splitString(winningString, COMMA.getMessage());
		StringValidation.isStringArrayCorrect(winningStringArray);
		List<Integer> winning = getIntWinning(winningStringArray);
		return winning;
	}
	
	private static List<Integer> getIntWinning(String[] winnings) {
		return Parse.parseStringToIntArray(winnings);
	}
	
	public static int askBonus() {
		String bonusString = getStrInput();
		StringValidation.isStringCorrect(bonusString);
		int bonus = getIntBonus(bonusString);
		return bonus;
	}
	
	private static int getIntBonus(String bonusString) {
		StringValidation.isStringCorrect(bonusString);
		int bonus = Parse.parseStringToInt(bonusString);
		return bonus;
	}
}