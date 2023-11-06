package lotto.domain;

import static lotto.config.ErrorMessage.OVERLAPPED_BONUS_NUMBER;

public class WinningLotto {

	private final WinningNumbers winningNumbers;
	private final BonusNumber bonusNumber;

	public WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {

		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;

		checkDuplicationBonusNumber(this.winningNumbers, this.bonusNumber);
	}

	public WinningNumbers getWinningNumbers() {
		return winningNumbers;
	}

	public BonusNumber getBonusNumber() {
		return bonusNumber;
	}

	private void checkDuplicationBonusNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
		if (winningNumbers.contains(bonusNumber.getBonusNumber())) {
			throw new IllegalArgumentException(OVERLAPPED_BONUS_NUMBER.getMessage());
		}
	}

	public int calculateMatchCount(Lotto lotto) {
		return (int) lotto.getNumbers().stream()
			.filter(winningNumbers::contains)
			.count();
	}

	public boolean isBonusMatch(Lotto lotto) {
		return lotto.contains(bonusNumber.getBonusNumber());
	}
}