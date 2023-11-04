package lotto.controller;

import static lotto.config.GameNumberConfig.LOTTO_PRICE;
import static lotto.view.constants.OutputMessage.PURCHASE_MESSAGE;

import lotto.view.OutputView;
import lotto.view.constants.OutputMessage;
import lotto.view.validator.PurchasePriceValidator;
import lotto.view.InputView;

public class LottoGame {

    public void run() {
        int purchasePrice = InputView.inputPurchasePrice();
        String purchaseMessage = String.format(
                PURCHASE_MESSAGE.getMessage(),
                purchasePrice/LOTTO_PRICE.getNumber()
        );
        OutputView.printMessage(purchaseMessage);


    }

}
