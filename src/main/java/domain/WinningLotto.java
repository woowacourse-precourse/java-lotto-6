package domain;

public class WinningLotto {
	private final Lotto winningLotto;
	private final BonusNumber bonusNumber;

	public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
		this.winningLotto = winningLotto;
		this.bonusNumber = bonusNumber;
	}

	public Lotto getWinningLotto() {
		return winningLotto;
	}

	public BonusNumber getBonusNumber() {
		return bonusNumber;
	}
}
