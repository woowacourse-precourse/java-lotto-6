package model;

import validators.InputException;

public class BonusNumber {

	private int bonusNumber;
	
	public BonusNumber(String bonusNumberText, Lotto lotto) throws IllegalArgumentException {
		InputException.checkNull(bonusNumberText);
		int bonusNumber = changeNumber(bonusNumberText);
		InputException.checkBonusNumberOverlap(bonusNumber, lotto.getNumbers());
		
		this.bonusNumber = bonusNumber;
	}
	
	public int getBonusNumber() {
		return bonusNumber;
	}
	
	private int changeNumber(String bonusNumberText) {
		InputException.checkNumber(bonusNumberText.trim());
		int bonusNumber = Integer.valueOf(bonusNumberText);
		
		return bonusNumber;
	}
}
