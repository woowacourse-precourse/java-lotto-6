package domain;

import exception.IllegalArgumentExceptionMessage;
import exception.NumberFormatExceptionMessage;

public class BonusNumber {
	private final int bonusNumber;

	public BonusNumber(String bonusNumber, Lotto lotto) {
		validateIsDigit(bonusNumber);
		int convertedBonusNumber = convertStringToInt(bonusNumber);
		validateIsBetweenLottoRange(convertedBonusNumber);
		validateWinningLottoNumberDuplicate(convertedBonusNumber, lotto);
		this.bonusNumber = convertedBonusNumber;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	private int convertStringToInt(String bonusNumber) {
		return Integer.parseInt(bonusNumber);
	}

	private void validateIsDigit(String bonusNumber) {
		if (!isDigit(bonusNumber)) {
			NumberFormatExceptionMessage.NUMBERS_ONLY.throwException();
		}
	}

	private void validateIsBetweenLottoRange(int bonusNumber) {
		if (!(1 <= bonusNumber && bonusNumber <= 45)) {
			IllegalArgumentExceptionMessage.BONUS_OUT_OF_RANGE.throwException();
		}
	}

	private boolean isDigit(String bonusNumber) {
		return bonusNumber.chars()
				.allMatch(Character::isDigit);
	}

	private void validateWinningLottoNumberDuplicate(int bonusNumber, Lotto lotto) {
		if (!isWinningLottoNumberDuplicate(bonusNumber, lotto)) {
			IllegalArgumentExceptionMessage.BONUS_NUMBER_DUPLICATE.throwException();
		}
	}

	private boolean isWinningLottoNumberDuplicate(int bonusNumber, Lotto lotto) {
		return lotto.getNumbers()
				.stream()
				.noneMatch(number -> number == bonusNumber);
	}

}

