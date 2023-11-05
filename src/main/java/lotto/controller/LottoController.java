package lotto.controller;

import lotto.domain.ReadPurchaseAmount;
import lotto.view.InputMessage;

public class LottoController {
    InputMessage inputMessage = new InputMessage();

    public void LottoGameStart() {
        enterLottoPurchaseAmount();
    }

    private void enterLottoPurchaseAmount() {
        while (true) {
            try {
                String readAmount = inputMessage.readLottoPurchaseAmount();
                ReadPurchaseAmount readPurchaseAmount = new ReadPurchaseAmount(readAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
