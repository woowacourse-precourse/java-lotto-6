package lotto.view;

import java.math.BigDecimal;

public class OutputView {

    public static void printNumbersOfLotto(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void printPercent(BigDecimal percent) {
        System.out.printf("총 수익률은 %.1f%%입니다.", percent);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
