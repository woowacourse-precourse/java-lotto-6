package lotto.domain;

import lotto.util.message.ErrorMessage;

public class BonusNumber {

	private final int bonusNumber;

	public BonusNumber(Lotto answerLottoNumbers, int bonusNumber) {
		validateBonusNumber(answerLottoNumbers, bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	private void validateBonusNumber(Lotto answerLottoNumbers, int bonusNumber) {
		validateDuplicateBonusNumber(answerLottoNumbers, bonusNumber);
		validateBonusNumberOutOfRange(bonusNumber);
	}

	private void validateDuplicateBonusNumber(Lotto answerLottoNumbers, int bonusNumber) {
		if (answerLottoNumbers.getLottoNumbers().contains(bonusNumber)) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
		}
	}

	private void validateBonusNumberOutOfRange(int bonusNumber) {
		if (isNumberOutOfRange(bonusNumber)) {
			throw new IllegalArgumentException(
					ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getFormattedMessage(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER));
		}
	}

	private boolean isNumberOutOfRange(int number) {
		return number > Lotto.MAX_NUMBER || number < Lotto.MIN_NUMBER;
	}
	
	public int getBonusNumber() {
		return bonusNumber;
	}
}