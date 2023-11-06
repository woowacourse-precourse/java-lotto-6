package lotto;

import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import static lotto.constant.LottoErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE;

public class LottoSimulation {
    private final LottoOutputView outputView = new LottoOutputView();
    private final LottoInputView inputView = new LottoInputView(outputView);

    public void execute() {
        Amount amount = readPurchaseAmount();
    }

    private Amount readPurchaseAmount() {
        while (true) {
            try {
                return new Amount(Integer.parseInt(inputView.readPurchaseAmount()));
            } catch (IllegalArgumentException e) {
                outputView.printMessage(PURCHASE_AMOUNT_ERROR_MESSAGE);
            }
        }

    }
}
