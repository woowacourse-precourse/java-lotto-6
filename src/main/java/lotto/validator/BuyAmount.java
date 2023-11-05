package lotto.validator;

import static lotto.constants.MessageConstants.NO_NUMBER;
import static lotto.constants.MessageConstants.NO_THOUSAND_UNITS;
import static lotto.constants.MessageConstants.YES_BLANK;
import static lotto.constants.MessageConstants.YES_EMPTY;;

public class BuyAmount {

	public static void validate(String buyAmount) {
		checkNull(buyAmount);
		checkBlank(buyAmount);
		checkOutOfNumber(buyAmount);

	}

	private static void checkNull(String buyAmount) {
		if (buyAmount.isEmpty()) {
			throw new IllegalArgumentException(YES_EMPTY);
		}

	}

	private static void checkBlank(String buyAmount) {
		if (buyAmount.isBlank()) {
			throw new IllegalArgumentException(YES_BLANK);
		}

	}

	private static void checkOutOfNumber(String buyAmount) {
		try {
			int purchaseAmount = Integer.parseInt(buyAmount);
			if (purchaseAmount % 1000 != 0 || purchaseAmount == 0) {
				throw new IllegalArgumentException(NO_THOUSAND_UNITS);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(NO_NUMBER);

		}

	}

}
