package lotto.domain;

public class Amount {
	private final int amount;
	
	public Amount(int amount) {
		this.amount=amount;
	}
	
	public int getAvailableQuantity() {
		return amount/1000;
	}
}