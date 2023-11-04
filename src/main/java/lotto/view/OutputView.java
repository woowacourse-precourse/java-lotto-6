package lotto.view;

import static lotto.constants.Phrase.OUTPUT_LOTTO_AMOUNT;

public class OutputView {
    public static void printPlayerAmount(int amount) {
        System.out.println(OUTPUT_LOTTO_AMOUNT.formatAmount(amount));
    }

    public static void printPlayerLotto(String lotto) {
        System.out.println(lotto);
    }
}
