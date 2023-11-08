package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.ProfitRate;
import lotto.domain.Ranking;

import java.util.Arrays;

import static lotto.view.Constants.REQUEST_BUY_MONEY;
import static lotto.view.Constants.TICKET_COUNT;
import static lotto.view.Constants.REQUEST_WINNING_NUMBERS;
import static lotto.view.Constants.REQUEST_BONUS_NUMBERS;
import static lotto.view.Constants.WINNING_STATISTICS;
import static lotto.view.Constants.MATCH_RESULT;
import static lotto.view.Constants.SECOND_MATCH_RESULT;
import static lotto.view.Constants.PROFIT_RATE;

public class OutputView {
    public static void printRequestMoney() {
        System.out.println(REQUEST_BUY_MONEY);
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + TICKET_COUNT);
    }

    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBERS);
    }

    public static void printBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBERS);
    }

    public static void printStatistics(Prize prize, ProfitRate profitRate) {
        System.out.println(WINNING_STATISTICS);
        Arrays.stream(Ranking.values())
                .filter(ranking -> !ranking.equals(Ranking.NOTHING))
                .forEach(ranking -> System.out.println(getPrintResultPrize(ranking, prize)));
        System.out.printf((PROFIT_RATE) + "\n", profitRate.getRate());
    }

    private static String getPrintResultPrize(Ranking ranking, Prize prize) {
        if (ranking == Ranking.SECOND) {
            return String.format(SECOND_MATCH_RESULT,
                    ranking.getMatchLottoNumber(),
                    String.format("%,d", ranking.getMoney()),
                    prize.getPrizeCount(ranking));
        }

        return String.format(MATCH_RESULT,
                ranking.getMatchLottoNumber(),
                String.format("%,d", ranking.getMoney()),
                prize.getPrizeCount(ranking));
    }

}
