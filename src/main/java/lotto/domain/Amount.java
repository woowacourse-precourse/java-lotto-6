package lotto.domain;

import lotto.validation.AmountValidation;

public class Amount {
	private final int amount;
	
	public Amount(int amount) {
		amountValidation(amount);
		this.amount=amount;
	}
	
	public void amountValidation(int amount) {
		AmountValidation.isAmountCorrect(amount);
	}
	
	public int getAvailableQuantity() {
		return amount/1000;
	}
}