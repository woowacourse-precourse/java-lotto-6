package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningRank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputProcessor {
    private static final String ENTER = "\n";
    private static final String PURCHASE_INFORMATION_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_FORMAT = "%s (%s원) - %d개";
    private static final String REWARD_FORMAT = "#,###";
    private static final String EARNING_FORMAT = "총 수익률은 %s%%입니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    private OutputProcessor() {
    }

    public static void printPurchaseInformation(final List<Lotto> userLottos) {
        System.out.println(String.format(PURCHASE_INFORMATION_FORMAT, userLottos.size()));
        userLottos.forEach(System.out::println);
    }


    public static void printWinningStatistics(final LottoStatistics lottoStatistics) {
        final StringBuilder result = new StringBuilder()
                .append("당첨 통계")
                .append(ENTER)
                .append("---")
                .append(ENTER);
        addWinningStatistics(result, lottoStatistics);
        addEarningRate(result, lottoStatistics);
        System.out.println(result);
    }

    private static void addWinningStatistics(final StringBuilder result, final LottoStatistics lottoStatistics) {
        final List<WinningRank> filteredWinningRank = getFilteredWinningRank();
        for (final WinningRank winningRank : filteredWinningRank) {
            result.append(String.format(
                    WINNING_FORMAT,
                    winningRank.getDescription(),
                    refineReward(winningRank.getReward()),
                    lottoStatistics.getWinningCountByRank(winningRank)
            )).append(ENTER);
        }
    }

    private static List<WinningRank> getFilteredWinningRank() {
        return Arrays.stream(WinningRank.values())
                .filter(winningRank -> winningRank != WinningRank.NONE)
                .sorted(Collections.reverseOrder()) // Enum Position DESC
                .toList();
    }

    private static String refineReward(final int reward) {
        return new DecimalFormat(REWARD_FORMAT).format(reward);
    }

    private static void addEarningRate(final StringBuilder result, final LottoStatistics lottoStatistics) {
        result.append(String.format(EARNING_FORMAT, lottoStatistics.calculateEarningRate()));
    }

    public static void printErrorMessage(final String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
