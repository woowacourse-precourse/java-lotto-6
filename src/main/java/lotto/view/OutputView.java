package lotto.view;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
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
        printMessage(GameMessage.PURCHASED_TICKET_COUNT_MESSAGE, ticketCount);
    }

    public static void printUserLottos(List<Lotto> userLottos) {
        for (Lotto lotto : userLottos) {
            lotto.printLottoNumbers();
        }
    }

    public static void printRankCount(Map<Rank, Integer> rankCount) {
        Arrays.stream(Rank.values())
                .sorted(Comparator.comparingInt(Rank::getCountOfMatch))
                .forEach(rank -> printRank(rank, rankCount));
    }

    private static void printRank(Rank rank, Map<Rank, Integer> rankCount) {
        if (rank == Rank.MATCH_5_BONUS) {
            printMatchFiveAndBonusRank(rank, rankCount);
            return;
        }
        printNonMatchFiveAndBonusRank(rank, rankCount);
    }

    private static void printMatchFiveAndBonusRank(Rank rank, Map<Rank, Integer> rankCount) {
        printMessageWithOutLineBreak(GameMessage.RANK_MATCH_5_MESSAGE, rank.getPrizeMoney(),
                rankCount.getOrDefault(rank, 0));
    }

    private static void printNonMatchFiveAndBonusRank(Rank rank, Map<Rank, Integer> rankCount) {
        printMessageWithOutLineBreak(GameMessage.RANK_NOT_MATCH_5_MESSAGE, rank.getCountOfMatch(), rank.getPrizeMoney(),
                rankCount.getOrDefault(rank, 0));
    }

    public static void printWinningStatistics() {
        System.out.println();
        System.out.println(GameMessage.WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println("---");
    }

    public static void printRateOfReturn(double rateOfReturn) {
        NumberFormat nf = Util.createNumberFormatWithFractionDigits(rateOfReturn);
        System.out.println("총 수익률은 " + nf.format(rateOfReturn) + "%입니다.");
    }

    public static void printMessage(GameMessage message, Object... args) {
        System.out.printf(message.getMessage(), args);
        System.out.println();
    }

    public static void printMessageWithOutLineBreak(GameMessage message, Object... args) {
        System.out.printf(message.getMessage(), args);
    }
}
