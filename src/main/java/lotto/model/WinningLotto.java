package lotto.model;

import lotto.view.InputView;

public class WinningLotto {
	private Lotto winningLotto;

	public WinningLotto() {
		winningLotto = new Lotto(InputView.inputWinningNumber());
	}

	public int grade(Lotto lotto) {
		return winningLotto.countLotto(lotto);
	}

	public boolean contains(int number) {
		return winningLotto.contains(number);
	}
}
