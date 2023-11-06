package lotto.view;

public class OutputView {

    private static final String TYPE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static void printPurchaseAmount() {
        System.out.println(TYPE_PURCHASE_AMOUNT);
    }

    public static void printPurchaseCount(int count) {
        blankSpace();
        System.out.printf("%d개를 구매했습니다." , count);
    }

    private static void blankSpace() {
        System.out.println();
    }

}
