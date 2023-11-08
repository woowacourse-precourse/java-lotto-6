package lotto.service;

import lotto.domain.Money;

public class MoneyService {

	public Money createMoney(int inputedMoney) {
		return new Money(inputedMoney);
	}
}