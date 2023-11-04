package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.PurchaseAmountValidator;

public class InputView {

    private final PurchaseAmountValidator purchaseAmountValidator;

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String INPUT_DRAWN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public InputView(PurchaseAmountValidator purchaseAmountValidator) {
        this.purchaseAmountValidator = purchaseAmountValidator;
    }

    public Integer getPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = Console.readLine();
        purchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        return Integer.valueOf(purchaseAmount);
    }

    public String getDrawnNumbers() {
        System.out.println(INPUT_DRAWN_NUMBERS_MESSAGE);
        String drawnNumbers = Console.readLine();
        return drawnNumbers;
    }
}
