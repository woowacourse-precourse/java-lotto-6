package lotto.readInput;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorValidation;

public class InputPurchase {
	public static int purchaseAmount() {
		
		String input = Console.readLine();
		try {
			ErrorValidation.validatePurchaseAmount(input);
			return Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return purchaseAmount();
		}
	}
}
