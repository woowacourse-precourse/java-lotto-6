package lotto.domain;

import static lotto.config.ErrorMessage.BLANK_WINNING_NUMBERS;
import static lotto.config.ErrorMessage.OVERLAPPED_BONUS_NUMBER;

import java.util.Arrays;
import java.util.List;
import lotto.util.InputUtil;

public class WinningLotto {

	private final Lotto winningNumbers;
	private final BonusNumber bonusNumber;

	public WinningLotto(String winningNumbers, String bonusNumber) {
		validate(winningNumbers);

		this.bonusNumber = new BonusNumber(bonusNumber);
		this.winningNumbers = convertToLotto(winningNumbers);

		checkDuplicationBonusNumber(this.winningNumbers, this.bonusNumber);
	}

	public Lotto getWinningNumbers() {
		return winningNumbers;
	}

	public BonusNumber getBonusNumber() {
		return bonusNumber;
	}

	private void validate(String numbers) {
		if (InputUtil.isBlankOrNull(numbers)) {
			throw new IllegalArgumentException(BLANK_WINNING_NUMBERS.getMessage());
		}
	}

	private void checkDuplicationBonusNumber(Lotto winningNumbers, BonusNumber bonusNumber) {
		if (winningNumbers.getNumbers().contains(bonusNumber.getBonusNumber())) {
			throw new IllegalArgumentException(OVERLAPPED_BONUS_NUMBER.getMessage());
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