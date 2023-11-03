package lotto.dto;

import lotto.domain.Amount;

public class AmountDto {
	Amount amount;
	
	public AmountDto() {
		amount = new Amount();
	}
	
	public void setAmount(int amount) {
		this.amount.setAmount(amount);
	}
	
	public int getAvailableQuantity() {
		return amount.getAvailableQuantity();
	}
}