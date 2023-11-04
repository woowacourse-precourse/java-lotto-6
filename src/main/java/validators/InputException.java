package validators;

import enums.Error;

public class InputException {

	public static void checkNumber(String buyAmountText) {
		if(!buyAmountText.matches("[0-9]+")) {
			throw new IllegalArgumentException(Error.WRONG_VALUE.getMessage());
		}
	}

	public static void checkRightAmount(int buyAmount) {
		int rest = buyAmount%1000;
		if(rest != 0) {
			throw new IllegalArgumentException(Error.WRONG_AMOUNT.getMessage());
		}
	}

}
