package lotto.controller;

import lotto.domain.PurchaseNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void start() {
		int buyAmount = InputView.inputPurchaseAmout();
		int lottoCount = PurchaseNumber.buyCount(buyAmount);
		OutputView.buyLotto(lottoCount);
		InputView.inputWinningNumber();
		OutputView.totalRateOfReturn();
	}

}
