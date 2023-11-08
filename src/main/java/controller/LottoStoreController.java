package controller;

import domain.BonusNumber;
import domain.Lotto;
import domain.PurchaseAmount;
import domain.PurchaseLotto;
import domain.WinningLotto;
import domain.WinningLottoCalculator;
import service.LottoService;
import view.InputView;
import view.OutputView;

public class LottoStoreController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private PurchaseAmount purchaseAmount;
	private PurchaseLotto purchaseLotto;
	private WinningLotto winningLotto;
	private WinningLottoCalculator winningLottoCalculator = new WinningLottoCalculator();
	private LottoService lottoService = new LottoService();

	public void runLottoGame() {
		buyLotto();
		showPurchaseLotto();
		initWinningLotto();
		showWinningLotto();
	}

	private void buyLotto() {
		purchaseAmount = lottoService.setPurchaseAmount();
		outputView.printBlank();

		purchaseLotto = new PurchaseLotto(purchaseAmount);
	}

	private void showPurchaseLotto() {
		outputView.printPurchaseAmount(purchaseAmount);
		for (Lotto lotto : purchaseLotto.getLottos()) {
			outputView.printLotto(lotto);
		}

		outputView.printBlank();
	}

	private void initWinningLotto() {
		Lotto lotto = lottoService.setWinningLotto();
		outputView.printBlank();
		BonusNumber bonusNumber = lottoService.setBonusNumber(lotto);
		outputView.printBlank();

		winningLotto = new WinningLotto(lotto, bonusNumber);
	}

	private void showWinningLotto() {
		winningLottoCalculator.calculateLottoPrizeCount(purchaseLotto, winningLotto);
		outputView.printLottoPrizes(winningLottoCalculator);
		outputView.printRateOfReturn(winningLottoCalculator, purchaseAmount);
	}
}
