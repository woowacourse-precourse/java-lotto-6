package lotto.model;

import lotto.validator.Validator;

public class BonusNumber {
	
	private int number;
	private final Validator validator = new Validator();
	
	public BonusNumber(String number) {
		this.number = Integer.parseInt(number);
	}
	
	public int getBonusNumber() {
		return this.number;
	}
	
	private void validator(int number) {
		
	}
}
