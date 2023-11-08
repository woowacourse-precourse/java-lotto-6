package lotto.readInput;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorValidation;

public class InputPurchase {
	public static int purchaseAmount() {
		String input = read();
		try {
			ErrorValidation.validatePurchase(input);
			return Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			printErrorMessage(e.getMessage());
			return purchaseAmount();
		}
	}

	public static String read() {
		return Console.readLine();
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}
}
