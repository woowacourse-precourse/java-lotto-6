package lotto.model;

import lotto.view.InputView;

public class BonusNumber {
	private int bonusNumber;

	public BonusNumber() {
		this.bonusNumber = InputView.inputBonusNumber();
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
