package validators;

import enums.Error;

public class InputException {

	public static void checkNumber(String buyAmountText) {
		if(!buyAmountText.matches("[0-9]+")) {
			throw new IllegalArgumentException(Error.WRONG_VALUE.getMessage());
		}
	}

	public static void checkRightAmount(int buyAmount, int lottoPrice) {
		int rest = buyAmount%lottoPrice;
		if(rest != 0) {
			throw new IllegalArgumentException(Error.WRONG_AMOUNT.getMessage());
		}
	}

}
