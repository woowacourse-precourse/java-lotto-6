package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	public void startGame() {
		int amount = Integer.parseInt(InputView.inputAmountOfMoney());
		OutputView.printLottoAmount(amount);


	}
}
