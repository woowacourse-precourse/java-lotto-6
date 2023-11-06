package lotto;

import lotto.domain.Purchase;
import lotto.validate.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    InputValidation inputValidation;
    Purchase purchase;
    OutputView outputView;
    public LottoGame(InputView inputView, Lotto lotto) {
        inputView.printInputPurchaseAmountMessage();
        String purcahseAmount = inputView.inputPurchaseAmount();

        try {
            inputValidation.validatePhurchaseAmount(purcahseAmount);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            inputView.printInputPurchaseAmountMessage(); // 다시 입력 받기
            purcahseAmount = inputView.inputPurchaseAmount();
        }
        outputView.printPurchaseQyantity(purchase.getQuantity()); // 구입수량 안내 msg


    }
}
