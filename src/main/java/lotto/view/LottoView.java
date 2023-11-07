package lotto.view;

public class LottoView {
    private static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT = "개를 구매했습니다.";

    public static void printPurchasePrompt() {
        System.out.println(PURCHASE_PRICE);
    }

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COUNT);
    }

}
