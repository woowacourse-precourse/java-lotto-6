package lotto.output;

import java.util.Map;
import lotto.domain.Lotteries;
import lotto.domain.Profit;
import lotto.domain.Rank;
import lotto.domain.UserLotto;

public class Output {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_LOTTO_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTERIES_MESSAGE_FORMAT = "%d개를 구매했습니다.%n";
    private static final String WINNING_STATICS_INTRO_MESSAGE = """
            당첨 통계
            ---
            """;
    private static final String WINNING_STATICS_FORMAT = " - %d개%n";
    private static final String PROFIT_FORMAT = "총 수익률은 %s%%입니다.%n";

    public static void print(final String message) {
        System.out.println(message);
    }

    public static void printMoneyInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public static void printLottoNumbersInputMessage() {
        System.out.println();
        System.out.println(LOTTO_NUMBERS_INPUT_MESSAGE);
    }

    public static void printBonusLottoNumberInputMessage() {
        System.out.println();
        System.out.println(BONUS_LOTTO_NUMBER_INPUT_MESSAGE);
    }

    public static void printLotteries(final Lotteries lotteries) {
        System.out.println();
        System.out.printf(LOTTERIES_MESSAGE_FORMAT, lotteries.getSize());
        System.out.print(lotteries);
    }

    public static void printWinningStatics(final Map<Rank, Integer> rankIntegerMap) {
        System.out.println();
        System.out.print(WINNING_STATICS_INTRO_MESSAGE);
        rankIntegerMap.keySet()
                .forEach(rank -> System.out.printf(rank + WINNING_STATICS_FORMAT, rankIntegerMap.get(rank)));
    }

    public static void printProfit(final Profit profit, final UserLotto userLotto) {
        System.out.printf(PROFIT_FORMAT, profit.calculate(userLotto).toString());
    }
}
