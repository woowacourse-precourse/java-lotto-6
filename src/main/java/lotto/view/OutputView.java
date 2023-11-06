package lotto.view;

public class OutputView {

    private static final String NUMBER_OF_LOTTO_PURCHASED_MESSAGE = "%d개를 구매했습니다.";

    private OutputView() {
    }

    private static void printWithFormat(String message, Object... args) {
        System.out.println(String.format(message, args));
    }

    private static void printNumberOfLottoPurchased(int numberOfLottoPurchased) {
        printWithFormat(NUMBER_OF_LOTTO_PURCHASED_MESSAGE, numberOfLottoPurchased);
    }
}
