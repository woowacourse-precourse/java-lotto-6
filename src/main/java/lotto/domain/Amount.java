package lotto.domain;

public class Amount {
	private int amount;
	
	public Amount() {
		this.amount=0;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getAvailableQuantity() {
		return amount/1000;
	}
}