package lotto.domain;

import lotto.util.message.ErrorMessage;

public class Money {
	
	public static final int UNIT = 1000;
	
	private final int money;
	
	public Money(int money) {
		validate(money);
		this.money = money;
	}
	
	private void validate(int money) {
		validateMoneyUnit(money);
	}
	
	private void validateMoneyUnit(int money) {
		if(isNotUnit(money)) {
			throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getForMatMessage(UNIT));
		}
	}
	
	private boolean isNotUnit(int money) {
		return money % UNIT != 0;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getTryCount() {
		return money / UNIT;
	}
}
