package lotto.view;

import java.math.BigDecimal;

public class OutputView {

    public static void printNumberOfLottoTickets(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printRateOfReturn(BigDecimal percent) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", percent);
    }

    public static void printError(String message) {
        System.out.printf("[ERROR] %s\n", message);
    }
}
