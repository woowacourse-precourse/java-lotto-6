package lotto.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.validation.StringValidation;
import lotto.validation.AmountValidation;
import lotto.validation.WinningValidation;
import lotto.utilities.Parse;
import static lotto.system.SystemMessage.COMMA;

public class InputView {
	public static int askAmount() {
		String amountStr;
		amountStr = getStrInput();
		int amount = getIntAmount(amountStr);
		return amount;
	}
	
	private static String getStrInput() {
		return Console.readLine();
	}
	
	private static int getIntAmount(String str) {
		StringValidation.isStringCorrect(str);
		int amount = Parse.parseStringToInt(str);
		AmountValidation.isAmountCorrect(amount);
		return amount;	
	}
	
	public static List<Integer> askWinning() {
		String winningString;
		winningString = getStrInput();
		String [] winningStringArray = Parse.splitString(winningString, COMMA.getMessage());
		List<Integer> winning = getIntWinning(winningStringArray);
		return winning;
	}
	
	private static List<Integer> getIntWinning(String[] winnings) {
		StringValidation.isStringArrayCorrect(winnings);
		List<Integer> winning = Parse.parseStringToList(winnings);
		WinningValidation.isWinningCorrect(winning);
		return winning;
	}
}