package lotto.output;

import java.util.Map;
import lotto.domain.Lotteries;
import lotto.domain.Rank;

public class Output {
    public static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_LOTTO_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void print(final String message) {
        System.out.println(message);
    }

    public static void printLotteries(final Lotteries lotteries) {
        System.out.println(lotteries);
        System.out.println();
    }

    public static void printWinningStatics(final Map<Rank, Integer> rankIntegerMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        rankIntegerMap.keySet()
                .forEach(rank -> System.out.printf(rank + " - %d개%n", rankIntegerMap.get(rank)));
    }
}
