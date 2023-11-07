package lotto.domain;

import lotto.constants.ResultConfig;
import lotto.constants.StaticMessage;

import java.util.List;

public class OutputHandler {
    public void printMessage(int count) {
        // TODO : "%d개 구매했습니다."
        System.out.println(count + StaticMessage.PRINT_LOTTO_COUNT.getMessage());
    }

    public static void printNumbersOfLottos(List<List<Integer>> lottos) {
        System.out.println("%n%d개를 구매했습니다.".formatted(lottos.size()));
        lottos.forEach(System.out::println);
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
