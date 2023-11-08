package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ErrorCode;

public class Input {

	public static int readPurchaseAmount() {
		while (true) {
			try {
				return validate(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static int validate(String value) {
		int amount;
		while (true) {
			try {
				amount = Integer.parseInt(value);
				if((amount % 1000) != 0) {
					throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT.message());
				}
				return amount;
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_VALUE.message());
			}
		}
	}

}
