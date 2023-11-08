package lotto.view.output.component;

import lotto.service.dto.GameResult;
import lotto.service.manager.Rank;

import java.util.Map;

public class PrintResultComponent {

    private final String SECOND_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private final String RESULT_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private final String EARNING_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    private final String BAR  = "---";
    private final String STATISTICS_FORMAT = "당첨 통계";

    public void printResult(final GameResult gameResult) {
        printResultHead();
        printAllRankResult(gameResult.rankBoard());
        printEarning(gameResult);
    }

    private void printResultHead() {
        System.out.println();
        System.out.println(STATISTICS_FORMAT);
        System.out.println(BAR);
    }

    private void printAllRankResult(Map<Rank, Long> rankBoard) {
        rankBoard.keySet()
                .forEach(rank -> {
                    printResultEachRank(rank, rankBoard.get(rank));
                });
    }

    private void printResultEachRank(final Rank rank, final Long count) {
        int countForRank = rank.getCountForRank();
        String prizeFormat = rank.getPrizeFormat();

        if (rank == Rank.SECOND) {
            printFormattingResult(
                    SECOND_RESULT_FORMAT, count, countForRank, prizeFormat);
            return;
        }
        printFormattingResult(RESULT_FORMAT, count, countForRank, prizeFormat);
    }

    private void printFormattingResult(
            final String format,
            final Long count,
            final int countForRank,
            final String prizeFormat) {
        System.out.printf(format, countForRank, prizeFormat, count);
    }

    private void printEarning(GameResult gameResult) {
        System.out.printf(EARNING_FORMAT, gameResult.earningRate());
    }
}
