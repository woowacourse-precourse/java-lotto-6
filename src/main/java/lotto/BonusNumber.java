//BonusNumber.java
package lotto;

import lotto.Enum.ErrorMessage;

public class BonusNumber {
	Integer bonusNumber;

	public BonusNumber(String input, WinningNumbers winningNumbers){
		validate(input, winningNumbers);
		this.bonusNumber = Integer.parseInt(input);
	}

	public boolean checkIsMatch(Lotto lotto){
		return lotto.have(bonusNumber);
	}

	private void validate(String input, WinningNumbers winningNumbers) {
		int number = Integer.parseInt(input);
		validateIsNumber(input);
		validateNumberRange(number);
		validateNotDuplicate(number, winningNumbers);
	}

	private void validateIsNumber(String input) {
		if (!input.matches("^[0-9]+$")) {
			throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_NUMBER.getMessage());
		}
	}

	private void validateNumberRange(int number) {
		if (number < 1 || number > 45) {
			throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.getMessage());
		}
	}

	private void validateNotDuplicate(int number, WinningNumbers winningNumbers) {
		if (winningNumbers.have(number)) {
			throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_NUMBER.getMessage());
		}
	}

}
