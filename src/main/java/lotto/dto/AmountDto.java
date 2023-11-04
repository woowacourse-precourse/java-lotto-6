package lotto.dto;

import lotto.domain.Amount;

public class AmountDto {
	Amount amount;
	
	public AmountDto(int amount) {
		this.amount = new Amount(amount);
	}
	
	public int getAvailableQuantity() {
		return amount.getAvailableQuantity();
	}
	
	public int getAmount() {
		return amount.getAmount();
	}
}