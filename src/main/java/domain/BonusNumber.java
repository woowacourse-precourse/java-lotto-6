package domain;

import exception.IllegalArgumentExceptionMessage;
import exception.NumberFormatExceptionMessage;

public class BonusNumber {
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
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
		if (!(MIN_LOTTO_NUMBER <= bonusNumber && bonusNumber <= MAX_LOTTO_NUMBER)) {
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

