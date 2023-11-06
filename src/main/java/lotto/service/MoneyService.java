package lotto.service;

import lotto.domain.Money;

public class MoneyService {

	public Money createMoney(int inputValue) {
		return new Money(inputValue);
	}
}