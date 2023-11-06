package lotto.io.write;

import static lotto.io.message.InputMessage.READ_PURCHASE_AMOUNT_MESSAGE;

public final class LottoOutputWriter {
    public static void showPurchaseAmountMessage() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }
}
