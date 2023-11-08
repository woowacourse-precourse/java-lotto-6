package lotto.view;

public class OutputView {

    private static final String LOTTO_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";


    public static void printLottoPurchaseMoneyMessage() {
        System.out.println(LOTTO_PURCHASE_MONEY_MESSAGE);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
