package lotto.view;

public class OutputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String CHECK_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    public static void printInputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }

    public static void printCheckAmount(int amount) {
        System.out.printf(CHECK_AMOUNT_MESSAGE + "%n", amount);
    }
}
