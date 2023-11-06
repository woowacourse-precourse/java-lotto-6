package lotto.domain;

import static lotto.config.ErrorMessage.BLANK_WINNING_NUMBERS;
import static lotto.config.ErrorMessage.INVALID_WINNING_NUMBERS;
import static lotto.config.ErrorMessage.OVERLAPPED_BONUS_NUMBER;

import lotto.util.InputUtil;
import lotto.util.NumberUtil;

public class WinningNumbers {

	private final Lotto winningNumbers;

	public WinningNumbers(String winningNumbers) {
		validate(winningNumbers);

		this.winningNumbers = Lotto.convertToLotto(winningNumbers);
	}

	public Lotto getWinningNumbers() {
		return winningNumbers;
	}

	private void validate(String numbers) {
		if (InputUtil.isBlankOrNull(numbers)) {
			throw new IllegalArgumentException(BLANK_WINNING_NUMBERS.getMessage());
		}

		if (!NumberUtil.isNumericWinningNumbers(numbers)) {
			throw new IllegalArgumentException(INVALID_WINNING_NUMBERS.getMessage());
		}
	}

	public void checkDuplicationBonusNumber(BonusNumber bonusNumber) {
		if (winningNumbers.contains(bonusNumber.getBonusNumber())) {
			throw new IllegalArgumentException(OVERLAPPED_BONUS_NUMBER.getMessage());
		}
	}

	public boolean contains(Integer number) {
		return winningNumbers.contains(number);
	}
}