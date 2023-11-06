package lotto.controller;

public class CheckValidateInput {
	
	public int money(String money) {
		
		if(!isInteger(money))
			throw new IllegalArgumentException();
		if(!isUnits1000(Integer.parseInt(money)))
			throw new IllegalArgumentException();
		if(!inRange(Integer.parseInt(money)))
			throw new IllegalArgumentException();

		return Integer.parseInt(money);
	}

	private boolean isInteger(String money) {
		try {
			Integer.parseInt(money);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
	private boolean isUnits1000(int money) {
		return (money%1000) == 0;	
	}
	
	private boolean inRange(int money) {
		return (money>0) && (money<Integer.MAX_VALUE);
	}


}
