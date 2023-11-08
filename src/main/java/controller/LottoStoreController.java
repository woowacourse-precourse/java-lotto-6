package controller;

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

}
