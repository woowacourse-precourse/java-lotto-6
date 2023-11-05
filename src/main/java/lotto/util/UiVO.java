package lotto.util;

import java.util.Map;

public class UiVO {

    public static enum MatchType {
        THREE, FOUR, FIVE, FIVE_BONUS, SIX
    }

    private static final String PURCHASE_AMOUNT_INPUT_TEXT = "구입금액을 입력해 주세요.";
    private static final String BOUGHT_LOTTO_CNT = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT_TEXT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_TEXT = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String MATCHES_FORMAT = "%s개 일치 (%s원) - %d개\n";
    private static final String TOTAL_RETURN_FORMAT = "총 수익률은 %f입니다.";

    public static String printPurchaseAmountInputText() {
        return PURCHASE_AMOUNT_INPUT_TEXT;
    }

    public static String printBoughtLottoCnt(int count) {
        return count + BOUGHT_LOTTO_CNT;
    }

    public static String printWinningNumberInputText() {
        return WINNING_NUMBER_INPUT_TEXT;
    }

    public static String printBonusNumberInputText() {
        return BONUS_NUMBER_INPUT_TEXT;
    }

    public static String printWinningStatistics(Map<MatchType, Integer> winningStatistics) {
        return new StringBuilder(WINNING_STATISTICS)
                .append(String.format(MATCHES_FORMAT, "3", "5,000", winningStatistics.get(MatchType.THREE)))
                .append(String.format(MATCHES_FORMAT, "4", "50,000", winningStatistics.get(MatchType.FOUR)))
                .append(String.format(MATCHES_FORMAT, "5", "1,500,000", winningStatistics.get(MatchType.FIVE)))
                .append(String.format(MATCHES_FORMAT, "5", "30,000,000", winningStatistics.get(MatchType.FIVE_BONUS)))
                .append(String.format(MATCHES_FORMAT, "6", "2,000,000,000", winningStatistics.get(MatchType.SIX)))
                .toString();
    }

    public static String printTotalReturn(double totalReturn) {
        return String.format(TOTAL_RETURN_FORMAT, totalReturn);
    }
}
