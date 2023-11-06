package lotto.view;

public final class LottoOutputView {
    private final static String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    private LottoOutputView() {
    }

    public static void printPurchasePriceMessage() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
    }

}
