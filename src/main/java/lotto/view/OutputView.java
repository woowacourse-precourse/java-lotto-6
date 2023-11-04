package lotto.view;

import static lotto.constants.Phrase.OUTPUT_LOTTO_AMOUNT;
import static lotto.constants.Phrase.OUTPUT_LOTTO_RESULT;

public class OutputView {
    public static void printPlayerAmount(int amount) {
        System.out.println(OUTPUT_LOTTO_AMOUNT.formatAmount(amount));
    }

    public static void printPlayerLotto(String lotto) {
        System.out.println(lotto);
    }

    public static void printPrizeResult() {
        System.out.println(OUTPUT_LOTTO_RESULT.getPhrase());
    }

    public static void printPrizeLotto(String message) {
        System.out.println(message);
    }
}
