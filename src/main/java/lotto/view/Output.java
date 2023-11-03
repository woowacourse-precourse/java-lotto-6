package lotto.view;

import lotto.domain.PurchasePrice;

public class Output {
    private final String REQUEST_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String PURCHASE_COUNT_DEFAULT_MESSAGE = "개를 구매했습니다.";

    public static void errorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void requestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE_MESSAGE);
    }

    public void purchaseCount(PurchasePrice purchasePrice) {
        System.out.println(purchasePrice.calculatePurchaseCount() + PURCHASE_COUNT_DEFAULT_MESSAGE);
    }
}
