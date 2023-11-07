//Money.java
package lotto;

import lotto.Constant.LottoInfo;
import lotto.Enum.ErrorMessage;

public class Money {
	private int money;

	public Money(String input){
		validate(input);
		this.money = Integer.parseInt(input);
	}

	public int calculateAffordableLottoCount(){
		return money / LottoInfo.getPRICE();
	}

	public int getMoney(){
		return money;
	}

	private int validate(String input) {
		if(!input.matches("\\d+")){
			System.out.println("Hey1");
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
		}
		int pay = Integer.parseInt(input);

		if (!isPositiveInteger(pay)) {
			System.out.println("Hey2");
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
