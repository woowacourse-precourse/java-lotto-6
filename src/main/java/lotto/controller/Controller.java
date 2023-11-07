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
		lottoAmountService.setLottoAmount();
		lottoService.createLottos(lottoAmountService.getLottoAmount());
		lottoService.printLottos(lottoAmountService.getLottoAmount());
		lottoService.setUpWinningLotto();
		OutputView.printResult(lottoService.calculateAndGetResult());
	}
}
