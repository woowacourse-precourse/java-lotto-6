package lotto;

import lotto.enums.LottoError;

public class BonusNumber {
	private final Integer bonusNumber;

	public BonusNumber(Integer bonusNumber, Lotto lotto) {
		validateRange(bonusNumber);
		validateNotInLotto(bonusNumber, lotto);
		this.bonusNumber = bonusNumber;
	}

	private void validateRange(Integer bonusNumber) {
		if (bonusNumber < 1 || bonusNumber > 45) {
			throw new IllegalArgumentException(LottoError.INVALID_RANGE_INPUT.getErrorDescription());
		}
	}

	private void validateNotInLotto(Integer bonusNumber, Lotto lotto) {
		if (lotto.getNumbers().contains(bonusNumber)) {
			throw new IllegalArgumentException(LottoError.INVALID_BONUS_NUMBER.getErrorDescription());
		}
	}

	public Integer getBonusNumber() {
		return this.bonusNumber;
	}

}

