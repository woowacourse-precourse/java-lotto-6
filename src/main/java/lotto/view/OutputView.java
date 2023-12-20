package lotto.view;

import static lotto.view.SystemMessage.LOTTO_COUNT_MESSAGE;
import static lotto.view.SystemMessage.PERCENT_MESSAGE;

import java.math.BigDecimal;

public class OutputView {

    public static void printNumbersOfLotto(int count) {
        System.out.printf(LOTTO_COUNT_MESSAGE, count);
    }

    public static void printPercent(BigDecimal percent) {
        System.out.printf(PERCENT_MESSAGE, percent);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
