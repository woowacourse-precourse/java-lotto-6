package lotto.controller;

import lotto.service.LottoAmountService;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class Controller {
	private LottoAmountService lottoAmountService;
	private LottoService lottoService;

	public Controller() {
		this.lottoAmountService = new LottoAmountService();
		this.lottoService = new LottoService();
	}

	public void run() {
		createAndShowLotto(getLottoAmountByUser());
		setUpWinningLotto();
		showResult();
	}

	private int getLottoAmountByUser() {
		lottoAmountService.setUpLottoAmount();
		return lottoAmountService.getLottoAmount();
	}

	private void createAndShowLotto(int amount) {
		lottoService.createLottos(amount);
		lottoService.printLottos(amount);
	}

	private void setUpWinningLotto() {
		lottoService.setUpWinningLotto();
	}

	private void showResult() {
		OutputView.printResult(lottoService.calculateAndGetResult());
		OutputView.printRateOfReturn(lottoService.getRateOfReturn(lottoAmountService.getInputMoney()));
	}
}
