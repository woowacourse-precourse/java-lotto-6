package lotto.view;

import lotto.domain.*;

import java.util.Arrays;

import static lotto.domain.Prize.NOTHING;
import static lotto.domain.Prize.SECOND;

public class ResultView {
    private static final String BUY_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_RESULT_MESSAGE = "\n당첨 통계";
    private static final String WIN_RESULT_MESSAGE_SPLITTER = "---";
    private static final String CORRECT_COUNT = "%d개 일치";
    private static final String BONUS_COUNT = ", 보너스 볼 일치";
    private static final String WIN_PRICE_AND_WIN_COUNT = " (%s원) - %d개";
    private static final String RETURN_RATE_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    public static void printTicket(int ticket) {
        System.out.println();
        System.out.println(ticket + BUY_AMOUNT_MESSAGE);
    }

    public static void showLottoNumbers(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
    }

    public static void showResult(PrizeResult prizeResult) {
        System.out.println(WIN_RESULT_MESSAGE);
        System.out.println(WIN_RESULT_MESSAGE_SPLITTER);
        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(NOTHING))
                .forEach(prize -> {
                    int count = prizeResult.getPrizeResult().getOrDefault(prize, 0);
                    System.out.printf(CORRECT_COUNT, prize.getMatchedCount());
                    if (prize.equals(SECOND)) {
                        System.out.print(BONUS_COUNT);
                    }
                    System.out.printf(WIN_PRICE_AND_WIN_COUNT, String.format("%,d", prize.getPrizeAmount()), count);
                    System.out.println();
                });
    }

    public static void showReturnRate(PrizeResult prizeResult, Money money) {
        System.out.printf(RETURN_RATE_MESSAGE, prizeResult.calculateReturnRate(PrizeResult.getPrizeResult(), money));
    }
}
