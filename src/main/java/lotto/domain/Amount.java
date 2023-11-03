package lotto.domain;

public class Amount {
	private int amount;
	private int availableQuantity;
	
	public Amount() {
		amount=0;
		availableQuantity=0;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getAvailableQuantity() {
		return this.availableQuantity;
	}
}