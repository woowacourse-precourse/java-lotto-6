package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.utils.GameMessage;
import lotto.utils.Util;

public class OutputView {
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println();
        System.out.printf(GameMessage.PURCHASED_TICKET_COUNT_MESSAGE.getMessage(), ticketCount);
        System.out.println();
    }

    public static void printUserLottos(List<Lotto> userLottos) {
        for (Lotto lotto : userLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printRankCount(Map<Rank, Integer> rankCount) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MATCH_5_BONUS) {
                printMatchFiveAndBonusRank(rank, rankCount);
                continue;
            }
            if (rank != Rank.MATCH_5_BONUS) {
                printNonMatchFiveAndBonusRank(rank, rankCount);
            }
        }
    }

    private static void printMatchFiveAndBonusRank(Rank rank, Map<Rank, Integer> rankCount) {
        System.out.printf(GameMessage.RANK_MATCH_5_MESSAGE.getMessage(), rank.getPrizeMoney(),
                rankCount.getOrDefault(rank, 0));
    }

    private static void printNonMatchFiveAndBonusRank(Rank rank, Map<Rank, Integer> rankCount) {
        System.out.printf(GameMessage.RANK_NOT_MATCH_5_MESSAGE.getMessage(), rank.getCountOfMatch(),
                rank.getPrizeMoney(),
                rankCount.getOrDefault(rank, 0));
    }

    public static void printWinningStatistics() {
        System.out.println();
        System.out.println(GameMessage.WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println("---");
    }

    public static void printRateOfReturn(double RateOfReturn) {
        NumberFormat nf = Util.createNumberFormatWithFractionDigits(RateOfReturn);
        System.out.println("총 수익률은 " + nf.format(RateOfReturn) + "%입니다.");
    }
}
