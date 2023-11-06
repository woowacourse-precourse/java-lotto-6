package domain;

public class WinningLotto {
	private final Lotto winningLotto;
	private final BonusNumber bonusNumber;

	public WinningLotto(String winningLottoNumber, String bonusNumber) {
		this.winningLotto = new Lotto(winningLottoNumber);
		this.bonusNumber = new BonusNumber(bonusNumber, winningLotto);
	}

	public Lotto getWinningLotto() {
		return winningLotto;
	}

	public BonusNumber getBonusNumber() {
		return bonusNumber;
	}
}
