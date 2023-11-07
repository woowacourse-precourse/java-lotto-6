package lotto.controller.lotto;

import lotto.controller.InputController;
import lotto.controller.validation.LottoPurchaseMoneyValidator;
import lotto.domain.LottoPurchaseMoney;
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
