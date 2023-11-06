package lotto.view;

import static lotto.constants.Phrase.OUTPUT_LOTTO_AMOUNT;
import static lotto.constants.Phrase.OUTPUT_LOTTO_PROFIT;
import static lotto.constants.Phrase.OUTPUT_LOTTO_RESULT;

public class OutputView {
    public static void printPlayerAmount(int amount) {
        System.out.println(OUTPUT_LOTTO_AMOUNT.formatPlayerAmount(amount));
    }

    public static void printPlayerLotto(String lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResult() {
        System.out.println(OUTPUT_LOTTO_RESULT.getPhrase());
    }

    public static void printPrizeMoney(String message) {
        System.out.println(message);
    }

    public static void printPrizeProfit(double rate) {
        System.out.println(OUTPUT_LOTTO_PROFIT.formatPrizeProfit(rate));
    }
}
