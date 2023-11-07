package lotto.controller;

import lotto.service.LottoAmountService;
import lotto.service.LottoService;

public class Controller {
	private LottoAmountService lottoAmountService;
	private LottoService lottoService;

	public Controller() {
		this.lottoAmountService = new LottoAmountService();
		this.lottoService = new LottoService();
	}

	public void run() {
		lottoAmountService.setLottoAmount();
		lottoService.createLotto(lottoAmountService.getLottoAmount());
		lottoService.printLottos(lottoAmountService.getLottoAmount());
		lottoService.setUpWinningAndBonusLotto();
		lottoService.calculateWinningLotto();
	}
}
