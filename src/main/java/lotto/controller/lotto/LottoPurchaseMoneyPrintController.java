package lotto.controller.lotto;

import lotto.model.lotto.LottoPurchaseMoney;
import lotto.view.ProcessedValueOutputView;

public class LottoPurchaseMoneyPrintController {

	ProcessedValueOutputView processedValueOutputView = new ProcessedValueOutputView();

	public void printLottoPurchaseMoney(LottoPurchaseMoney lottoPurchaseMoney) {
		processedValueOutputView.printLottoPurchaseMoney(
			lottoPurchaseMoney.getLottoPurchaseMoney());
	}
}
