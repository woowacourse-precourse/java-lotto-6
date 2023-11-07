package lotto.domain;

public class WinningLotto {

	private final WinningNumbers winningNumbers;
	private final BonusNumber bonusNumber;

	public WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public WinningNumbers getWinningNumbers() {
		return winningNumbers;
	}

	public BonusNumber getBonusNumber() {
		return bonusNumber;
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