package lotto.view;

import java.util.List;
import lotto.model.EarningRate;
import lotto.model.Score;

public class OutputView {

    private static final String PRINT_LOTTOS_COUNT = "개를 구매했습니다.";
    private static final String PRINT_WINNING_STATS = "당첨 통계\n---";
    private static final String PREFIX_PRINT_EARNING_RATE = "총 수익률은 ";
    private static final String POSTFIX_PRINT_EARNING_RATE = "입니다.";
    public static final String LINE_BREAK = "\n";

    public void printTicketingLottos(int count, String lottos) {
        System.out.println(LINE_BREAK + count + PRINT_LOTTOS_COUNT);
        System.out.println(lottos);
    }

    public void printScore(List<Score> scores) {
        System.out.println(LINE_BREAK + PRINT_WINNING_STATS);
        System.out.println(Score.stats(scores));
    }

    public void printEarningRate(EarningRate earningRate) {
        System.out.print(PREFIX_PRINT_EARNING_RATE + earningRate + POSTFIX_PRINT_EARNING_RATE);
    }
}
