package lotto.start;

import lotto.controller.Input;
import lotto.controller.LottoController;

public class LottoGame {

	private Input controller;

	public LottoGame(Input controller) {
		this.controller = controller;
	}

	public void run() {
		controller.purchasePrice();
		controller.winningNumber();
		controller.bonusNumber();
	}

}
