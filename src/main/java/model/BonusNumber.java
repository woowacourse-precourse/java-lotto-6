package model;

import validators.InputException;

public class BonusNumber {

	private int bonusNumber;
	
	public BonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}
	
	public static int changeToNumber(String bonusNumberText) {
		bonusNumberText = bonusNumberText.trim();
		InputException.checkNumber(bonusNumberText);
		
		return Integer.valueOf(bonusNumberText);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
