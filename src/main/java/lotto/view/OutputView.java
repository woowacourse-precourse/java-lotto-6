package lotto.view;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.OutputConstants;
import lotto.domain.LottoRank;
import lotto.dto.AutoLottoDto;

public class OutputView {
    private final static String AUTO_BUY_MESSAGE = "%d개를 구매했습니다.\n";
    private final static String WINNING_COUNT_MESSAGE = "당첨 통계\n---\n";
    private final static String RATEOFRESULT_START_MESSAGE = "총 수익률은 %.1f";
    private final static String RATEOFRESULT_END_MESSAGE = "%입니다.";
    private final static int PERCENT = 100;
    private final static int NOTHING = 0;

    public static void printAutoLottos(final AutoLottoDto autoLottos, final int lottoCount) {
        System.out.printf(String.format(AUTO_BUY_MESSAGE, lottoCount));
        StringBuilder result;
        for (List<Integer> lotto : autoLottos.getAutoLottoDto()) {
            result = new StringBuilder();
            result.append(OutputConstants.LOTTO_PRINT_PREFIX.getConstants());
            result.append(lotto.stream().map(String::valueOf)
                    .collect(Collectors.joining(OutputConstants.JOIN_FORMAT.getConstants())));
            result.append(OutputConstants.LOTTO_PRINT_SUFFIX.getConstants());
            System.out.print(result);
            printEmpty();
        }
    }

    public static void printResultCount(final HashMap<LottoRank, Integer> winningCount) {
        System.out.printf(String.format(WINNING_COUNT_MESSAGE));
        StringBuilder result;
        for (int i = 0; i < LottoRank.getMembers().size(); i++) {
            LottoRank match = LottoRank.getMembers().get(i);
            result = new StringBuilder();
            result.append(match.getResultMessage()).append(OutputConstants.SPACE.getConstants());
            result.append(match.getMoneyMessage()).append(OutputConstants.DASH.getConstants());
            int count = findCountByWinningCount(match, winningCount);
            result.append(String.format("%d개", count));
            System.out.print(result);
            printEmpty();
        }
    }

    private static int findCountByWinningCount(final LottoRank match, final HashMap<LottoRank, Integer> winningCount) {
        if (winningCount.containsKey(match)) {
            return winningCount.get(match);
        }
        return NOTHING;
    }

    public static void printRateOfResult(final double rateOfResult) {
        StringBuilder result = new StringBuilder();
        result.append(String.format(RATEOFRESULT_START_MESSAGE, rateOfResult * PERCENT));
        result.append(RATEOFRESULT_END_MESSAGE);
        System.out.println(result);
        printEmpty();
    }

    public static void printEmpty() {
        System.out.println();
    }

    public static void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
