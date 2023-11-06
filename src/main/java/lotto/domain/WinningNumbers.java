package lotto.domain;

import static lotto.config.ErrorMessage.BLANK_WINNING_NUMBERS;

import lotto.util.InputUtil;

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
	}

	public boolean contains(Integer number) {
		return winningNumbers.contains(number);
	}
}