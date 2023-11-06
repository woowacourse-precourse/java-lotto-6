package lotto.domain;

import static lotto.config.ErrorMessage.BLANK_BONUS_NUMBER;
import static lotto.config.ErrorMessage.INVALID_LOTTO_NUMBER;

import lotto.util.InputUtil;
import lotto.util.NumberUtil;

public class BonusNumber {

	private final int bonusNumber;

	public BonusNumber(String bonusNumber) {
		validate(bonusNumber);

		this.bonusNumber = convertToBonusNumber(bonusNumber);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	private void validate(String number) {
		if (InputUtil.isBlankOrNull(number)) {
			throw new IllegalArgumentException(BLANK_BONUS_NUMBER.getMessage());
		}

		if (!NumberUtil.isNumericBonusNumber(number)) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
		}

		if (!NumberUtil.isLottoNumberRange(convertToBonusNumber(number))) {
			throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
		}
	}

	private int convertToBonusNumber(String number) {
		return Integer.parseInt(number);
	}
}