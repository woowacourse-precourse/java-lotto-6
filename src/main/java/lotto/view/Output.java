package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.PurchaseResult;

public class Output {
    public static final String AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASED_LOTTO_MESSAGE = "개를 구매했습니다.";

    public static void printAmountMessage() {
        System.out.println(AMOUNT_MESSAGE);
    }

    public static void printPurchasedLottos(PurchaseResult purchaseResult) {
        System.out.println(purchaseResult.getLottosCount() + PURCHASED_LOTTO_MESSAGE);

        for (Lotto lotto : purchaseResult.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
