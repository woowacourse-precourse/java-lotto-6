package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.CommonValidation;
import lotto.validation.AmountValidation;
import lotto.utilities.Parse;

public class InputView {
	public static int askAmount() {
		String amountStr;
		amountStr = getStrInput();
		int amount = getIntInput(amountStr);
		return amount;
	}
	
	private static String getStrInput() {
		return Console.readLine();
	}
	
	private static int getIntInput(String str) {
		CommonValidation.isCommonCorrect(str);
		int amount = Parse.parseStringToInt(str);
		AmountValidation.isAmountCorrect(amount);
		return amount;	
	}
}