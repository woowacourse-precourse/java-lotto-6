package lotto.model;

public class Money { // 금액
	
	private final int money;
	
	public Money(String inputMoney) {
		int amount = Integer.parseInt(inputMoney);
		this.money	= amount; 
	}
	
	public int getMoney() {
		return this.money;
	}
}
