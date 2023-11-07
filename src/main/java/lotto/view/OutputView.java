package lotto.view;

import java.util.List;
import lotto.domain.Lottos;

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

    public static void printIssuedLottosInformation(Lottos lottos) {
        printNewEmptyLine();

        List<List<Integer>> lottosNumbers = lottos.getLottosNumbers();
        printNumberOfLottoPurchased(lottosNumbers.size());

        for (List<Integer> lottoNumbers : lottosNumbers) {
            System.out.println(lottoNumbers);
        }
        printNewEmptyLine();
    }

    private static void printNewEmptyLine() {
        System.out.println();
    }
}
