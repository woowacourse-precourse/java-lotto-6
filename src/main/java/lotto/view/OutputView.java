package lotto.view;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";

    public static void printLottoAmount(int lottoAmount) {
        System.out.println();
        System.out.printf(LOTTO_AMOUNT_MESSAGE, lottoAmount);
        System.out.println();
    }
}