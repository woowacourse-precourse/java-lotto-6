package lotto.view;

public class OutputView {
    private static final int DIVIDER_FOR_COUNT_PURCHASE_AMOUNT = 1000;
    private static final String PURCHASE_COUNT_ALERT = "개를 구매했습니다.";


    public static void printPurchaseAmount(int purchaseMoney){
        int purchaseAmount = purchaseMoney / DIVIDER_FOR_COUNT_PURCHASE_AMOUNT;
        System.out.println(purchaseAmount + PURCHASE_COUNT_ALERT);
    }
}
