package controller;

import domain.Lotto;
import domain.PurchaseAmount;
import domain.PurchaseLotto;
import domain.WinningLotto;
import domain.WinningLottoCalculator;
import view.InputView;
import view.OutputView;

public class LottoStoreController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private PurchaseAmount purchaseAmount;
	private PurchaseLotto purchaseLotto;
	private WinningLotto winningLotto;
	private WinningLottoCalculator winningLottoCalculator;

	public void runLottoGame() {
		try {
			buyLotto();
			showPurchaseLotto();
			initWinningLotto();
			showWinningLotto();
		} catch (NumberFormatException exception) {
			System.out.println("[ERROR] message");
		} catch (IllegalArgumentException exception) {
			System.out.println("[ERROR] message");
		}
	}

	private void buyLotto() {
		purchaseAmount = new PurchaseAmount(inputView.enterAmount());
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
		String inputWinningLotto = inputView.enterWinningLotto();
		outputView.printBlank();
		String inputBonusNumber = inputView.enterBonusNumber();
		outputView.printBlank();

		winningLotto = new WinningLotto(inputWinningLotto, inputBonusNumber);
	}

	private void showWinningLotto() {
		winningLottoCalculator.calculateLottoPrizeCount(purchaseLotto,winningLotto);
		outputView.printLottoPrizes(winningLottoCalculator);
		outputView.printRateOfReturn(winningLottoCalculator, purchaseAmount);
	}
}
