package lotto.view;

import lotto.constant.Rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class OutputView extends ConsoleView {

    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String RESULT_HEADER = "당첨 통계";
    private static final String DIVISION_LINE = "---";
    private static final String RESULT_FORMAT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RESULT_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String ROI_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final String PRIZE_WITH_COMMA = "%,d";

    public void displayLottos(List<String> purchasedLotto) {
        println(String.format(LOTTO_COUNT_MESSAGE, purchasedLotto.size()));
        purchasedLotto.forEach(this::println);
        this.lineBreak();
    }

    public void displayResults(List<Rank> ranks, double roi) {
        println(RESULT_HEADER);
        println(DIVISION_LINE);

        Rank[] reversedRanks = Rank.values();
        Arrays.sort(reversedRanks, Collections.reverseOrder());

        for (Rank rank : reversedRanks) {
            if (rank != Rank.NONE) {
                int count = (int) ranks.stream()
                    .filter(rank::equals)
                    .count();
                String format = rank == Rank.SECOND ? RESULT_FORMAT_WITH_BONUS : RESULT_FORMAT;
                println(String.format(format, rank.getMatchCount(), String.format(PRIZE_WITH_COMMA, rank.getPrize()), count));
            }
        }
        println(String.format(ROI_FORMAT, roi));
    }

    public void displayErrorMessage(String message) {
        println(String.format(ERROR_PREFIX, message));
    }
}
