//Money.java
package lotto;

import lotto.Constant.LottoInfo;
import lotto.Enum.ErrorMessage;

public class Money {
	private final int money;

	public Money(String input){
		this.money = validateAndParse(input);
	}

	public int calculateAffordableLottoCount(){
		return money / LottoInfo.getPRICE();
	}

	public int getMoney(){
		return money;
	}

	private int validateAndParse(String input) {
		int pay = parseInputToInteger(input);

		if (!isPositiveInteger(pay)) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
		}

		if (!isDivisibleBy1000(pay)) {
			throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_1000.getMessage());
		}

		if (isLessThan1000(pay)) {
			throw new IllegalArgumentException(ErrorMessage.LESS_THAN_1000.getMessage());
		}

		return pay;
	}

	private int parseInputToInteger(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
		}
	}

	private boolean isPositiveInteger(int value) {
		return value > 0;
	}

	private boolean isDivisibleBy1000(int value) {
		return value % 1000 == 0;
	}

	private boolean isLessThan1000(int value) {
		return value < 1000;
	}
}
