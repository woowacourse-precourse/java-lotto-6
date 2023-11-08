package lotto.domain;

import lotto.constants.ResultConfig;
import lotto.constants.StaticMessage;

import java.util.List;

import static lotto.constants.StaticMessage.PRINT_RESULT_NOTICE;

public class OutputHandler {
    public void printMessage(int count) {
        // TODO : "%d개 구매했습니다."
        System.out.println(count + StaticMessage.PRINT_LOTTO_COUNT.getMessage());
    }

    public static void printUserLottos(List<Lotto> lottos) {
        System.out.printf("%n%d개를 구매했습니다.%n", lottos.size());

        lottos.stream()
              .map(Lotto::getNumbers)
              .forEach(System.out::println);
    }

    public static void printResultHistory(User user) {
        System.out.println(PRINT_RESULT_NOTICE.getMessage());
        for (ResultConfig rc : ResultConfig.values()) {
            System.out.println(rc.getMessage() + user.totalResult.get(rc) + "개");
        }
        printTotalProfit(user);
    }

    public static void printTotalProfit(User user) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", ((double) user.totalAmount / user.payment) * 100);
    }

}
