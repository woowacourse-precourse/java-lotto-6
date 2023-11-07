package lotto.output;

import lotto.input.PurchaseHandler;

import static lotto.output.Constants.LottoConstants.LOTTO_COUNT_MESSAGE;
import static lotto.output.Constants.PurchaseHandlerConstants.AMOUNT_INPUT;

public class PurchaseResultHandler {
    public static int purchaseRequest() {
        System.out.println(AMOUNT_INPUT);
        int amount = getValidAmount();
        System.out.println();
        return numberOfLotto(amount);
    }


    private static int getValidAmount() {
        int amount = 0;
        while (true) {
            try {
                amount = PurchaseHandler.getAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }

    private static int numberOfLotto(int amount) {
        int lotto = amount / 1000;
        System.out.println(lotto + LOTTO_COUNT_MESSAGE);
        return lotto;
    }
}
