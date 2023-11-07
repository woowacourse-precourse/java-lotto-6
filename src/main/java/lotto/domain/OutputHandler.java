package lotto.domain;

import lotto.constants.ResultConfig;
import lotto.constants.StaticMessage;

public class OutputHandler {
    public void printMessage(int count) {
        // TODO : "%d개 구매했습니다."
        System.out.println(count + StaticMessage.PRINT_LOTTO_COUNT.getMessage());
    }

    public static void printResultHistory() {
        for (ResultConfig rc: ResultConfig.values()) {
            System.out.println(rc.getMessage());
        }
    }

    public static void printTotalProfit(double profit) {
        System.out.println("총 수익률은 %.1f%%입니다.".formatted(profit * 100));
    }

}
