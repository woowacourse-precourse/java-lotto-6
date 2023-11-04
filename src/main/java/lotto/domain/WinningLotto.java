package lotto.domain;

import static lotto.config.ErrorMessage.BLANK_WINNING_NUMBERS;

import java.util.Arrays;
import java.util.List;
import lotto.util.InputUtil;

public class WinningLotto {

	private final Lotto winningNumbers;

	public WinningLotto(String winningNumbers) {
		validate(winningNumbers);

		this.winningNumbers = convertToLotto(winningNumbers);
	}

	public Lotto getWinningNumbers() {
		return winningNumbers;
	}

	private void validate(String numbers) {
		if (InputUtil.isBlankOrNull(numbers)) {
			throw new IllegalArgumentException(BLANK_WINNING_NUMBERS.getMessage());
		}
	}

	private Lotto convertToLotto(String numbers) {
		List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.toList();

		return new Lotto(winningNumbers);
	}
}