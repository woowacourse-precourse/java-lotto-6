package lotto;

import camp.nextstep.edu.missionutils.Console;
import constValue.ConstMessage;

public class LottoGame {
    public LottoGame() {
        System.out.println("구입금액을 입력해 주세요.");
        enterPurchaseAmount();
    }

    public Integer enterPurchaseAmount() {
        try {
            return Integer.parseInt(validatePurchaseAmount(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(ConstMessage.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE.getMessage());
            return enterPurchaseAmount();
        }
    }

    private String validatePurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount.matches("[1-9]+000")) {
            return purchaseAmount;
        }
        throw new IllegalArgumentException();
    }
}
