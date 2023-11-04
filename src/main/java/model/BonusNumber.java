package model;

import validators.InputException;

public class BonusNumber {

	private int bonusNumber;
	
	public BonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	public static void validateBonusNumber(String bonusNumberText) throws IllegalArgumentException {
		InputException.checkNull(bonusNumberText);
		InputException.checkNumber(bonusNumberText);
	}
	
	public static int changeToNumber(String bonusNumberText) {
		return Integer.valueOf(bonusNumberText);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
