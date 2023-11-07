package lotto.view;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_MESSAGE = "\n%d개를 구매했습니다.";

    public static void printNumberOfLottoPurchased(int numberOfLottosPurchased) {
        System.out.printf(NUMBER_OF_LOTTOS_PURCHASED_MESSAGE, numberOfLottosPurchased);
    }
}
