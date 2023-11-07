//Money.java
package lotto;

import lotto.Constant.LottoInfo;
import lotto.Enum.ErrorMessage;

public class Money {
	private final int money;

	public Money(String input){
		validate(input);
		this.money = Integer.parseInt(input);
	}

	private int validate(String input) {
		if (!input.matches("\\d+")) {
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
		}

		int pay = Integer.parseInt(input);

		if (pay % 1000 != 0) {
			throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_1000.getMessage());
		}

		if (pay < 1000) {
			throw new IllegalArgumentException(ErrorMessage.LESS_THAN_1000.getMessage());
		}

		return pay;
	}

	public int calculateAffordableLottoCount(){
		return money / LottoInfo.getPRICE();
	}

	public int getMoney(){
		return money;
	}
}
