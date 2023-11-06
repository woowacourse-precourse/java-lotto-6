package lotto.view;

public class OutputView {
    public static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void printLottoAmount(int count) {
        System.out.println();
        System.out.println(count + LOTTO_AMOUNT_MESSAGE);
    }

    public static void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinning(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

}
