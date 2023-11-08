package lotto.view;

public class OutputViewLottoCount {
    private static final String PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void printLottoCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_AMOUNT_MESSAGE);
    }
}
