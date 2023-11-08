package lotto.controller.lotto;

import lotto.controller.input.InputController;
import lotto.controller.validation.money.LottoPurchaseMoneyValidator;
import lotto.model.lotto.LottoPurchaseMoney;
import lotto.view.MessageOutputView;

public class LottoPurchaseMoneyScanController {
	MessageOutputView messageOutputView = new MessageOutputView();
	InputController inputController = new InputController();
	LottoPurchaseMoneyValidator lottoPurchaseMoneyValidator = new LottoPurchaseMoneyValidator();
	public void scanLottoPurchaseMoney(LottoPurchaseMoney lottoPurchaseMoney) {
		try{
			messageOutputView.printScanningLottoPurchaseMoneyMessage();
			String scannedPurchaseMoneyString = inputController.scanLottoPurchaseMoneyString();
			lottoPurchaseMoneyValidator.checkValidatioOfLottoPurchaseMoney(scannedPurchaseMoneyString);
			Integer scannedPurchaseMoney = Integer.parseInt(scannedPurchaseMoneyString);
			lottoPurchaseMoney.setLottoPurchaseMoney(scannedPurchaseMoney);
		}
		catch(IllegalArgumentException illegalArgumentException){
			scanLottoPurchaseMoney(lottoPurchaseMoney);
		}
	}
}
