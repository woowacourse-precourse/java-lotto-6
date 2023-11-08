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
		return this.money;
	}

	private void validate(String input) {
		//숫자가 아닐 경우
		if(!input.matches("\\d+")){
			throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
		}

		int pay = Integer.parseInt(input);

		//1000으로 나누어 떨어지지 않을 경우
		if (!isDivisibleBy1000(pay)) {
			throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_1000.getMessage());
		}

		//1000보다 적은 값을 입력한 경우
		if (isLessThan1000(pay)) {
			throw new IllegalArgumentException(ErrorMessage.LESS_THAN_1000.getMessage());
		}
	}

	private boolean isDivisibleBy1000(int value) {
		return value % 1000 == 0;
	}

	private boolean isLessThan1000(int value) {
		return value < 1000;
	}
}
