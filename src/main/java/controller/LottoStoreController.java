package controller;

import domain.Lotto;
import domain.PurchaseAmount;
import domain.PurchaseLotto;
import view.InputView;
import view.OutputView;

public class LottoStoreController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private PurchaseAmount purchaseAmount;
	private PurchaseLotto purchaseLotto;

	public void runLottoGame() {
		try {
			buyLotto();
			showPurchaseLotto();
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

}
